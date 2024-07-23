import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkoutManagerSQL {
    public void addWorkout(int uID, int tID, Date date, List<Integer> eIDs) {
        String query = "INSERT INTO Workout (uID, tID, date, eIDs) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, uID);
            stmt.setInt(2, tID);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setString(4, eIDs.toString().replace("[", "").replace("]", ""));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Workout getWorkout(int wID) {
        String query = "SELECT * FROM Workout WHERE wID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, wID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                List<Integer> eIDs = new ArrayList<>();
                for (String id : rs.getString("eIDs").split(",")) {
                    eIDs.add(Integer.parseInt(id.trim()));
                }
                return new Workout(rs.getInt("wID"), rs.getInt("uID"), rs.getInt("tID"), rs.getDate("date"), eIDs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = new ArrayList<>();
        String query = "SELECT * FROM Workout";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                List<Integer> eIDs = new ArrayList<>();
                for (String id : rs.getString("eIDs").split(",")) {
                    eIDs.add(Integer.parseInt(id.trim()));
                }
                workouts.add(new Workout(rs.getInt("wID"), rs.getInt("uID"), rs.getInt("tID"), rs.getDate("date"), eIDs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;
    }

    public void updateWorkout(int wID, int uID, int tID, Date date, List<Integer> eIDs) {
        String query = "UPDATE Workout SET uID = ?, tID = ?, date = ?, eIDs = ? WHERE wID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, uID);
            stmt.setInt(2, tID);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setString(4, eIDs.toString().replace("[", "").replace("]", ""));
            stmt.setInt(5, wID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkout(int wID) {
        String query = "DELETE FROM Workout WHERE wID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, wID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
