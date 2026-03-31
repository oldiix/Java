package dao;

import entity.Address;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {

    public void addAddress(Address address) throws Exception {
        String sql = "INSERT INTO addresses (street, house_number, apartment) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getHouseNumber());
            preparedStatement.setString(3, address.getApartment());

            preparedStatement.executeUpdate();
        }
    }

    public List<Address> getAllAddresses() throws Exception {
        String sql = "SELECT * FROM addresses";
        List<Address> addresses = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Address address = new Address(
                        resultSet.getInt("address_id"),
                        resultSet.getString("street"),
                        resultSet.getString("house_number"),
                        resultSet.getString("apartment")
                );
                addresses.add(address);
            }
        }

        return addresses;
    }

    public void updateAddress(Address address) throws Exception {
        String sql = "UPDATE addresses SET street = ?, house_number = ?, apartment = ? WHERE address_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getHouseNumber());
            preparedStatement.setString(3, address.getApartment());
            preparedStatement.setInt(4, address.getAddressId());

            preparedStatement.executeUpdate();
        }
    }

    public void deleteAddress(int addressId) throws Exception {
        String sql = "DELETE FROM addresses WHERE address_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, addressId);
            preparedStatement.executeUpdate();
        }
    }

    public List<Address> searchByStreet(String keyword) throws Exception {
        String sql = "SELECT * FROM addresses WHERE street LIKE ?";
        List<Address> addresses = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + keyword + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = new Address(
                            resultSet.getInt("address_id"),
                            resultSet.getString("street"),
                            resultSet.getString("house_number"),
                            resultSet.getString("apartment")
                    );
                    addresses.add(address);
                }
            }
        }

        return addresses;
    }
}

