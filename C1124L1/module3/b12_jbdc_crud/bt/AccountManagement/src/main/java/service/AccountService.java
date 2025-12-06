package service;

import entity.Account;
import repository.AccountRepository;
import repository.IAccountRepository;

import java.sql.SQLException;
import java.util.List;

public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository = new AccountRepository();

    @Override
    public boolean addAccount(Account account) {
        try{
            return accountRepository.addAccount(account);
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        try{
            return accountRepository.updateAccount(account);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAccount(Account account) {
        try{
            return accountRepository.deleteAccount(account);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Account findAccountById(int id) {
        try{
            return accountRepository.findAccountById(id);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
