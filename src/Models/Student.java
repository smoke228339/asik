package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person {
    private int studentID;
    private List<Integer> grades;

    private static Random random = new Random();

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = random.nextInt(1000000000);
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size() / 25;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}








