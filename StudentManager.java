import java.sql.*;
public class StudentManager {

    private static final String url = "jdbc:mysql://localhost:3306/university";
    private static final String username = "root";
    private static final String password = "1234";
    private Connection conn;

    public StudentManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
    public void addStudent(Student s) {
        String sql = "INSERT INTO students (roll_no, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getRollNo());
            stmt.setString(2, s.getName());
            stmt.setInt(3, s.getAge());
            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void viewStudents() {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n List of Students:");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getString("roll_no") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("exception in occured in viewStudentMethod "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateStudent(Student s) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE roll_no = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getAge());
            stmt.setString(3, s.getRollNo());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student updated.");
            } else {
                System.out.println("⚠️ Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String rollNo) {
        String sql = "DELETE FROM students WHERE roll_no = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rollNo);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student deleted.");
            } else {
                System.out.println("⚠️ Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
