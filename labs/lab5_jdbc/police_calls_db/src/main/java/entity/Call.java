package entity;

import java.time.LocalDateTime;

public class Call {

    private int callId;
    private String callerName;
    private LocalDateTime callDateTime;
    private int addressId;
    private String description;

    public Call() {
    }

    public Call(int callId, String callerName, LocalDateTime callDateTime, int addressId, String description) {
        this.callId = callId;
        this.callerName = callerName;
        this.callDateTime = callDateTime;
        this.addressId = addressId;
        this.description = description;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public LocalDateTime getCallDateTime() {
        return callDateTime;
    }

    public void setCallDateTime(LocalDateTime callDateTime) {
        this.callDateTime = callDateTime;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}