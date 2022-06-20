package DataSource;

import DataClass.*;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {
    boolean insertStudentAcademicDetails(Student student) throws SQLException;
    boolean insertDepartment(int departmentId, String departmentName, int cutOff, int seatavailability) throws SQLException;
    boolean insertPersonalDetails(PersonalDetails personalDetails) throws SQLException;
    boolean insertSubjectDetails(String subjectId,String subjectName, int departmentId, int semester) throws SQLException;
    List<Department> getDepartments() throws SQLException;
    List<Student> getStudentDetails() throws SQLException;
    List<PersonalDetails> getPersonalDetails() throws SQLException;
    boolean insertFacultyDetails(Faculty faculty) throws SQLException;
    boolean insertFacultyPersonalDetails(String id, GenderType gender,String dateOfBirth, String date, String district) throws Exception;
    List<Faculty> getFacultyDetails() throws Exception;
    List<Faculty> getFacultyPersonalDetails() throws Exception;
    Student getByStudentId(String rollNumber) throws Exception;
    Student getByStudentName(String name) throws Exception;
    boolean insertNewAdmissionDetails(String name, int cutOff, String departmentName, String mailId, String status) throws SQLException;
    boolean updateSeats(int seats,String departmentName) throws SQLException;
    boolean removeStudents(String rollNumber) throws SQLException;
    Faculty getByFacultyId(String id) throws SQLException;

    List<MarkDetails> getMarksByStudentId(String rollNumber) throws SQLException;

    List<AdmissionDetails> getNewAdmissionDetails() throws SQLException;

    boolean newUser(String userId,String password,String role) throws SQLException;
    UserDetails getUser(String  userId) throws SQLException;

    boolean insertMarks(MarkDetails[] markDetails) throws SQLException;
    void close() throws Exception;

    List<Student> getStudentsByDepartmentAndYear(String departmentName, int year)throws SQLException;

    List<MarkDetails> getFailStudents(int semester) throws SQLException;

    boolean updatePassWord(String userId, String passWord) throws SQLException;
}

