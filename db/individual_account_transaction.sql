

CREATE TABLE individual_account_transaction(
    individual_id text,
    account_id text,

    FOREIGN KEY(individual_id) REFERENCES individual(id_serial),
    FOREIGN KEY(account_id) REFERENCES account_current(iban)
);