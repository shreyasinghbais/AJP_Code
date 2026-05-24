package service;

import dao.AccountDAO;
import model.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountantService {
    private AccountDAO accountDAO;

    public AccountantService() {
        accountDAO = new AccountDAO();
    }

    public void createAccount(Account account) throws SQLException {
        accountDAO.addAccount(account);
    }

    public void updateAccount(Account account) throws SQLException {
        accountDAO.updateAccount(account);
    }

    public void deleteAccount(String accountNumber) throws SQLException {
        accountDAO.deleteAccount(accountNumber);
    }

    public Account getAccountByNumber(String accountNumber) throws SQLException {
        return accountDAO.getAccountByNumber(accountNumber);
    }

    public List<Account> getAllAccounts() throws SQLException {
        return accountDAO.getAllAccounts();
    }

    public void deposit(String accountNumber, double amount) throws SQLException {
        Account account = accountDAO.getAccountByNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountDAO.updateAccount(account);
        }
    }

    public void withdraw(String accountNumber, double amount) throws SQLException {
        Account account = accountDAO.getAccountByNumber(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountDAO.updateAccount(account);
        }
    }
}
