package com.payments.transform;

import com.payments.model.SenderChargesJson;
import com.payments.model.internal.SenderCharges;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SenderChargesJsonTransformerImpl implements SenderChargesJsonTransformer {

    @Override
    public List<SenderCharges> toSenderCharges(UUID id, List<SenderChargesJson> data) {
        return data.stream().map(d -> new SenderCharges(id,
                d.getAmount().multiply(new BigDecimal(100)).toBigInteger().intValue(),
                d.getCurrency())).collect(Collectors.toList());
    }
}