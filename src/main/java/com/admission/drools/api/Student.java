package com.admission.drools.api;

public class Student {
    private String studentName;
    private String schoolName;
    private String studentId;
    private int previousPercentage;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getPreviousPercentage() {
        return previousPercentage;
    }

    public void setPreviousPercentage(int previousPercentage) {
        this.previousPercentage = previousPercentage;
    }
}
