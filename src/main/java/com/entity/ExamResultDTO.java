package com.entity;

public class ExamResultDTO {
    private String resultid;
    private String studentid;
    private String examid;
    private String marks;
    private String totalMarks;
    private String firstName;
    private String middleName;
    private String lastName;
    private String examTitle;

    public ExamResultDTO(String resultid, String studentid, String examid, String marks, String totalMarks, String firstName, String middleName, String lastName, String examTitle)
    {
        this.resultid = resultid;
        this.studentid = studentid;
        this.examid = examid;
        this.marks = marks;
        this.totalMarks = totalMarks;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.examTitle = examTitle;
    }

    public String getResultid()
    {
        return resultid;
    }

    public void setResultid(String resultid)
    {
        this.resultid = resultid;
    }

    public String getStudentid()
    {
        return studentid;
    }

    public void setStudentid(String studentid)
    {
        this.studentid = studentid;
    }

    public String getExamid()
    {
        return examid;
    }

    public void setExamid(String examid)
    {
        this.examid = examid;
    }

    // Getters and setters
    public String getMarks() { return marks; }
    public void setMarks(String marks) { this.marks = marks; }

    public String getTotalMarks() { return totalMarks; }
    public void setTotalMarks(String totalMarks) { this.totalMarks = totalMarks; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getExamTitle() { return examTitle; }
    public void setExamTitle(String examTitle) { this.examTitle = examTitle; }
}
