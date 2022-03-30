package com.example.lab8;

public class StudentRecord{

    String studentID;
    float midterm,assignments,finalExam,finalMark;
    char letterGrade;

    public StudentRecord(String studentID, float assignments, float midterm, float finalExam) {
        this.studentID = studentID;
        this.midterm = midterm;
        this.assignments = assignments;
        this.finalExam = finalExam;
        getFinals();
    }

    private void getFinals() {

        this.finalMark = (this.assignments * 0.2f) + (this.midterm * 0.3f) + (this.finalExam * 0.5f);

        if(this.finalMark <= 49){
            this.letterGrade = 'F';
        }
        else if(this.finalMark <= 59){
            letterGrade = 'D';
        }
        else if(finalMark <= 69){
            this.letterGrade = 'C';
        }
        else if(finalMark <= 79){
            this.letterGrade = 'B';
        }
        else{
            this.letterGrade = 'A';
        }
    }

    public String getStudentID() {
        return studentID;
    }

    public float getMidterm() {
        return midterm;
    }

    public float getAssignments() {
        return assignments;
    }

    public float getFinalExam() {
        return finalExam;
    }

    public float getFinalMark() {
        return finalMark;
    }

    public char getLetterGrade() {
        return letterGrade;
    }
}
