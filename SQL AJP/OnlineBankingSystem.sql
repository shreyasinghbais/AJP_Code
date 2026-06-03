create database onlinebank;
show databases;
use onlinebank;
show tables;
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    upi_id VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL 
); 
desc users;
select * from users;
SELECT * FROM Users WHERE username = 'Nitya' AND password = '1234';
CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    balance DECIMAL(15, 2) DEFAULT 0.00,
    FOREIGN KEY (customer_id) REFERENCES Users(user_id) ON DELETE CASCADE
);
desc accounts;
select * from accounts;
CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    transaction_type ENUM('Deposit', 'Withdrawal', 'Transfer') NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id) ON DELETE CASCADE
);
desc transactions;
alter table transactions add account_number VARCHAR(20);
select * from transactions;