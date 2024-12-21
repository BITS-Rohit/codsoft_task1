package CodeSoftTasks;

import java.util.ArrayList;
import java.util.Scanner;

// Class representing a CodeSoftTasks.Student
class Student {
    private final int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and setters for student attributes
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

// Main class for the CodeSoftTasks.Student Management System
public class StudentManagementSystem {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static int nextId = 1; // Auto-increment ID

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- CodeSoft Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("\n--- Add New CodeSoftTasks.Student ---");
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Enter course name: ");
        String course = scanner.nextLine();

        students.add(new Student(nextId++, name, age, course));
        System.out.println("CodeSoftTasks.Student added successfully!");
    }

    private static void viewStudents() {
        System.out.println("\n--- List of Students ---");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("\n--- Update CodeSoftTasks.Student ---");
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isBlank()) student.setName(name);

                System.out.print("Enter new age (or 0 to keep current): ");
                int age = scanner.nextInt();
                if (age > 0) student.setAge(age);

                scanner.nextLine(); // Consume leftover newline
                System.out.print("Enter new course (leave blank to keep current): ");
                String course = scanner.nextLine();
                if (!course.isBlank()) student.setCourse(course);

                System.out.println("CodeSoftTasks.Student updated successfully!");
                return;
            }
        }
        System.out.println("CodeSoftTasks.Student ID not found.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("\n--- Delete CodeSoftTasks.Student ---");
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("CodeSoftTasks.Student deleted successfully!");
                return;
            }
        }
        System.out.println("CodeSoftTasks.Student ID not found.");
    }
}
