DROP TABLE users IF EXISTS;
DROP TABLE phones IF EXISTS;
DROP TABLE sessions IF EXISTS;

CREATE TABLE users (id uuid NOT NULL, name varchar(150) NOT NULL, email varchar(200) NOT NULL UNIQUE, password varchar(20) NOT NULL, created timestamp NOT NULL, updated timestamp NOT NULL, PRIMARY KEY (id));
CREATE TABLE phones (id uuid NOT NULL, number varchar(30) NOT NULL, city_code varchar(30), country_code varchar(30), user_id varchar NOT NULL, PRIMARY KEY (id));
CREATE TABLE sessions (session_id uuid NOT NULL, token text NOT NULL, is_active bit DEFAULT 'true' NOT NULL, last_login timestamp NOT NULL, user_id varchar NOT NULL, PRIMARY KEY (session_id));

ALTER TABLE phones ADD CONSTRAINT FKphones1998 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE sessions ADD CONSTRAINT FKsessions399837 FOREIGN KEY (user_id) REFERENCES users (id);
