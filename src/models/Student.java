package models;
import java.util.ArrayList;

public class Student extends Person {
    private int studentID;
    private ArrayList<Integer> grades;
    private static int lastID = 0;
    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        grades = new ArrayList<>();
        studentID = ++lastID; // Generates a unique ID for each student
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}