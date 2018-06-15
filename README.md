# Payment API

The Payment API.

## Design

The interface is autogenerated by Swagger2 when you run:
`gradle clean build`

Please use some UI which imports the swagger json, for example [ReDoc](https://github.com/Rebilly/ReDoc).

To export interface to swagger, please follow the installation instructions at:
`https://github.com/Rebilly/ReDoc` and copy the generated internal.json from the root of the project:    
`cp build/swagger/internal.json <redoc_root>/demo`

## Endpoints
```
Fetch Payments from external API:   GET    /v1/payments/fetch/<data_id>   // e.g. /v1/payments/fetch/41ca3269-d8c4-4063-9fd5-f306814ff03f 
Create Payment data:                POST   /v1/payments
Update Payment data:                PUT    /v1/payments/<id>
Get Payment data:                   GET    /v1/payments/<id>
Delete Payment data:                DELETE /v1/payments/<id>
```

### Examples

#### Fetch data from external [MockBin](http://mockbin.org/bin/41ca3269-d8c4-4063-9fd5-f306814ff03f) source:
curl -X GET http://localhost:8080/v1/payments/fetch/41ca3269-d8c4-4063-9fd5-f306814ff03f

#### Create payment:

curl -X POST http://localhost:8080/v1/payments -H "Content-Type: application/json" -d '{"type":"Payment","id":"4ee3a8d8-ca7b-4290-a52c-dd5b6165ec11","version":0,"organisation_id":"743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb","attributes":{"amount":100,"beneficiary_party":{"account_name":"W Owens","account_number":"31926819","account_number_code":"BBAN","account_type":0,"address":"1 The Beneficiary Localtown SE2","bank_id":"403000","bank_id_code":"GBDSC","name":"Wilfred Jeremiah Owens"},"charges_information":{"bearer_code":"SHAR","sender_charges":[{"amount":5,"currency":"GBP"},{"amount":10,"currency":"USD"}],"receiver_charges_amount":1,"receiver_charges_currency":"USD"},"currency":"GBP","debtor_party":{"account_name":"EJ Brown Black","account_number":"GB29XABC10161234567801","account_number_code":"IBAN","address":"10 Debtor Crescent Sourcetown NE1","bank_id":"203301","bank_id_code":"GBDSC","name":"Emelia Jane Brown"},"end_to_end_reference":"Wil piano Jan","fx":{"contract_reference":"FX123","exchange_rate":2,"original_amount":200,"original_currency":"USD"},"numeric_reference":"1002001","payment_id":"123456789012345678","payment_purpose":"Paying for goods/services","payment_scheme":"FPS","payment_type":"Credit","processing_date":"2017-01-18","reference":"Payment for lessons","scheme_payment_sub_type":"Banking","scheme_payment_type":"t","sponsor_party":{"account_number":"56781234","bank_id":"123123","bank_id_code":"GBDSC"}}}'

#### Get payment:
curl -X GET http://localhost:8080/v1/payments/4ee3a8d8-ca7b-4290-a52c-dd5b6165ec11

#### Update payment with version changed to 1:
curl -X PUT http://localhost:8080/v1/payments/4ee3a8d8-ca7b-4290-a52c-dd5b6165ec11 -H "Content-Type: application/json" -d '{"type":"Payment","id":"4ee3a8d8-ca7b-4290-a52c-dd5b6165ec11","version":1,"organisation_id":"743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb","attributes":{"amount":100,"beneficiary_party":{"account_name":"W Owens","account_number":"31926819","account_number_code":"BBAN","account_type":0,"address":"1 The Beneficiary Localtown SE2","bank_id":"403000","bank_id_code":"GBDSC","name":"Wilfred Jeremiah Owens"},"charges_information":{"bearer_code":"SHAR","sender_charges":[{"amount":5,"currency":"GBP"},{"amount":10,"currency":"USD"}],"receiver_charges_amount":1,"receiver_charges_currency":"USD"},"currency":"GBP","debtor_party":{"account_name":"EJ Brown Black","account_number":"GB29XABC10161234567801","account_number_code":"IBAN","address":"10 Debtor Crescent Sourcetown NE1","bank_id":"203301","bank_id_code":"GBDSC","name":"Emelia Jane Brown"},"end_to_end_reference":"Wil piano Jan","fx":{"contract_reference":"FX123","exchange_rate":2,"original_amount":200,"original_currency":"USD"},"numeric_reference":"1002001","payment_id":"123456789012345678","payment_purpose":"Paying for goods/services","payment_scheme":"FPS","payment_type":"Credit","processing_date":"2017-01-18","reference":"Payment for lessons","scheme_payment_sub_type":"Banking","scheme_payment_type":"t","sponsor_party":{"account_number":"56781234","bank_id":"123123","bank_id_code":"GBDSC"}}}'

#### Delete payments:
curl -X DELETE http://localhost:8080/v1/payments/4ee3a8d8-ca7b-4290-a52c-dd5b6165ec11

#### List all payments:
curl -X GET http://localhost:8080/v1/payments

## Requirements
Installed Java 8+.
Installed Gradle. 
Installed PostgreSQL database.
Compile with `-parameters` flag. Gradle build already does that.

## Create DB of Payments in PostgreSQL

If you installed PostgreSQL from APK use the following commands to set up a database.
Note that the user for payments database requires `payments` password and the user for payments_test database requires `payments_test`.

```
sudo -u postgres createuser -P payments
sudo -u postgres createdb -O payments payments
sudo -u postgres createuser -P payments_test
sudo -u postgres createdb -O payments_test payments_test
```

### Database schema

This is a merge from Flyway migration. Note that the alter table at the end unifies timestamps with timezones.
```
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

ALTER TABLE payment_data ALTER COLUMN processing_date TYPE timestamptz USING processing_date AT TIME ZONE 'UTC';
```

## Running the service

The project is build in Gradle, use:
```
gradle clean build
gradle bootRun
```