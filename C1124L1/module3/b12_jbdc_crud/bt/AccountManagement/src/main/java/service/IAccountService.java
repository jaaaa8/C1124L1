package service;

import entity.Account;

import java.util.List;

public interface IAccountService {
    boolean addAccount(Account account);
    boolean updateAccount(Account account);
    boolean deleteAccount(Account account);
    Account findAccountById(int id);
    List<Account> findAllAccounts();
}
