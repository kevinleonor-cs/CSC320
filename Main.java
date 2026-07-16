import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(105, "Alice Johnson", "123 Oak Street"));
        students.add(new Student(102, "Bob Smith", "456 Maple Avenue"));
        students.add(new Student(108, "Charlie Brown", "789 Pine Road"));
        students.add(new Student(101, "Diana Prince", "321 Elm Drive"));
        students.add(new Student(110, "Edward Norton", "654 Cedar Lane"));
        students.add(new Student(103, "Fiona Green", "987 Birch Court"));
        students.add(new Student(107, "George White", "147 Walnut Way"));
        students.add(new Student(104, "Hannah Lee", "258 Spruce Blvd"));
        students.add(new Student(109, "Ivan Torres", "369 Willow Place"));
        students.add(new Student(106, "Julia Adams", "741 Aspen Circle"));

        System.out.println("==============================================");
        System.out.println("         ORIGINAL STUDENT LIST");
        System.out.println("==============================================");
        printHeader();
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by name using NameComparator
        ArrayList<Student> sortedByName = new ArrayList<>(students);
        SelectionSort.selectionSort(sortedByName, new NameComparator());

        System.out.println("\n==============================================");
        System.out.println("     STUDENTS SORTED BY NAME");
        System.out.println("==============================================");
        printHeader();
        for (Student s : sortedByName) {
            System.out.println(s);
        }

        // Sort by roll number using RollnoComparator
        ArrayList<Student> sortedByRollno = new ArrayList<>(students);
        SelectionSort.selectionSort(sortedByRollno, new RollnoComparator());

        System.out.println("\n==============================================");
        System.out.println("     STUDENTS SORTED BY ROLL NUMBER");
        System.out.println("==============================================");
        printHeader();
        for (Student s : sortedByRollno) {
            System.out.println(s);
        }
    }

    private static void printHeader() {
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s %-20s %s%n", "Roll No", "Name", "Address");
        System.out.println("----------------------------------------------");
    }
}
