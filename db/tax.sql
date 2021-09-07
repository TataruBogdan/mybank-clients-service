
CREATE TYPE tax_operation_type AS ENUM ('CREATE_ACCOUNT', 'DEBIT', 'CLOSE_ACCOUNT', 'ACCOUNT_MAINTENANCE');

CREATE TYPE tax_type AS ENUM('FIX_AMOUNT', ' PERCENT');

CREATE TABLE tax (
    operation tax_operation_type,
    type tax_type,
    amount NUMERIC(10,2) NOT NULL DEFAULT 0
);

