package DataSource;

import DataClass.*;
import UtilClass.Checking;
import UtilClass.MD5;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentFunction1 {
    StudentInterface con = new DBConnection();
    Checking checker = new Checking();
    Authentication authentications = new Authentication();
    // UsecaseClass usecase = new UsecaseClass();

    static Scanner sc = new Scanner(System.in);
    public static Scanner str = new Scanner(System.in);

    private static DataSource.StudentFunction1 single_instance = null;
    int departmentId, cutOffMark, availableSeats;
    String departmentName,id,name, phoneNumber, mailId, fatherName;
    String subjectName, dateOfBirth, district,status;
    int mark, year;
    String  date;
    int choice, semester;
    String passWord;
    int count;
    boolean success;
    GenderType gender;
    String userId , role, subjectCode;



    public static StudentFunction1 getInstance() {
        // To ensure only one instance is created
        //a class that has only one instance and provides a global point of access to it
        if (single_instance == null) {
            single_instance = new DataSource.StudentFunction1();
        }
        return single_instance;
    }
    public void login() throws Exception {
        Scanner userInput = new Scanner(System.in);
        Scanner userPass = new Scanner(System.in);
        String passwrod;
        System.out.println("Enter your user Id( your Id Number ) : ");
        userId = userInput.next();
        System.out.println("Enter your PassWord: ");
        passwrod = userPass.next();
        String hash = MD5.getMd5(passwrod);
        UserDetails userDetails1;
        userDetails1 = con.getUser(userId);
        if (userDetails1.getUserId().equalsIgnoreCase(userId)) {
            if (userDetails1.getPassword().equalsIgnoreCase(hash)) {
                role = userDetails1.getRole();
                System.out.println(role);
                System.out.println("Your successfully logged in");
                verification();
            } else {
                System.out.println("password wrong");
            }
        } else {
            System.out.println("Your user name is wrong , re enter your user name : ");
            userPass.next();
        }
    }

    public void verification() throws Exception {
        if(role.equalsIgnoreCase("Admin"))
        {
            adminMenuOperation();
        }
        else if(role.equalsIgnoreCase("Student"))
        {
            studentOperation();
        }
        else if(role.equalsIgnoreCase("Faculty"))
        {
            facultyOperation();
        }
    }

    public void adminMenuOperation() throws Exception {

            System.out.println("Welcome to Admin Menu");
            boolean on = true;

            while (on) {
                System.out.println("----------------------------------------");
                System.out.println("""
                        Enter\s
                        1 -->  for Add Departments
                        2 -->  for Add Students
                        3 -->  for Add FacultyDetails
                        4 -->  for Show Departments
                        5 -->  for View Students Details for fail students
                        6 -->  for View Student Personal Details
                        7 -->  for Search By StudentId
                        8 -->  for Search By StudentName
                        9 -->  for View Faculty Details
                        10 --> for View Faculty Personal Details
                        11 --> for view admission details
                        12 --> for Remove Student
                        13 --> for view student by their department & year
                        14 --> for Change Password
                        15 --> log out""");
                System.out.println("----------------------------------------");
                System.out.println("Enter your choice: ");
                int choice = checker.inputChoice();
                switch (choice) {
                    case 1 -> addDepartments();
                    case 2 -> addStudentDetails();
                    case 3 -> addFacultyDetails();
                    case 4 -> displayDepartmentDetails();
                    case 5 -> displayStudentDetails();
                    case 6 -> displayStudentPersonalDetails();
                    case 7 -> searchByStudentId();
                    case 8 -> searchByStudentName();
                    case 9 -> displayFacultyDetails();
                    case 10 -> displayFacultyPersonalDetails();
                    case 11 -> displayAdmissionDetails();
                    case 12 -> RemoveStudent();
                    case 13 -> viewStudentsByDepartmentAndYear();
                    case 14 -> changePassWord();
                    case 15 -> {
                        authentications.logOut();
                        on = false;
                    }
                    default -> {
                        System.out.println("Please Enter the correct choice ");
                        adminMenuOperation();
                    }
                }
            }

    }


    public void facultyOperation() throws Exception
    {

            System.out.println("Welcome to the Faculty Menu ");
            boolean on = true;
            while (on) {
                System.out.println("------------------------------");
                System.out.println("""
                        Enter your choice:\s
                        1 --> for Add Student Marks
                        2 --> for Search By StudentId
                        3 --> for Search By StudentName
                        4 --> for View Student Marks
                        5 --> for View Student By Department and Year
                        6 --> view Fail Students
                        7 --> view Faculty by their Id
                        8 --> add subject details
                        9 --> Change Password
                        10 --> for Log Out""");
                System.out.println("------------------------------");
                int choice = checker.inputChoice();
                switch (choice) {
                    case 1 -> addStudentMarks();
                    case 2 -> searchByStudentId();
                    case 3 -> searchByStudentName();
                    case 4 -> viewStudentMarks();
                    case 5 -> viewStudentsByDepartmentAndYear();
                    case 6 -> viewFailStudents();
                    case 7 -> viewFacultyDetailsById();
                    case 8 -> addSubjectDetails();
                    case 9 -> changePassWord();
                    case 10 -> {
                        authentications.logOut();
                        on = false;
                    }
                    default -> {
                        System.out.println("You entered the choice is not in range..please enter (1 to 8) ");
                        facultyOperation();
                    }
                }
            }
        }

    public void studentOperation() throws Exception {
            System.out.println("Welcome to Student Menu");
            boolean on = true;
            while (on) {
                System.out.println("------------------------------");
                System.out.println("""
                        Enter your choice:\s
                        1 --> for View their details
                        2 --> for View their marks
                        3 --> for Change Password
                        4 --> for Log Out""");
                System.out.println("------------------------------");
                int choice = checker.inputChoice();
                switch (choice) {
                    case 1 -> searchByStudentId();
                    case 2 -> viewStudentMarks();
                    case 3 -> changePassWord();
                    case 4 -> {
                        authentications.logOut();
                        on = false;
                    }
                    default -> {
                        System.out.println("Please enter the correct choice");
                        studentOperation();
                    }
                }
            }
    }
    public void newAdmissionOperation() throws Exception {
            System.out.println("Welcome to New Admission Menu");
            boolean on = true;
            while (on) {
                System.out.println("-----------------------------------------------------");
                System.out.println("""
                    Enter your choice:\s
                    1 --> for View Department, Seat & cutoff marks for each department
                    2 --> for New Admission Form
                    3 --> for Log Out""");
                System.out.println("-----------------------------------------------------");
                int choice = checker.inputChoice();
                switch (choice) {
                    case 1 -> displayDepartmentDetails();
                    case 2 -> addNewAdmission();
                    case 3 -> {
                        authentications.logOut();
                        on = false;
                    }

                }
            }
    }


    private void viewFacultyDetailsById() throws SQLException {
        System.out.println("Enter the Faculty Id : ");
        id = sc.next();
        Faculty faculty1;
        faculty1 = con.getByFacultyId(id);
        System.out.println(faculty1.getFacultyId()+" "+faculty1.getFacultyName()+" "+faculty1.getDepartmentName()+" "+faculty1.getYear()+" "+faculty1.getGender()+" "+faculty1.getDateOfJoining()+" "+faculty1.getDistrict());
    }

    public void viewFailStudents() throws SQLException {
        List<MarkDetails> markDetailsList;
        System.out.println("Enter the Semester : ");
        semester =sc.nextInt();
        markDetailsList = con.getFailStudents(semester);
        for (MarkDetails markDetails: markDetailsList)
        {
            System.out.println(markDetails);
        }
    }

    public void viewStudentsByDepartmentAndYear() throws SQLException {
        List<Student>studentList;
        System.out.println("Enter the Department Name that you want to search :");
        departmentName = sc.next();
        System.out.println("Enter the Year that you want to search : ");
        year = sc.nextInt();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.print("RollId   StudentName   DepartmentName         Year               MailId        PhoneNumber\n");
        System.out.println("-----------------------------------------------------------------------------------------");
        studentList = con.getStudentsByDepartmentAndYear(departmentName,year);
        for (Student student : studentList)
        {
            System.out.printf("%-15s%-15s%-10s%-5s%15s%20s\n", student.getRollNumber(), student.getStudentName(), student.getDepartmentName(), student.getYear(), student.getMailId(), student.getPhoneNumber());

        }

    }

    public void viewStudentMarks() throws SQLException {
        List<MarkDetails>markDetailsList;
        System.out.println("Enter your roll Number");
        id = sc.next();
        markDetailsList = con.getMarksByStudentId(id);
        int count = 0;
        String align = "| %-11s | %-28s | %-4s |%n";
        String redBg = "\u001B[41m";
        String bgReset = "\u001B[0m";
        String mark1;
        for (MarkDetails markDetails : markDetailsList)
        {
            if(count < 1)
            {
                System.out.println("RollNumber : "+markDetails.getRollNumber()+"\nName : "+markDetails.getName()+"\nDepartmentName :"+markDetails.getDepartmentId()+"\nSemester : "+markDetails.getSemester());
                count = 1;
                System.out.format("+-------------+------------------------------+------+%n");
                System.out.format("|SubjectCode  |SubjectName                   |Marks |%n");
                System.out.format("+-------------+------------------------------+------+%n");

            }else
            {
                if(markDetails.getMarks() < 50)
                {
                    mark1 = redBg + String.valueOf(markDetails.getMarks()) + bgReset;
                }else {
                    mark1 = String.valueOf(markDetails.getMarks());

                }
                System.out.format(align, markDetails.getSubjectId(), markDetails.getSubName(), mark1);
                System.out.format("+-------------+------------------------------+------+%n");
            }
        }
    }

    public void addStudentMarks() throws SQLException {
        System.out.println("Enter the roll Number of the student : ");
        id = sc.next();
        System.out.println("Enter the Year and DepartmentId of the student : ");
        year = sc.nextInt();
        departmentId = sc.nextInt();
        System.out.println("Enter the semester number : ");
        semester = sc.nextInt();
        showSubjectDetails(year);
        MarkDetails [] markDetails = new MarkDetails[count];
        for(int i = 0; i < count; i++)
        {
            System.out.println("Enter the subject code : ");
            subjectCode = sc.next();
            System.out.println("Enter the Mark : ");
            mark = sc.nextInt();
            markDetails[i] = new MarkDetails(id,departmentId,semester,subjectCode,mark);
        }
        con.insertMarks(markDetails);


    }

    public void showSubjectDetails(int year ) {
        switch (year)
        {
            case 1, 2 -> {
                System.out.println("Four Subject for each semester ");
                count = 4;
            }
            case 3 -> {
                System.out.println("Three Subject for each semester ");
                count = 3;
            }
            case 4 -> {
                System.out.println("Two Subject for each semester ");
                count = 2;
            }
        }
    }

    public void RemoveStudent() throws SQLException {
        System.out.println("Enter the student RollNumber to Remove : ");
        id = sc.next();
        success = con.removeStudents(id);
        if (success)
        {
            System.out.println(".....Student Record Removed Successfully.....");
        }
        else
        {
            System.out.println(".....Student Record not removed.....");
        }

    }



    public void addStudentDetails() throws SQLException {
        System.out.println("Enter the student roll Number : ");
        id = checkDuplicate(sc.next());
        System.out.println("Enter the student name : ");
        name = checker.isValidName(str.nextLine());
        System.out.println("""
                Enter the Department name : Enter\s
                1 for CSE
                2 for ME
                3 for ECE""");
        departmentName = String.valueOf(DepartmentNames.values()[sc.nextInt()-1]);
        detailsOfStudents();
        System.out.println("Enter the year of the student : ");
        year = sc.nextInt();
        role = "Student";
        Student student = new Student(id,name,departmentName,year,mailId,phoneNumber);
        boolean inserted = con.insertStudentAcademicDetails(student);
        PersonalDetails personalDetails = new PersonalDetails(id,dateOfBirth,gender,fatherName,district);
        boolean inserted1 = con.insertPersonalDetails(personalDetails);
        success = con.newUser(id,dateOfBirth,role);
        if(inserted1 && inserted)
        {
            System.out.println("Student Details added successfully");
        }
        else
        {
            System.out.println("Please try later");
        }
    }

    private void detailsOfStudents() {

        System.out.println("Enter the DOB in format of dd/mm/yyyy : ");
        dateOfBirth = checker.checkDOB(sc.next());
        System.out.println("""
                Enter the Gender :\s
                 1 for Male\s
                 2 for Female\s
                 3 for Others""");
        gender = GenderType.values()[sc.nextInt()-1];
        System.out.println("Enter your Father Name : ");
        fatherName = str.nextLine();
        System.out.println("Enter the phoneNumber (Starts with 6 - 9 & 10 digits) : ");
        phoneNumber = checker.checkPhoneNumber(sc.next());
        System.out.println("Enter the mailId : ");
        mailId = checker.checkMailId(sc.next());
        System.out.println("Enter the district : ");
        district = sc.next();
    }


    public void addDepartments() throws SQLException {
        System.out.println("Enter the departmentId : ");
        departmentId = sc.nextInt();
        System.out.println("Enter the DataClass.Department Name : ");
        departmentName = sc.next();
        System.out.println("Enter the available seats in this department : ");
        availableSeats = sc.nextInt();
        System.out.println("Enter the cutOff Mark for this department : ");
        cutOffMark = sc.nextInt();
        boolean a = con.insertDepartment(departmentId,departmentName,availableSeats,cutOffMark);
        if(a)
        {
            System.out.println("Successfully added");
        }else{
            System.out.println("Please try later");
        }
    }
    public void addFacultyDetails() throws Exception
    {
        System.out.println("Enter the Faculty(ClassIncharge) Id : ");
        id = sc.next();
        System.out.println("Enter the Faculty(ClassIncharge) Name :");
        name = str.nextLine();
        System.out.println("Enter the Gender in the format of (Male - 1/Female - 2/Others - 3) : ");
        gender = GenderType.values()[sc.nextInt()-1];
        System.out.println("Enter your DOB");
        dateOfBirth = checker.checkDOB(sc.next());
        System.out.println("Enter the department name : ");
        departmentName = String.valueOf(DepartmentNames.values()[sc.nextInt()-1]);
        System.out.println("Enter the Year : ");
        year = sc.nextInt();
        System.out.println("Enter the mailId :");
        mailId = sc.next();
        System.out.println("Enter the phone number : ");
        phoneNumber = sc.next();
        System.out.println("Enter the Joining Date : ");
        date = sc.next();
        System.out.println("Enter the district of faculty :");
        district = sc.next();
        Faculty faculty = new Faculty(id,name,departmentName,year,mailId,phoneNumber);
        boolean inserted = con.insertFacultyDetails(faculty);
        boolean inserted1 = con.insertFacultyPersonalDetails(id, gender,dateOfBirth,date,district);
        role = "Faculty";
        con.newUser(id,dateOfBirth,role);
        if(inserted && inserted1)
        {
            System.out.println("Faculty details added successfully");
        }else{
            System.out.println("Please try later");
        }
    }

    public void addSubjectDetails() throws SQLException {
        System.out.println("Enter how many subject you want to add : ");
        choice = sc.nextInt();
        System.out.println("Enter the Department Id");
        departmentId = sc.nextInt();
        System.out.println("Enter the Semester : ");
        semester = sc.nextInt();
        for (int i = 0 ; i < choice;i++)
        {
            System.out.println("Enter the subject code");
            subjectCode = sc.next();
            System.out.println("Enter the Subject Name");
            subjectName = str.nextLine();
            con.insertSubjectDetails(subjectCode,subjectName,departmentId,semester);
        }
    }

    public void addNewAdmission() throws Exception
    {
        System.out.println("Enter the student name : ");
        name = checker.isValidName(str.nextLine());
        detailsOfStudents();
        System.out.println("Enter the 12th Physics mark : ");
        int m1 = sc.nextInt();
        System.out.println("Enter the 12th Chemistry mark : ");
        int m2 = sc.nextInt();
        System.out.println("Enter the 12th Maths mark : ");
        int m3 = sc.nextInt();
        cutOffMark = (m1 / 2) + (m2 / 4 ) + (m3 / 4);
        displayDepartmentDetails();
        System.out.println("Enter the department you want : ");
        departmentName = String.valueOf(DepartmentNames.values()[sc.nextInt()-1]);
        status = checkSeatAvailable(departmentName,cutOffMark);
        success = con.insertNewAdmissionDetails(name,cutOffMark,departmentName,mailId,status);
        if(success)
        {
            System.out.println(".....Your admission details added Successfully.....");
        }

    }

    public void displayDepartmentDetails() throws Exception {
        List<Department> departmentdetails;
        System.out.print("DepartMentId   DepartmentName   CutOffMark         AvailableSeats\n");
        System.out.println("--------------------------------------------------------------------");
        departmentdetails = con.getDepartments();
        for (Department department : departmentdetails) {
            System.out.printf("%-15s%-15s%-10s%-5s\n", department.getDepartmentId(), department.getDepartmentName(), department.getCutOffMarks(), department.getSeatAvailability());
        }
    }

    public void displayStudentDetails() throws Exception {
        List<Student> studentDetails;
        System.out.print("RollId   StudentName   DepartmentName         Year               MailId        PhoneNumber\n");
        System.out.println("---------------------------------------------------------------------------------------------");
        studentDetails = con.getStudentDetails();
        for (Student student : studentDetails) {
            System.out.printf("%-15s%-15s%-10s%-5s%15s%20s\n", student.getRollNumber(), student.getStudentName(), student.getDepartmentName(), student.getYear(), student.getMailId(), student.getPhoneNumber());
        }
    }

    public void displayStudentPersonalDetails() throws Exception {
        List<PersonalDetails>personalDetailsList;
        System.out.print("RollId   DOB   Gender         FatherName               District        PhoneNumber\n");
        System.out.println("---------------------------------------------------------------------------------------------");
        personalDetailsList = con.getPersonalDetails();
        for (PersonalDetails personalDetails : personalDetailsList) {
            System.out.printf("%-15s%-15s%-10s%-5s%10s\n", personalDetails.getRollNumber(), personalDetails.getDateOfBirth(), personalDetails.getGender() , personalDetails.getFatherName(), personalDetails.getDistrict());
        }
    }
    public void displayFacultyDetails() throws Exception {
        List<Faculty> facultyList;
        System.out.print("FacultyId   FacultyName   DepartmentName         Year               MailId        PhoneNumber\n");
        System.out.println("---------------------------------------------------------------------------------------------");
        facultyList = con.getFacultyDetails();
        for (Faculty faculty : facultyList) {
            System.out.printf("%-15s%-15s%-10s%-5s%15s%20s\n",faculty.getFacultyId(),faculty.getFacultyName(),faculty.getDepartmentName(),faculty.getYear(),faculty.getMailId(),faculty.getPhoneNumber());
        }
    }

    public void displayFacultyPersonalDetails() throws Exception
    {
        List<Faculty> facultyList;
        System.out.print("FacultyId   DateOfJoining   Gender         District\n");
        System.out.println("---------------------------------------------------------------------------------------------");
        facultyList = con.getFacultyPersonalDetails();
        for (Faculty faculty : facultyList) {
            System.out.printf("%-15s%-15s%-10s%-5s\n",faculty.getFacultyId(),faculty.getDateOfJoining(), faculty.getGender(),faculty.getDistrict());
        }
    }

    public void displayAdmissionDetails() throws SQLException {
        List<AdmissionDetails>admissionDetails;
        System.out.print("SerialNumber   Name   CutOff   MailId    Status");
        System.out.println("------------------------------------------------");
        admissionDetails = con.getNewAdmissionDetails();
        for(AdmissionDetails admissionDetails1 : admissionDetails)
        {
            System.out.printf("%10s%10s%10s%10s%10s",admissionDetails1.getName(),admissionDetails1.getGender(),admissionDetails1.getDepartmentName(),admissionDetails1.getStatus(),admissionDetails1.getMailId());
        }
    }

    public void searchByStudentId() throws Exception {
        System.out.println("Enter the Student RollNumber to search :");
        id = sc.next();
        Student student1 ;
        student1 = con.getByStudentId(id);
        System.out.println("-------------------------------------------------");
        System.out.print("RollNumber    Name          DepartmentName    year\n");
        System.out.println("-------------------------------------------------");
        System.out.println(student1.getRollNumber()+"    "+student1.getStudentName()+"  "+student1.getDepartmentName()+"  "+student1.getYear());
    }

    public void searchByStudentName() throws Exception {
        System.out.println("Enter the Student Name to search :");
        name = str.nextLine();
        Student student1 ;
        student1 = con.getByStudentName(name);
        System.out.println("-------------------------------------------------");
        System.out.print("RollNumber|    |Name          |DepartmentName    |year\n");
        System.out.println("-------------------------------------------------");
        System.out.println(student1.getRollNumber()+"    "+student1.getStudentName()+"  "+student1.getDepartmentName()+"  "+student1.getYear());
    }

    public void changePassWord() throws SQLException {
        System.out.println("Enter your user Id : ");
        userId = sc.next();
        System.out.println("Enter the new password : ");
        passWord = sc.next();
        success = con.updatePassWord(userId,passWord);
        if(success)
        {
            System.out.println("......Your Password changed successfully......");
        }
    }



    public String checkDuplicate(String id) throws SQLException {
        List<Student> students1 ;
        students1 = con.getStudentDetails();
        for(Student student : students1)
        {
            while (!student.getRollNumber().equalsIgnoreCase(id))
            {
                System.out.println("Roll number is already exits..");
                id = sc.next();
            }
        }
        return id;
    }

    public String  checkSeatAvailable(String departmentName,int cutOffMark) throws SQLException {
        List<Department> departmentList;
        departmentList = con.getDepartments();
        for (Department department : departmentList) {
            if (department.getDepartmentName().equalsIgnoreCase(departmentName)) {
                if (department.getSeatAvailability() > 0 && department.getCutOffMarks() <= cutOffMark) {
                    System.out.println("You are placed....");
                    status = "Selected";
                    availableSeats = department.getSeatAvailability() - 1;
                    success = con.updateSeats(availableSeats, departmentName);
                } else {
                    status = "Rejected";
                }
            }
        }
        return status;
    }
    public void close() throws Exception {
        con.close();
    }
}
