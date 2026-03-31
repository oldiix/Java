package dao;

import entity.Crew;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CrewDAO {

    public void addCrew(Crew crew) throws Exception {
        String sql = "INSERT INTO crews (crew_number, status) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, crew.getCrewNumber());
            ps.setString(2, crew.getStatus());

            ps.executeUpdate();
        }
    }

    public List<Crew> getAllCrews() throws Exception {
        String sql = "SELECT * FROM crews";
        List<Crew> crews = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                crews.add(new Crew(
                        rs.getInt("crew_id"),
                        rs.getString("crew_number"),
                        rs.getString("status")
                ));
            }
        }

        return crews;
    }

    public List<Crew> searchByCrewNumber(String keyword) throws Exception {
        String sql = "SELECT * FROM crews WHERE crew_number LIKE ?";
        List<Crew> crews = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    crews.add(new Crew(
                            rs.getInt("crew_id"),
                            rs.getString("crew_number"),
                            rs.getString("status")
                    ));
                }
            }
        }

        return crews;
    }

    public void updateCrew(Crew crew) throws Exception {
        String sql = "UPDATE crews SET crew_number = ?, status = ? WHERE crew_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, crew.getCrewNumber());
            ps.setString(2, crew.getStatus());
            ps.setInt(3, crew.getCrewId());

            ps.executeUpdate();
        }
    }

    public void deleteCrew(int crewId) throws Exception {
        String sql = "DELETE FROM crews WHERE crew_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, crewId);
            ps.executeUpdate();
        }
    }
}