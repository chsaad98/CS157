import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDatabase {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/HumanAgePrediction";
        String username = "root";
        String password = "Munazza123@";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);


            String sql = "SELECT gender, AVG(height_cm) AS avg_height FROM AgePrediction GROUP BY gender ORDER BY avg_height DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gender = resultSet.getString("gender");
                float avgHeight = resultSet.getFloat("avg_height");
                System.out.println("Gender with highest average height: " + gender + " (Average Height: " + avgHeight + " cm)");
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
