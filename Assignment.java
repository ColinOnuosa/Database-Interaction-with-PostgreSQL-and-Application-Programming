import java.sql.*;

public class Assignment {
    //CREATED A CONNECTION FUNCTION TO EASE CONNECTING TO THE DATABASE
    public static Connection connect(){
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "!2005COpost";

        try { // Load PostgreSQL JDBC Driver
            return DriverManager.getConnection(url, user, password);
        }
        catch (/*ClassNotFoundException | SQL*/ Exception e) {
            System.out.println("Failed to establish connection.");
            return null;
        }

    }
    //FUNCTION TO GET ALL STUDENTS
    public static void getAllStudents(){
        //ADAPTED FROM LECTURE SLIDES BUT WERE NOT DEEMED NECESSARY TO USE
        //Class.forName("org.postgresql.Driver");

        String SQL = "SELECT student_id, first_name, last_name, email, enrollment_date FROM students";

        try(Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(SQL)){
            System.out.println("--------------------------------------------------------");
            while(rs.next()){
                int id = rs.getInt("student_id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String email = rs.getString("email");
                Date enrollment = rs.getDate("enrollment_date");
                System.out.printf("ID: %d | Name: %8s %8s | Email: %22s | Enrolled: %s%n",
                        id, fname, lname, email, enrollment);
            }
            System.out.println("--------------------------------------------------------");
        }catch(Exception e){
            // PRINTING OUT AN ERROR MESSAGE IN THE EVENT OF AN ERROR FOUND
            System.out.println("COULDN'T GET ALL STUDENTS");
        }

        //ADAPTED FROM LECTURE SLIDES BUT WERE NOT DEEMED NECESSARY TO USE
        /* Close resources
        rs.close();
        stmt.close();*/
    }
    //FUNCTION TO ADD STUDENTS
    public static void addStudent(String first_name, String last_name, String email, Date enrollment_date){
        String SQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setDate(4, enrollment_date);
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }

    }
    //FUNCTION TO UPDATE STUDENT EMAIL
    public static void updateStudentEmail(int student_id, String new_email){
        String SQL = "UPDATE students SET email = ? WHERE student_id = ?";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(SQL)){
            stmt.setInt(2, student_id);
            stmt.setString(1, new_email);
            stmt.executeUpdate();
            System.out.println("Student email updated successfully.");
        } catch (Exception e) {
            System.out.println("Couldn't update email of Student " + student_id);
        }
    }
    //FUNCTION TO DELETE STUDENT WITH SPECIFIC ID
    public static void deleteStudent(int student_id){
        String SQL = "DELETE FROM students WHERE student_id = ?";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(SQL)){
            stmt.setInt(1, student_id);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            System.out.println("Couldn't delete student " + student_id);
        }
    }

    // MAIN FUNCTION THAT WILL HOST ONLY THE CRUD FUNCTIONS
    public static void main(String[] args) {
       // getAllStudents();
       // addStudent("yung", "jedah", "youngjeds@gmail.com" , Date.valueOf("2025-11-07") );

       // getAllStudents();
       // updateStudentEmail(10, "fakie2021@gmail.com");

        // getAllStudents();
        // deleteStudent(10);
        // getAllStudents();
    }

}


