

CREATE TYPE transaction_status AS ENUM(
    'NEW', 'APPROVED', ' REJECTED', ' FINISHED'
);
-- cum stiu ce type de cont selectez, contul nu are account_type
CREATE TYPE account_type AS ENUM ('CURRENT', 'DEPOSIT', ' LOAN');


-- DROP TABLE IF EXISTS transaction;

--account este contul : account_current, account_deposit, account_loan ???
CREATE TABLE transaction (
    transaction_id text PRIMARY KEY,
    -- can insert only account_id (FK) ? in place of from_iban and to_iban
	from_iban text,
	from_account_type account_type,
	to_iban text,
    to_account_type account_type,
	transaction_amount INTEGER,
	transaction_timestamp TIMESTAMP,
	FOREIGN key(from_iban) REFERENCES account_current(iban),
	status transaction_status
);




