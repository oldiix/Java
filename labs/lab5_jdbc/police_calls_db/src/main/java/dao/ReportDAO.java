package dao;

import entity.Report;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public void addReport(Report report) throws Exception {
        String sql = "INSERT INTO reports (call_id, crew_id, report_text, report_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, report.getCallId());
            ps.setInt(2, report.getCrewId());
            ps.setString(3, report.getReportText());
            ps.setTimestamp(4, Timestamp.valueOf(report.getReportDate()));

            ps.executeUpdate();
        }
    }

    public List<Report> getAllReports() throws Exception {
        String sql = "SELECT * FROM reports";
        List<Report> reports = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                reports.add(new Report(
                        rs.getInt("report_id"),
                        rs.getInt("call_id"),
                        rs.getInt("crew_id"),
                        rs.getString("report_text"),
                        rs.getTimestamp("report_date").toLocalDateTime()
                ));
            }
        }

        return reports;
    }

    public List<Report> searchByText(String keyword) throws Exception {
        String sql = "SELECT * FROM reports WHERE report_text LIKE ?";
        List<Report> reports = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reports.add(new Report(
                            rs.getInt("report_id"),
                            rs.getInt("call_id"),
                            rs.getInt("crew_id"),
                            rs.getString("report_text"),
                            rs.getTimestamp("report_date").toLocalDateTime()
                    ));
                }
            }
        }

        return reports;
    }

    public void updateReport(Report report) throws Exception {
        String sql = "UPDATE reports SET call_id = ?, crew_id = ?, report_text = ?, report_date = ? WHERE report_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, report.getCallId());
            ps.setInt(2, report.getCrewId());
            ps.setString(3, report.getReportText());
            ps.setTimestamp(4, Timestamp.valueOf(report.getReportDate()));
            ps.setInt(5, report.getReportId());

            ps.executeUpdate();
        }
    }

    public void deleteReport(int reportId) throws Exception {
        String sql = "DELETE FROM reports WHERE report_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, reportId);
            ps.executeUpdate();
        }
    }
}