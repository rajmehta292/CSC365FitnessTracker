import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainerManagerSQL {
    public void addTrainer(String name, String specialty, int experience) {
        String query = "INSERT INTO Trainer (name, specialty, experience) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, specialty);
            stmt.setInt(3, experience);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Trainer getTrainer(int tID) {
        String query = "SELECT * FROM Trainer WHERE tID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Trainer(rs.getInt("tID"), rs.getString("name"), rs.getString("specialty"), rs.getInt("experience"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String query = "SELECT * FROM Trainer";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                trainers.add(new Trainer(rs.getInt("tID"), rs.getString("name"), rs.getString("specialty"), rs.getInt("experience")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }

    public void updateTrainer(int tID, String name, String specialty, int experience) {
        String query = "UPDATE Trainer SET name = ?, specialty = ?, experience = ? WHERE tID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, specialty);
            stmt.setInt(3, experience);
            stmt.setInt(4, tID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrainer(int tID) {
        String query = "DELETE FROM Trainer WHERE tID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
