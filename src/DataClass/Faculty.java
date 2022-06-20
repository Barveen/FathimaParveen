package DataClass;

import DataSource.GenderType;

public class Faculty extends Department {
    private final String facultyId;
    private String facultyName;
    private int year;
    private String mailId;
    private String phoneNumber;
    private String dateOfJoining;
    private GenderType gender;
    private String district;

    public Faculty(String id, String name, String departmentName, int year, String mailId, String phoneNumber, String joiningDate, GenderType gender, String district) {
        super();
        this.facultyId = id;
        this.gender = gender;
        this.dateOfJoining = joiningDate;
        this.district = district;
        this.facultyName = name;
        this.departmentName = departmentName;
        this.year = year;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public GenderType getGender() {
        return gender;
    }

    public String getDistrict() {
        return district;
    }

    public Faculty(String id, String date,GenderType gender, String district)
    {
        this.facultyId = id;
        this.gender = gender;
        this.dateOfJoining = date;
        this.district = district;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Faculty(String id, String name, String departmentName, int year,String mailId, String phoneNumber) {
        this.facultyId = id;
        this.facultyName = name;
        this.departmentName = departmentName;
        this.year = year;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "DataClass.Faculty{" +
                "facultyName='" + facultyName + '\'' +
                ", year=" + year +
                '}';
    }
}
