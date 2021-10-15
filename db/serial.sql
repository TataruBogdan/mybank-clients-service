

CREATE SEQUENCE individual_id_seq;
ALTER TABLE individual ALTER COLUMN id SET DEFAULT nextval('individual_id_seq');
ALTER TABLE individual ALTER COLUMN id SET NOT NULL;
ALTER SEQUENCE individual_id_seq OWNED BY individual.id;
SELECT setval('individual_id_seq', (SELECT max(id) FROM individual));


