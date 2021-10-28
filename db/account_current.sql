-- child table to parent individual - one individual to one account_current
CREATE TYPE account_current_status AS ENUM('ACTIVE', ' CLOSED');

DROP TABLE IF EXISTS account_current;

CREATE TABLE account_current(
    iban text PRIMARY KEY,
    account_type account_type,
	balance NUMERIC(10,2) NOT NULL DEFAULT 0,
	individual_id int,
	start_date date,
	status account_current_status,
	primary_account boolean,
	FOREIGN key(account_type) REFERENCES transactions(account_type),
	FOREIGN KEY(individual_id) REFERENCES individual(id)
);


CREATE TABLE account_current(
    iban text PRIMARY KEY,
    account_type text,
	balance NUMERIC(10,2) NOT NULL DEFAULT 0,
	individual_id int,
	start_date date,
	account_current_status text,
	primary_account boolean,
	FOREIGN KEY(individual_id) REFERENCES individual(id)
);





