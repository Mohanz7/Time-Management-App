package com.example.managing.dto;


public class SubjectGradeDto {
    /**
     * 课程
     */
    private String Subject;

    /**
     * 成绩
     */
    private float Grade;


    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public float getGrade() {
        return Grade;
    }

    public void setGrade(float grade) {
        Grade = grade;
    }
}
