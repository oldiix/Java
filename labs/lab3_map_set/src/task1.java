import java.util.HashMap;
import java.util.Map;

public class task1 {

    static class Student {

        String name;
        int age;
        String grade;

        Student(String name, int age, String grade) {
            this.name  = name;
            this.age   = age;
            this.grade = grade;
        }

        void displayInfo() {
            System.out.println("Name:  " + name);
            System.out.println("Age:   " + age);
            System.out.println("Grade: " + grade);
        }
    }

    static class StudentRegistry {

        Map<Integer, Student> registry = new HashMap<>();

        void addStudent(int id, Student student) {
            registry.put(id, student);
        }

        void removeStudent(int id) {
            registry.remove(id);
        }

        void displayAllStudents() {
            for (Map.Entry<Integer, Student> entry : registry.entrySet()) {
                System.out.println("ID: " + entry.getKey());
                entry.getValue().displayInfo();
                System.out.println();
            }
        }

        void searchStudent(int id) {
            Student student = registry.get(id);
            if (student != null) {
                student.displayInfo();
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        }
    }

    public static void main(String[] args) {

        Student student1 = new Student("Kateryna Doroftei", 19, "A");
        Student student2 = new Student("Anastasiia Demianchuk",   18, "A");

        StudentRegistry registry = new StudentRegistry();

        registry.addStudent(1, student1);
        registry.addStudent(2, student2);

        System.out.println("\nDisplaying all students:");
        registry.displayAllStudents();

        System.out.println("Searching for student with ID 1:");
        registry.searchStudent(1);

        System.out.println("\nRemoving student with ID 2...\n");
        registry.removeStudent(2);

        System.out.println("Displaying all students after removal:");
        registry.displayAllStudents();
    }
}