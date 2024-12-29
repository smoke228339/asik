package Models;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        School school = new School();
        try {
            BufferedReader studentReader = new BufferedReader(new FileReader("src/models/students.txt"));
            String line;
            while ((line = studentReader.readLine()) != null) {
                String[] studentData = line.split(" ");
                String name = studentData[0];
                String surname = studentData[1];
                int age = Integer.parseInt(studentData[2]);
                boolean gender = studentData[3].equalsIgnoreCase("Male");

                Student student = new Student(name, surname, age, gender);
                for (int i = 4; i < studentData.length; i++) {
                    student.addGrade(Integer.parseInt(studentData[i]));
                }
                school.addMember(student);
            }
            studentReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            BufferedReader teacherReader = new BufferedReader(new FileReader("src/models/teachers.txt"));
            String line;
            while ((line = teacherReader.readLine()) != null) {
                String[] teacherData = line.split(" ");
                String name = teacherData[0];
                String surname = teacherData[1];
                int age = Integer.parseInt(teacherData[2]);
                boolean gender = teacherData[3].equalsIgnoreCase("Male");
                String subject = teacherData[4];
                int yearsOfExperience = Integer.parseInt(teacherData[5]);
                int salary = Integer.parseInt(teacherData[6]);

                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teacher);
            }
            teacherReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Person member : school.members) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.toString());
                System.out.println(student.getName() + "'s GPA: " + student.calculateGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                System.out.println(teacher.toString());
                if (teacher.yearsOfExperience > 10) {
                    teacher.giveRaise(10);
                    System.out.println("Salary raised for " + teacher.getName() + ".");
                }
            }
        }

        System.out.println(school);
    }
}
