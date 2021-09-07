

-- insert into the table account_loan json

-- declare json variable
DECLARE @json VARCHAR(MAX);
--[]hold array | {} -hold objects
SET @json = {
           "INTEREST": [
               {"years": 3, "return_percent": 0.5}, --first 3 years
               {"years": 2, "return_percent": 0.3}, --next 3 years
               {"years": 5, "return_percent": 0.2}  --next 5 years
           ]};

DECLARE @json VARCHAR;
SET @json = N'[
               {"years": 3, "return_percent": 0.5},
               {"years": 2, "return_percent": 0.3},
               {"years": 5, "return_percent": 0.2}
           ]';



INSERT INTO account_loan
VALUES(1, 10000.00, 1, '2 year', 3.5, '{"years": 3, "return_percent": 0.5},{"years": 2, "return_percent": 0.3},{"years": 5, "return_percent": 0.2}',
'2021-06-21', 'ACTIVE', 1.0);

INSERT INTO individual
VALUES(1, 'Bogdan', 'Mmmm', 'o adresa', '2000-02-04', 9876541, 'Angajator1', 'o ocupatie');
INSERT INTO individual
VALUES(2, 'Buci', 'Daaa', 'o adresa', '2021-02-04', 9874564, 'Angajator2', 'o ocupatie2');

-- declare json variable
DECLARE @json VARCHAR(MAX);


--[]hold array | {} -hold objects
SET @json = {
           "INTEREST": [
               {"years": 3, "return_percent": 0.5}, --first 3 years
               {"years": 2, "return_percent": 0.3}, --next 3 years
               {"years": 5, "return_percent": 0.2}  --next 5 years
           ]};

DECLARE @json VARCHAR;
SET @json = N'[
               {"years": 3, "return_percent": 0.5},
               {"years": 2, "return_percent": 0.3},
               {"years": 5, "return_percent": 0.2}
           ]';

INSERT INTO account_loan
VALUES(2, 5000.00, 1, '1 year', 3.5, '{"years": 3, "return_percent": 0.5},{"years": 2, "return_percent": 0.3},{"years": 5, "return_percent": 0.2}', '2021-06-21', 'ACTIVE', 1.0);

INSERT INTO account_loan
VALUES(3, 5000.00, 1, '1 year', 2.9, '{"years": 3, "return_percent": 0.5},{"years": 2, "return_percent": 0.3},{"years": 5, "return_percent": 0.2}', '2022-06-21', 'ACTIVE', 1.0);

INSERT INTO individual
VALUES(1, 'Bogdan', 'Mmmm', 'o adresa', '2000-02-04', 9876541, 'Angajator1', 'o ocupatie');
INSERT INTO individual
VALUES(2, 'Buci', 'Daaa', 'o adresa', '2021-02-04', 9874564, 'Angajator2', 'o ocupatie2');

INSERT INTO individual
VALUES(3, 'Jack', 'Smith', 'str. Brooklyn 16 ', '2010-02-04', 9872361, 'sc usa srl', 'driver');

INSERT INTO individual
VALUES(4, 'Jon', 'Marry', 'str. Moscow 667 ', '1970-02-04', 9876879, 'sc scuip in Dunare', 'frec menta');

INSERT INTO individual
VALUES(5, 'Jane', 'Jones', 'str. Plopilor  456', '2021-02-04', 9874564, 'Angajator2', 'o ocupatie2');


SELECT interest_return::text FROM account_loan;
SELECT interest_return.years::JSON -> 3;

SELECT interest_return AS interest FROM account_loan WHERE interest_return->>'years'=3;

SELECT interest_return AS interest FROM account_loan WHERE interest->'objects' @> '[{"years":3}]';

SELECT interest_return->'years'->3 from account_loan;

SELECT interest_return FROM account_loan WHERE interest_return->>'years' = 3;

SELECT interest_return FROM account_loan, json_each('"years"') WHERE value = '3';

SELECT * FROM account_loan WHERE interest_return[1] <> 3;
SELECT interest.key, interest.value FROM account_loan, LATERAL json_each(interest_return);

-- explicit cast
UPDATE account_loan
SET interest_return = CAST(interest_return AS json);

-- explicit cast 2 -- a mers
UPDATE account_loan
SET interest_return = to_json(interest_return);

--don't work
SELECT interest_return->'years' as year from account_loan where interest_return->>'return_percent' > '3';


SELECT interest_return->'years' as years from account_loan where CAST(interest_return->>'return_percent' AS decimal) > 0.3;



SELECT interest_return FROM account_loan;
