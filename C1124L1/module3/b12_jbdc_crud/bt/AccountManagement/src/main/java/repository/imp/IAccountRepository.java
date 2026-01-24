package repository;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {
    boolean addAccount(Account account) throws SQLException;
    boolean updateAccount(Account account) throws SQLException;
    boolean deleteAccount(Account account)  throws SQLException;
    Account findAccountById(int id)  throws SQLException;
    List<Account> findAllAccounts();
}
