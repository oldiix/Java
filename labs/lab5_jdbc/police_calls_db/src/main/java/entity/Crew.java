package entity;

public class Crew {

    private int crewId;
    private String crewNumber;
    private String status;

    public Crew() {
    }

    public Crew(int crewId, String crewNumber, String status) {
        this.crewId = crewId;
        this.crewNumber = crewNumber;
        this.status = status;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public String getCrewNumber() {
        return crewNumber;
    }

    public void setCrewNumber(String crewNumber) {
        this.crewNumber = crewNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}