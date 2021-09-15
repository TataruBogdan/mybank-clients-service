
CREATE TABLE account_deposit(
    iban text PRIMARY KEY,
    deposit_amount NUMERIC(10,2) NOT NULL,
    balance NUMERIC(10,2),
    individual_id int,
    maturity_date date,
    interest_rate DECIMAL(3,2),
    self_capitalization BOOLEAN,
    maturity_iban text,
    start_date date,
    status account_deposit_status

);

