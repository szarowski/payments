ALTER TABLE payment_data ALTER COLUMN processing_date TYPE timestamptz USING processing_date AT TIME ZONE 'UTC';