-- if the user "student" does not already exist, create it
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';
GRANT ALL PRIVILEGES ON * . * TO 'student'@'localhost';

CREATE DATABASE olympicMedals;
USE olympicMedals;

-- new tables and queries
DROP TABLE IF EXISTS bottleSales;
DROP TABLE IF EXISTS bottles;
CREATE TABLE olympics (
countryID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country VARCHAR(50),
highestNumberOfAthletes INT,
goldMedals INT,
silverMedals INT,
bronzeMedals INT,
percentageOfMedalsWon DEC(3,1)
);

CREATE TABLE bottleSales(
	salesID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dateSold DATE,
    unitsSold INT,
    bottleID INT NOT NULL,
    foreign key (bottleID) REFERENCES bottles(bottleId)
);