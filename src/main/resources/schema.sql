DROP TABLE IF EXISTS individual CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE individual(
                        id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
                        name        VARCHAR         NOT NULL,
                        department  VARCHAR         NOT NULL,
                        callnumber  INTEGER         NOT NULL,
                        room        INTEGER         NOT NULL
);