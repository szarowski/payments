CREATE TABLE IF NOT EXISTS payment_data (
    type                                    VARCHAR(255),
    id                                      UUID            NOT NULL,
    version                                 INTEGER,
    organisation_id                         UUID,
    amount                                  INTEGER,
    beneficiary_party_account_name          VARCHAR(255),
    beneficiary_party_account_number        VARCHAR(64),
    beneficiary_party_account_number_code   VARCHAR(64),
    beneficiary_party_account_type          INTEGER,
    beneficiary_party_address               VARCHAR(255),
    beneficiary_party_bank_id               VARCHAR(64),
    beneficiary_party_bank_id_code          VARCHAR(64),
    beneficiary_party_name                  VARCHAR(255),
    bearer_code                             VARCHAR(64),
    receiver_charges_amount                 INTEGER,
    receiver_charges_currency               VARCHAR(3),
    currency                                VARCHAR(3),
    debtor_party_account_name               VARCHAR(255),
    debtor_party_account_number             VARCHAR(64),
    debtor_party_account_number_code        VARCHAR(64),
    debtor_party_address                    VARCHAR(255),
    debtor_party_bank_id                    VARCHAR(64),
    debtor_party_bank_id_code               VARCHAR(64),
    debtor_party_name                       VARCHAR(255),
    end_to_end_reference                    VARCHAR(255),
    fx_contract_reference                   VARCHAR(255),
    fx_exchange_rate                        INTEGER,
    fx_original_amount                      INTEGER,
    fx_original_currency                    VARCHAR(3),
    numeric_reference                       VARCHAR(64),
    payment_id                              VARCHAR(64),
    payment_purpose                         VARCHAR(255),
    payment_scheme                          VARCHAR(64),
    payment_type                            VARCHAR(64),
    processing_date                         TIMESTAMP,
    reference                               VARCHAR(255),
    scheme_payment_sub_type                 VARCHAR(64),
    scheme_payment_type                     VARCHAR(64),
    sponsor_party_account_number            VARCHAR(64),
    sponsor_party_bank_id                   VARCHAR(64),
    sponsor_party_bank_id_code              VARCHAR(64),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sender_charges_amount (
    id              UUID                                    NOT NULL,
    amount          INTEGER,
    currency        VARCHAR(3),

    FOREIGN KEY (id) REFERENCES payment_data(id) ON DELETE CASCADE
);
