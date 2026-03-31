package entity;

public class CrewMember {

    private int memberId;
    private int crewId;
    private int officerId;
    private String role;

    public CrewMember() {
    }

    public CrewMember(int memberId, int crewId, int officerId, String role) {
        this.memberId = memberId;
        this.crewId = crewId;
        this.officerId = officerId;
        this.role = role;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}