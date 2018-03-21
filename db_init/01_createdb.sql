CREATE ROLE demoUser login password 'demoUser';
CREATE DATABASE person;
GRANT ALL PRIVILEGES ON DATABASE person to demoUser;