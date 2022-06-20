package DataClass;

import DataSource.GenderType;

public class AdmissionDetails {
    private final String newAd_Name;
    private final int cutoff;
    private final GenderType gender;
    private final String status;
    private final String mailId;
    private final String departmentName;


    public String getName() {
        return newAd_Name;
    }

    public String getStatus() {
        return status;
    }

    public GenderType getGender() {
        return gender;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public AdmissionDetails(String name, GenderType gender, int cutOffMark, String departmentName, String mailId, String status) {
        this.newAd_Name = name;
        this.gender = gender;
        this.cutoff = cutOffMark;
        this.departmentName = departmentName;
        this.status = status;
        this.mailId = mailId;
    }


    public String getMailId() {
        return mailId;
    }

    @Override
    public String toString() {
        return newAd_Name+"  "+cutoff+"  "+status+"  "+mailId;
    }
}
