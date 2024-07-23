import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagerSQL {
    public void addUser(String name, int age, String gender, String username, String password, float weight, float height) {
        String query = "INSERT INTO User (name, age, gender, username, password, weight, height) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setFloat(6, weight);
            stmt.setFloat(7, height);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(int uID) {
        String query = "SELECT * FROM User WHERE uID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, uID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("uID"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"),
                        rs.getString("username"), rs.getString("password"), rs.getFloat("weight"), rs.getFloat("height"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("uID"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"),
                        rs.getString("username"), rs.getString("password"), rs.getFloat("weight"), rs.getFloat("height")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(int uID, String name, int age, String gender, String username, String password, float weight, float height) {
        String query = "UPDATE User SET name = ?, age = ?, gender = ?, username = ?, password = ?, weight = ?, height = ? WHERE uID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setFloat(6, weight);
            stmt.setFloat(7, height);
            stmt.setInt(8, uID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int uID) {
        String query = "DELETE FROM User WHERE uID = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, uID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
