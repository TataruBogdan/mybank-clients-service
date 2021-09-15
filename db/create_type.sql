-- child table to parent individual - one individual to one account_current
CREATE TYPE account_current_status AS ENUM('ACTIVE', 'CLOSED');

-- child table to parent individual - one individual to many account_deposit
CREATE TYPE account_deposit_status AS ENUM('ACTIVE', 'CLOSED');


-- child table to parent individual - one individual to many account_loan
CREATE TYPE account_loan_status AS ENUM('ACTIVE', 'CLOSED');


CREATE TYPE tax_operation_type AS ENUM ('CREATE_ACCOUNT', 'DEBIT', 'CLOSE_ACCOUNT', 'ACCOUNT_MAINTENANCE');


CREATE TYPE tax_type AS ENUM('FIX_AMOUNT', 'PERCENT');


CREATE TYPE transaction_status AS ENUM(
    'NEW', 'APPROVED', 'REJECTED', 'FINISHED'
);


-- cum stiu ce type de cont selectez, contul nu are account_type
CREATE TYPE account_type AS ENUM ('CURRENT', 'DEPOSIT', 'LOAN');
