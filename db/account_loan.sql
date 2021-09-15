
DROP TABLE IF EXISTS account_loan;

CREATE TABLE account_loan (
    iban text PRIMARY KEY,
    loan_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
    individual_id int,
	period INTERVAL YEAR,
	interest_rate DECIMAL(3,2),
	interest_return text,
	start_date DATE,
	status account_loan_status,
	principal NUMERIC(10,2)
);
