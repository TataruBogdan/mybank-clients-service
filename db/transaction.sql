


-- DROP TABLE IF EXISTS transaction;

--account este contul : account_current, account_deposit, account_loan ???
CREATE TABLE transaction (
    transaction_id text PRIMARY KEY,
	from_iban text,
	from_account_type account_type,
	to_iban text,
    to_account_type account_type,
	transaction_amount INTEGER,
	transaction_timestamp TIMESTAMP,
	status transaction_status
);




