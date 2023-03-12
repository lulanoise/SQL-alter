package it.develhope;
import java.sql.*;

public class Start {

        public static void main(String[] args) throws SQLException {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "524013659?Ln");
                statement = connection.createStatement();
                String query1 = "ALTER TABLE students ADD COLUMN country VARCHAR(30) AFTER first_name";
                statement.execute(query1);
                String query2 = "UPDATE students SET country='Italy' WHERE student_id=1 OR student_id=2";
                statement.execute(query2);
                String query3 = "UPDATE students SET country='Germany' WHERE student_id=3 OR student_id=4";
                statement.execute(query3);
                String query4 = "SELECT * FROM students";

                if (statement.execute(query4)) {
                    resultSet = statement.getResultSet();
                    while (resultSet.next()) {
                        String countries = resultSet.getString(3);
                        System.out.println(countries);
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }