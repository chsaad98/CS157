import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVToDatabase {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/HumanAgePrediction";
        String username = "root";
        String password = "Munazza123@";


        String csvFilePath = "/Users/chaudhrysaad/Downloads/Human.dataset/test.csv";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO AgePrediction (gender, height_cm, weight_kg, blood_pressure_systolic, blood_pressure_diastolic, cholesterol_level, bmi, blood_glucose_level, bone_density, vision_sharpness, hearing_ability_db, physical_activity_level, smoking_status, alcohol_consumption, diet, chronic_diseases, medication_use, family_history, cognitive_function, mental_health_status, sleep_patterns, stress_levels, pollution_exposure, sun_exposure, education_level, income_level) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/chaudhrysaad/Downloads/Human.dataset/test.csv"));
            String lineText = null;
            int count = 0;

            lineReader.readLine();

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");

                String gender = data[0];
                float height = Float.parseFloat(data[1]);
                float weight = Float.parseFloat(data[2]);
                int bloodPressureSystolic = Integer.parseInt(data[3].split("/")[0]);
                int bloodPressureDiastolic = Integer.parseInt(data[3].split("/")[1]);
                float cholesterolLevel = Float.parseFloat(data[4]);
                float bmi = Float.parseFloat(data[5]);
                float bloodGlucose = Float.parseFloat(data[6]);
                float boneDensity = Float.parseFloat(data[7]);
                String vision = data[8];
                float hearing = Float.parseFloat(data[9]);
                String physicalActivityLevel = data[10];
                String smokingStatus = data[11];
                String alcoholConsumption = data[12];
                String diet = data[13];
                String chronicDiseases = data[14];
                String medicationUse = data[15];
                String familyHistory = data[16];
                String cognitiveFunction = data[17];
                String mentalHealthStatus = data[18];
                String sleepPatterns = data[19];
                String stressLevels = data[20];
                String pollutionExposure = data[21];
                String sunExposure = data[22];
                String educationLevel = data[23];
                 String incomeLevel = data[24];

                statement.setString(1, gender);
                statement.setFloat(2, height);
                statement.setFloat(3, weight);
                statement.setInt(4, bloodPressureSystolic);
                statement.setInt(5, bloodPressureDiastolic);
                statement.setFloat(6, cholesterolLevel);
                statement.setFloat(7, bmi);
                statement.setFloat(8, bloodGlucose);
                statement.setFloat(9, boneDensity);
                statement.setString(10, vision);
                statement.setFloat(11, hearing);
                statement.setString(12, physicalActivityLevel);
                statement.setString(13, smokingStatus);
                statement.setString(14, alcoholConsumption);
                statement.setString(15, diet);
                statement.setString(16, chronicDiseases);
                statement.setString(17, medicationUse);
                statement.setString(18, familyHistory);
                statement.setString(19, cognitiveFunction);
                statement.setString(20, mentalHealthStatus);
                statement.setString(21, sleepPatterns);
                statement.setString(22, stressLevels);
                statement.setString(23, pollutionExposure);
                statement.setString(24, sunExposure);
                statement.setString(25, educationLevel);
                statement.setString(26, incomeLevel);

                statement.addBatch();

                if (count % 100 == 0) {
                    statement.executeBatch();
                }
                count++;
            }

            lineReader.close();
            statement.executeBatch();
            connection.commit();
            statement.close();
            connection.close();

            System.out.println("Data inserted successfully.");

        } catch (IOException ex) {
            System.err.println("Error reading the CSV file");
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

