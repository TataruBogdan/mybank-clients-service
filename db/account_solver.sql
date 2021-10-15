
CREATE TYPE account_type AS ENUM ('CURRENT', 'DEPOSIT', 'LOAN');

CREATE TABLE account(
    iban text PRIMARY KEY NOT NULL,
    account_type text,
    client_cnp text,
    current_amount NUMERIC(10,2)
)
