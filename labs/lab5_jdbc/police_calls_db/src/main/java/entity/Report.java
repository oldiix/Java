package entity;

import java.time.LocalDateTime;

public class Report {

    private int reportId;
    private int callId;
    private int crewId;
    private String reportText;
    private LocalDateTime reportDate;

    public Report() {
    }

    public Report(int reportId, int callId, int crewId, String reportText, LocalDateTime reportDate) {
        this.reportId = reportId;
        this.callId = callId;
        this.crewId = crewId;
        this.reportText = reportText;
        this.reportDate = reportDate;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }
}