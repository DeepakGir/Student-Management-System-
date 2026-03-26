import java.util.Scanner;
 class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Student Management System (MySQL + JDBC) =====");
             System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    String roll = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    manager.addStudent(new Student(roll, name, age));
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter Roll No to Update: ");
                    String rollToUpdate = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    manager.updateStudent(new Student(rollToUpdate, newName, newAge));
                    break;
                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    String rollToDelete = scanner.nextLine();
                    manager.deleteStudent(rollToDelete);
                    break;
                case 5:
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 5);}}


