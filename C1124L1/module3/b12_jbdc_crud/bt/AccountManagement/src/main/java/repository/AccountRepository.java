package repository;

import entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.ConnectDB.getConnection;

public class AccountRepository implements IAccountRepository{
    private static final String INSERT_USERS_SQL = "INSERT INTO account (user_name, password, email, role) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,user_name,password,email,role from account where id =?";
    private static final String SELECT_ALL_USERS = "select * from account";
    private static final String DELETE_USERS_SQL = "delete from account where id = ?;";
    private static final String UPDATE_USERS_SQL =
            "UPDATE account SET user_name = ?, password = ?, email = ?, role = ? WHERE id = ?;";


    public AccountRepository() {
    }

    @Override
    public boolean addAccount(Account account) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try(Connection conn = getConnection();
            PreparedStatement preparedState = conn.prepareStatement(INSERT_USERS_SQL)){
            preparedState.setString(1, account.getUsername());
            preparedState.setString(2, account.getPassword());
            preparedState.setString(3, account.getEmail());
            preparedState.setString(4, account.getRole());
            System.out.println(preparedState);
            preparedState.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean updateAccount(Account account) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getEmail());
            statement.setString(4, account.getRole());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteAccount(Account account) throws SQLException {
        boolean rowDeleted;
        int id = account.getId();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Account findAccountById(int id) throws SQLException {
        Account user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, (id));
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("user_name");
                int accId = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                user = new Account(accId,name,password,email,role);
            }
        }
        return user;
    }

    @Override
    public List<Account> findAllAccounts() {
        List<Account> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("user_name");
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                users.add(new Account(id,name,password, email, role));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
