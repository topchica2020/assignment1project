import models.School;
import models.Student;
import models.Teacher;
import models.Person;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        // Читаем данные студентов и добавляем их в School
        try (Scanner studentScanner = new Scanner(new File("src/students.txt"))) {
            while (studentScanner.hasNextLine()) {
                String line = studentScanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Female");

                Student student = new Student(name, surname, age, gender);
                for (int i = 4; i < parts.length; i++) {
                    student.addGrade(Integer.parseInt(parts[i]));
                }
                school.addMember(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при чтении файла студентов: " + e.getMessage());
        }

        // Читаем данные учителей и добавляем их в School
        try (Scanner teacherScanner = new Scanner(new File("src/teachers.txt"))) {
            while (teacherScanner.hasNextLine()) {
                String line = teacherScanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Female");
                String subject = parts[4];
                int yearsOfExperience = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);

                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                // Увеличиваем зарплату учителям с опытом больше 10 лет
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10); // Увеличиваем зарплату на 10%
                }
                school.addMember(teacher);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при чтении файла учителей: " + e.getMessage());
        }

        // Сортируем участников школы по фамилии
        school.sortMembersBySurname();

        // Выводим всех участников
        System.out.println("Члены школы:");
        System.out.println(school);

        // Тестируем методы calculateGPA и giveRaise
        System.out.println("Тестирование методов студентов и учителей:");
        for (Person member : school.getMembers()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.getName() + "'s GPA: " + student.calculateGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                System.out.println(teacher.getName() + "'s зарплата после повышения: $" + teacher.getSalary());
            }
        }
    }
}
