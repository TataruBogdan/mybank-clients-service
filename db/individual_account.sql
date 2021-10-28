
-- account service - msv create an current account account
-- an account has an account type
-- a individual can have many accounts
-- an account can have many customers
-- an


CREATE TABLE individual_account(
    individual_id int,
    account_id text,
    account_type account_type,
    FOREIGN KEY(individual_id) REFERENCES individual(id),
    FOREIGN KEY(account_id) REFERENCE account_current
);