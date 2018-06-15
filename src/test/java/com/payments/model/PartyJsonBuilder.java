package com.payments.model;

import com.payments.util.Random;

public final class PartyJsonBuilder {

    private String accountName = Random.string();
    private String accountNumber = Random.accountNumber();
    private String accountNumberCode = Random.string(64);
    private Integer accountType = Random.intVal();
    private String address = Random.string();
    private String bankId = Random.string(64);
    private String bankIdCode = Random.string(64);
    private String name = Random.string();

    private PartyJsonBuilder() {
    }

    public static PartyJsonBuilder partyJsonBuilder() {
        return new PartyJsonBuilder();
    }

    public PartyJsonBuilder accountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public PartyJsonBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public PartyJsonBuilder accountNumberCode(String accountNumberCode) {
        this.accountNumberCode = accountNumberCode;
        return this;
    }

    public PartyJsonBuilder accountType(Integer accountType) {
        this.accountType = accountType;
        return this;
    }

    public PartyJsonBuilder address(String address) {
        this.address = address;
        return this;
    }

    public PartyJsonBuilder bankId(String bankId) {
        this.bankId = bankId;
        return this;
    }

    public PartyJsonBuilder bankIdCode(String bankIdCode) {
        this.bankIdCode = bankIdCode;
        return this;
    }

    public PartyJsonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PartyJson build() {
        return new PartyJson(accountName, accountNumber, accountNumberCode, accountType, address, bankId, bankIdCode, name);
    }
}
