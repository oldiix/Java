package dao;

import entity.Call;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CallDAO {

    public void addCall(Call call) throws Exception {
        String sql = "INSERT INTO calls (caller_name, call_datetime, address_id, description) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, call.getCallerName());
            ps.setTimestamp(2, Timestamp.valueOf(call.getCallDateTime()));
            ps.setInt(3, call.getAddressId());
            ps.setString(4, call.getDescription());

            ps.executeUpdate();
        }
    }

    public List<Call> getAllCalls() throws Exception {
        String sql = "SELECT * FROM calls";
        List<Call> calls = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                calls.add(new Call(
                        rs.getInt("call_id"),
                        rs.getString("caller_name"),
                        rs.getTimestamp("call_datetime").toLocalDateTime(),
                        rs.getInt("address_id"),
                        rs.getString("description")
                ));
            }
        }

        return calls;
    }

    public List<Call> searchByCallerName(String keyword) throws Exception {
        String sql = "SELECT * FROM calls WHERE caller_name LIKE ?";
        List<Call> calls = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    calls.add(new Call(
                            rs.getInt("call_id"),
                            rs.getString("caller_name"),
                            rs.getTimestamp("call_datetime").toLocalDateTime(),
                            rs.getInt("address_id"),
                            rs.getString("description")
                    ));
                }
            }
        }

        return calls;
    }

    public void updateCall(Call call) throws Exception {
        String sql = "UPDATE calls SET caller_name = ?, call_datetime = ?, address_id = ?, description = ? WHERE call_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, call.getCallerName());
            ps.setTimestamp(2, Timestamp.valueOf(call.getCallDateTime()));
            ps.setInt(3, call.getAddressId());
            ps.setString(4, call.getDescription());
            ps.setInt(5, call.getCallId());

            ps.executeUpdate();
        }
    }

    public void deleteCall(int callId) throws Exception {
        String sql = "DELETE FROM calls WHERE call_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, callId);
            ps.executeUpdate();
        }
    }
}