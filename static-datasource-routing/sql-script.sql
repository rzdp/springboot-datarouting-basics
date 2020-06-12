CREATE DATABASE sdsr_bangkokdb;

USE sdsr_bangkokdb;

CREATE TABLE Employee (
	EmployeeId BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	Name VARCHAR(50) NOT NULL,
	Branch VARCHAR(50) NOT NULL
)

INSERT INTO Employee VALUES ('Jose Manalo', 'Bangkok');
INSERT INTO Employee VALUES ('Vic Sotto', 'Bangkok');
INSERT INTO Employee VALUES ('Joey De Leon', 'Bangkok');
INSERT INTO Employee VALUES ('Wally Bayola', 'Bangkok');
INSERT INTO Employee VALUES ('Allan K', 'Bangkok');

CREATE DATABASE sdsr_hongkongdb;

USE sdsr_hongkongdb;

CREATE TABLE Employee (
	EmployeeId BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	Name VARCHAR(50) NOT NULL,
	Branch VARCHAR(50) NOT NULL
)

INSERT INTO Employee VALUES ('Vhong Navarro', 'Hongkong');
INSERT INTO Employee VALUES ('Billy Crawford', 'Hongkong');
INSERT INTO Employee VALUES ('Vice Ganda', 'Hongkong');
INSERT INTO Employee VALUES ('Anne Curtis', 'Hongkong');
INSERT INTO Employee VALUES ('Jhong Hilario', 'Hongkong');
