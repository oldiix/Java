package entity;

public class Officer {

    private int officerId;
    private String fullName;
    private String rankName;
    private boolean hasDriverLicense;

    public Officer() {
    }

    public Officer(int officerId, String fullName, String rankName, boolean hasDriverLicense) {
        this.officerId = officerId;
        this.fullName = fullName;
        this.rankName = rankName;
        this.hasDriverLicense = hasDriverLicense;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public boolean isHasDriverLicense() {
        return hasDriverLicense;
    }

    public void setHasDriverLicense(boolean hasDriverLicense) {
        this.hasDriverLicense = hasDriverLicense;
    }
}