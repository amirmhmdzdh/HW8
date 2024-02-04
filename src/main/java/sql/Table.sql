CREATE TABLE IF NOT EXISTS customer
(

    id            SERIAL PRIMARY KEY,
    first_name    VARCHAR,
    last_name     VARCHAR,
    user_name     VARCHAR UNIQUE,
    email         VARCHAR UNIQUE,
    password      VARCHAR,
    national_code VARCHAR UNIQUE
);
CREATE TABLE IF NOT EXISTS admin
(
    id        SERIAL PRIMARY KEY,
    user_name VARCHAR unique,
    password  VARCHAR unique


);