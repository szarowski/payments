package com.payments.util;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.payments.util.CharacterType.LOWER_CASE;
import static com.payments.util.CharacterType.NUMERIC;
import static com.payments.util.CharacterType.UPPER_CASE;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.toSet;

public class Random {

    private static final SecureRandom RND = new SecureRandom();
    private static final String NUM = NUMERIC.getCharacters();
    private static final String ALPHA_NUM = NUMERIC.getCharacters() + UPPER_CASE.getCharacters() + LOWER_CASE.getCharacters();

    //ALPHA3 to ALPHA2 country code map
    private static final Map<String, String> COUNTRIES = Arrays.stream(Locale.getISOCountries()).map(
            c -> new AbstractMap.SimpleImmutableEntry<>(new Locale("",c).getISO3Country(), c))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static int intVal() { return intVal(1000); }
    public static int intVal(final int max) { return max == 0 ? 0 : RND.nextInt(max); }

    public static BigDecimal amountVal() { return new BigDecimal(intVal(1000) / 100); }

    public static BigDecimal exchangeRateVal() { return new BigDecimal(intVal(1000000) / 100000); }

    public static String string() { return string(8); }
    public static String string(final int length) {
        return RND.ints(length, (int) '!', ((int) '~') + 1)
                .mapToObj((i) -> (char) i)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
                .trim();
    }

    public static String alphaNumeric() { return alphaNumeric(8); }
    public static String alphaNumeric(final int length) {
        return RND.ints(length, 0, ALPHA_NUM.length())
                .mapToObj(ALPHA_NUM::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static String numeric() { return numeric(8); }
    public static String numeric(final int length) {
        return RND.ints(length, 0, NUM.length())
                .mapToObj(NUM::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static boolean bool() { return RND.nextBoolean(); }

    public static UUID uuid() { return UUID.randomUUID(); }

    public static String domain() { return alphaNumeric().toLowerCase() + value(".cz", ".co.uk", ".com", ".london"); }
    public static String url() { return value("http://", "https://") + domain(); }

    @SafeVarargs
    public static <T> T value(final T... values) { return values[intVal(values.length)]; }

    @SuppressWarnings("unchecked")
    public static <T> T value(final Collection<T> values) {
        return (T) values.toArray()[intVal(values.size())];
    }

    @SuppressWarnings("unchecked")
    public static <T> Set<T> set(final T... values) {
        final Set<T> set = Stream.of(values).filter(v -> Random.bool()).collect(toSet());
        return set.isEmpty() ? Collections.singleton(values[0]) : set;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> list(final T... values) {
        return new ArrayList<>(set(values));
    }

    public static Currency currency() { return value(Currency.getAvailableCurrencies()); }

    public static String country() { return value(COUNTRIES.keySet()); }

    public static Date pastDate() { return Date.from(pastLocalDate().atStartOfDay()
            .atZone(ZoneOffset.UTC).toInstant());
    }

    public static LocalDate pastLocalDate() { return LocalDate.now().minusDays((long)intVal()); }

    public static OffsetDateTime pastOffsetDateTime() { return OffsetDateTime.now(ZoneOffset.UTC).minusDays((long)intVal()); }

    public static String accountNumber() {
        return accountNumber(Random.country());
    }

    public static String accountNumber(final String country) {
        return "GBR".equals(country) || "USA".equals(country) ?
                Random.numeric() : COUNTRIES.get(country) + Random.numeric(22);
    }
}