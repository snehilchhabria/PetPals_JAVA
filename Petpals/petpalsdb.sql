CREATE DATABASE petpalsdb;
USE petpalsdb;


CREATE TABLE pets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    breed VARCHAR(100)
);

CREATE TABLE donations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    donorName VARCHAR(100),
    amount DECIMAL(10, 2),
    donationDate DATE
);

CREATE TABLE adoption_events (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(100),
    date DATE
);
