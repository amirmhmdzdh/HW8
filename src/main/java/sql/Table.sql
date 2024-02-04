CREATE TABLE IF NOT EXISTS customer
(

    id           SERIAL PRIMARY KEY,
    first_name    VARCHAR,
    last_name     VARCHAR,
    user_name     VARCHAR,
    email        VARCHAR,
    password     VARCHAR,
    national_code VARCHAR
);