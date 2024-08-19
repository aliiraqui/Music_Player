package service;

import Model.Users;
import dao.UserDaoImpl;

import java.sql.SQLException;

public class MusicService {
    private final UserDaoImpl userDAO = new UserDaoImpl();

    public void addUser(Users user) throws SQLException {

        userDAO.addUser(user);
    }

    public boolean loginUser(String userName, String password) {
        return userDAO.loginUser(userName, password);
    }
}
