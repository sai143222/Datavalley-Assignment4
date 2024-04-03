import java.sql.*;

public class patientInfo {
    public static void main(String[] args) {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "thrilok", " ");

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT patient_id, name, problem, bill FROM patients");

            // Step 5: Process the results
            while (resultSet.next()) {
                int patientId = resultSet.getInt("patient_id");
                String name = resultSet.getString("name");
                String problem = resultSet.getString("problem");
                double bill = resultSet.getDouble("bill");

                System.out.println("Patient ID: " + patientId);
                System.out.println("Name: " + name);
                System.out.println("Problem: " + problem);
                System.out.println("Bill: " + bill);
                System.out.println("--------------------------------------");
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}