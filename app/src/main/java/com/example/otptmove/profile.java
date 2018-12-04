package com.example.otptmove;

public class profile {
    String therapistID;
    String therapistName;
    String therapistType;

    public profile(){

    }

    public profile(String therapistID, String therapistName, String therapistType) {
        this.therapistID = therapistID;
        this.therapistName = therapistName;
        this.therapistType = therapistType;
    }

    public String getTherapistID() {
        return therapistID;
    }

    public String getTherapistName() {
        return therapistName;
    }

    public String getTherapistType() {
        return therapistType;
    }
}
