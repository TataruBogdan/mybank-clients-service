-- child table to parent individual - one individual to many account_loan
CREATE TYPE account_loan_status AS ENUM('ACTIVE', ' CLOSED');

DROP TABLE IF EXISTS account_loan;


CREATE TABLE account_loan (
    iban text PRIMARY KEY,
    loan_amount NUMERIC(10,2) NOT NULL DEFAULT 0,
    individual_id int,
	period date,
	interest_rate DECIMAL(3,2),
	interest_return text,
	start_date DATE,
	account_loan_status text,
	principal NUMERIC(10,2),
    FOREIGN KEY(individual_id) REFERENCES individual(id)
);
