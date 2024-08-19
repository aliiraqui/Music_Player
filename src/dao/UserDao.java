package dao;

import Model.Users;

import java.sql.SQLException;

public interface UserDao {
    void addUser(Users user) throws SQLException;
}
