package DataClass;

public class Student {
    private  String rollNumber;
    private  String studentName;
    private  String departmentName;
    private  int year;
    private  String mailId;
    private  String phoneNumber;


    public Student(String rollNumber, String name, String departmentName, int year, String mailId, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.studentName = name;
        this.departmentName = departmentName;
        this.year = year;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
    }

    public Student() {

    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getYear() {
        return year;
    }

    public String getMailId() {
        return mailId;
    }

    @Override
    public String toString() {
        return "DataClass.Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", departName='" + departmentName + '\'' +
                ", year=" + year +
                ", mailId='" + mailId + '\'' +
                '}';
    }

}