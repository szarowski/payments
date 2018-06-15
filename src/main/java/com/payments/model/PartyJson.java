package com.payments.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel("Party")
public final class PartyJson {

    @ApiModelProperty(notes = "Account Name")
    private final String accountName;

    @ApiModelProperty(notes = "Account Number")
    private final String accountNumber;

    @ApiModelProperty(notes = "Account Number Code")
    private final String accountNumberCode;

    @ApiModelProperty(notes = "Account Type")
    private final Integer accountType;

    @ApiModelProperty(notes = "Address")
    private final String address;

    @ApiModelProperty(notes = "Bank ID")
    private final String bankId;

    @ApiModelProperty(notes = "Bank ID Code")
    private final String bankIdCode;

    @ApiModelProperty(notes = "Name")
    private final String name;

    @JsonCreator
    public PartyJson(final String accountName, final String accountNumber, final String accountNumberCode,
                     final Integer accountType, final String address, final String bankId, final String bankIdCode,
                     final String name) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountNumberCode = accountNumberCode;
        this.accountType = accountType;
        this.address = address;
        this.bankId = bankId;
        this.bankIdCode = bankIdCode;
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountNumberCode() {
        return accountNumberCode;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public String getAddress() {
        return address;
    }

    public String getBankId() {
        return bankId;
    }

    public String getBankIdCode() {
        return bankIdCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PartyJson partyJson = (PartyJson) o;
        return Objects.equals(accountName, partyJson.accountName) &&
                Objects.equals(accountNumber, partyJson.accountNumber) &&
                Objects.equals(accountNumberCode, partyJson.accountNumberCode) &&
                Objects.equals(accountType, partyJson.accountType) &&
                Objects.equals(address, partyJson.address) &&
                Objects.equals(bankId, partyJson.bankId) &&
                Objects.equals(bankIdCode, partyJson.bankIdCode) &&
                Objects.equals(name, partyJson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, accountNumber, accountNumberCode, accountType, address, bankId, bankIdCode, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("accountName", accountName)
                .add("accountNumber", accountNumber)
                .add("accountNumberCode", accountNumberCode)
                .add("accountType", accountType)
                .add("address", address)
                .add("bankId", bankId)
                .add("bankIdCode", bankIdCode)
                .add("name", name)
                .toString();
    }
}