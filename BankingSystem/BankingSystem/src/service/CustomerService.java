package service;

import dao.AccountDAO;
import dao.TransactionDAO;
import model.Account;
import model.Transaction;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class CustomerService {
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;

    public CustomerService() {
        accountDAO = new AccountDAO();
        transactionDAO = new TransactionDAO();
    }

    public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount) throws SQLException {
        Account fromAccount = accountDAO.getAccountByNumber(fromAccountNumber);
        Account toAccount = accountDAO.getAccountByNumber(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            // Deduct from source account
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            accountDAO.updateAccount(fromAccount);

            // Add to destination account
            toAccount.setBalance(toAccount.getBalance() + amount);
            accountDAO.updateAccount(toAccount);

            // Record transactions
            Transaction fromTransaction = new Transaction(0, fromAccountNumber, -amount, "Transfer Out", new Timestamp(System.currentTimeMillis()));
            Transaction toTransaction = new Transaction(0, toAccountNumber, amount, "Transfer In", new Timestamp(System.currentTimeMillis()));

            transactionDAO.addTransaction(fromTransaction);
            transactionDAO.addTransaction(toTransaction);
        } else {
            throw new SQLException("Transfer failed. Either accounts do not exist or insufficient funds.");
        }
    }

    public List<Transaction> getTransactionHistory(String accountNumber) throws SQLException {
        return transactionDAO.getTransactionsByAccount(accountNumber);
    }
}
