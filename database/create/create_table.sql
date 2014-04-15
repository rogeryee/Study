--Create table in test schema
CREATE TABLE user
(
  id            VARCHAR(50)     NOT NULL,
  name          VARCHAR(100)    NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE address
(
  id            VARCHAR(50)     NOT NULL,
  name          VARCHAR(2000)    NOT NULL,
  user_id       VARCHAR(50),
  PRIMARY KEY(id)
);

CREATE TABLE statistic_person
(
  id            VARCHAR(50)     NOT NULL,
  name			VARCHAR(100)    NOT NULL,
  department    VARCHAR(100)    NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE statistic_department
(
  id            VARCHAR(50)     NOT NULL,
  name			VARCHAR(100)    NOT NULL,
  PRIMARY KEY(id)
);


CREATE TABLE test_user_info
(
  id            VARCHAR(50)     NOT NULL,
  name          VARCHAR(100)    NOT NULL,
  address       VARCHAR(200),
  PRIMARY KEY(id)
);

CREATE TABLE test_user_ext_info
(
  id            VARCHAR(50)     NOT NULL,
  username      VARCHAR(100)    NOT NULL,
  company       VARCHAR(200),
  PRIMARY KEY(id)
);

CREATE TABLE test_log
(
  id            VARCHAR(50)     NOT NULL,
  log           VARCHAR(2000)    NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE test_person
(
  id            VARCHAR(50)     NOT NULL,
  name          VARCHAR(100)    NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE test_person_address
(
  id            VARCHAR(50)     NOT NULL,
  name          VARCHAR(2000)    NOT NULL,
  person_id     VARCHAR(50),
  PRIMARY KEY(id)
);




