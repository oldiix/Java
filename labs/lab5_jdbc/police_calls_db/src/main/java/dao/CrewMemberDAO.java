package dao;

import entity.CrewMember;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CrewMemberDAO {

    public void addCrewMember(CrewMember crewMember) throws Exception {
        String sql = "INSERT INTO crew_members (crew_id, officer_id, role) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, crewMember.getCrewId());
            ps.setInt(2, crewMember.getOfficerId());
            ps.setString(3, crewMember.getRole());

            ps.executeUpdate();
        }
    }

    public List<CrewMember> getAllCrewMembers() throws Exception {
        String sql = "SELECT * FROM crew_members";
        List<CrewMember> members = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                members.add(new CrewMember(
                        rs.getInt("member_id"),
                        rs.getInt("crew_id"),
                        rs.getInt("officer_id"),
                        rs.getString("role")
                ));
            }
        }

        return members;
    }

    public List<CrewMember> searchByRole(String keyword) throws Exception {
        String sql = "SELECT * FROM crew_members WHERE role LIKE ?";
        List<CrewMember> members = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    members.add(new CrewMember(
                            rs.getInt("member_id"),
                            rs.getInt("crew_id"),
                            rs.getInt("officer_id"),
                            rs.getString("role")
                    ));
                }
            }
        }

        return members;
    }

    public void updateCrewMember(CrewMember crewMember) throws Exception {
        String sql = "UPDATE crew_members SET crew_id = ?, officer_id = ?, role = ? WHERE member_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, crewMember.getCrewId());
            ps.setInt(2, crewMember.getOfficerId());
            ps.setString(3, crewMember.getRole());
            ps.setInt(4, crewMember.getMemberId());

            ps.executeUpdate();
        }
    }

    public void deleteCrewMember(int memberId) throws Exception {
        String sql = "DELETE FROM crew_members WHERE member_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, memberId);
            ps.executeUpdate();
        }
    }
}