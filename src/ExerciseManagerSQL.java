import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseManagerSQL {
    public void addExercise(String group, String name, String description) {
        String query = "INSERT INTO Exercise (`group`, name, description) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, group);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Exercise getExercise(int eID) {
        String query = "SELECT * FROM Exercise WHERE eID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Exercise(rs.getInt("eID"), rs.getString("group"), rs.getString("name"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<>();
        String query = "SELECT * FROM Exercise";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                exercises.add(new Exercise(rs.getInt("eID"), rs.getString("group"), rs.getString("name"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }

    public void updateExercise(int eID, String group, String name, String description) {
        String query = "UPDATE Exercise SET `group` = ?, name = ?, description = ? WHERE eID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, group);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setInt(4, eID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteExercise(int eID) {
        String query = "DELETE FROM Exercise WHERE eID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
