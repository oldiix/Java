package dao;

import utils.DBConnection;
import utils.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public void registerUser(String username, String password, String roleName) throws Exception {
        String sql = "INSERT INTO Users (username, password_hash, role_name) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, PasswordUtil.hash(password));
            preparedStatement.setString(3, roleName);

            preparedStatement.executeUpdate();
        }
    }

    public boolean login(String username, String password) throws Exception {
        String sql = "SELECT password_hash FROM Users WHERE username = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String storedHash = resultSet.getString("password_hash");
                    String inputHash = PasswordUtil.hash(password);
                    return storedHash.equals(inputHash);
                }
            }
        }

        return false;
    }
}