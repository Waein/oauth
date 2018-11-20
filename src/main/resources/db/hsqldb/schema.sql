DROP TABLE nursery IF EXISTS;
DROP TABLE association IF EXISTS;
DROP TABLE user IF EXISTS;

CREATE TABLE nursery (
  id            BIGINT IDENTITY PRIMARY KEY,
  association_id BIGINT,
  name          VARCHAR(80),
  leader        VARCHAR(80),
  acronym         VARCHAR(80),
  create_time  DATE
);

CREATE TABLE association (
  id           BIGINT IDENTITY PRIMARY KEY,
  name         VARCHAR(80),
  address      VARCHAR(80)
);

CREATE TABLE user (
  id            BIGINT IDENTITY PRIMARY KEY,
  username      VARCHAR(80),
  password      VARCHAR(80)
);