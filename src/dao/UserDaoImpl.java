package dao;

import Model.Users;
import util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(Users user) throws SQLException {
        String addUserQuery = "INSERT INTO USERS (USER_NAME, PASSWORD, EMAIL) VALUES (?,?,?);";
        try (Connection connection = DatabaseConnector.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(addUserQuery)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean loginUser(String userName, String password) {
        String loginUserQuery = "SELECT * FROM USERS WHERE USER_NAME = ? AND PASSWORD = ?";

        try (Connection connection = DatabaseConnector.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(loginUserQuery)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
