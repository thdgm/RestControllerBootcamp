CREATE TABLE users(
	id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name       VARCHAR(20),
    birthDate  DATE
);