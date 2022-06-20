package DataClass;

import DataSource.GenderType;

public class PersonalDetails {
    private String rollNumber;
    private String dateOfBirth;
    private GenderType gender;
    private String fatherName;
    private String district;

    public GenderType getGender() {
        return gender;
    }

    public PersonalDetails(String rollNumber, String dateOfBirth, GenderType gender, String fatherName, String district) {
        this.rollNumber = rollNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.fatherName = fatherName;
        this.district = district;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }



    public String getFatherName() {
        return fatherName;
    }

    public String getDistrict() {
        return district;
    }

    public String getRollNumber() {
        return rollNumber;
    }


    @Override
    public String toString() {
        return rollNumber+" "+dateOfBirth+"  "+gender+"  "+fatherName+"    "+district;
    }
}
