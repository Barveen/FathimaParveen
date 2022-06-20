package DataClass;


public class MarkDetails extends Student {
    private final String  rollNumber;
    private String name;
    private int departmentId;
    private int semester;
    private String subjectId;
    private int marks;
    private String subName;

    public MarkDetails(String rollNumber, int departmentId, int semester, String subjectId, int marks) {
        super();
        this.rollNumber = rollNumber;
        this.departmentId = departmentId;
        this.semester = semester;
        this.subjectId = subjectId;
        this.marks = marks;
    }

    public MarkDetails(String rollNumber, String name, int departmentId, int semester, String subjectCode, int mark, String subName) {
        super();
        this.rollNumber = rollNumber;
        this.name = name;
        this.departmentId = departmentId;
        this.semester = semester;
        this.subjectId = subjectCode;
        this.marks = mark;
        this.subName = subName;
    }

    public String getName() {
        return name;
    }

    public String getSubName() {
        return subName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSemester() {
        return semester;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "("+rollNumber +", "+departmentId+","+semester+","+subjectId+","+marks+")";


    }
}

