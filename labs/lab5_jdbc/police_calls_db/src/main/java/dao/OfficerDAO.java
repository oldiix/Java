package dao;

import entity.Officer;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OfficerDAO {

    public void addOfficer(Officer officer) throws Exception {
        String sql = "INSERT INTO officers (full_name, rank_name, has_driver_license) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, officer.getFullName());
            ps.setString(2, officer.getRankName());
            ps.setBoolean(3, officer.isHasDriverLicense());

            ps.executeUpdate();
        }
    }

    public List<Officer> getAllOfficers() throws Exception {
        String sql = "SELECT * FROM officers";
        List<Officer> officers = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                officers.add(new Officer(
                        rs.getInt("officer_id"),
                        rs.getString("full_name"),
                        rs.getString("rank_name"),
                        rs.getBoolean("has_driver_license")
                ));
            }
        }

        return officers;
    }

    public List<Officer> searchByName(String keyword) throws Exception {
        String sql = "SELECT * FROM officers WHERE full_name LIKE ?";
        List<Officer> officers = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    officers.add(new Officer(
                            rs.getInt("officer_id"),
                            rs.getString("full_name"),
                            rs.getString("rank_name"),
                            rs.getBoolean("has_driver_license")
                    ));
                }
            }
        }

        return officers;
    }

    public void updateOfficer(Officer officer) throws Exception {
        String sql = "UPDATE officers SET full_name = ?, rank_name = ?, has_driver_license = ? WHERE officer_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, officer.getFullName());
            ps.setString(2, officer.getRankName());
            ps.setBoolean(3, officer.isHasDriverLicense());
            ps.setInt(4, officer.getOfficerId());

            ps.executeUpdate();
        }
    }

    public void deleteOfficer(int officerId) throws Exception {
        String sql = "DELETE FROM officers WHERE officer_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, officerId);
            ps.executeUpdate();
        }
    }
}