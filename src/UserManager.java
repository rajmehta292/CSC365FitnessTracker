import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    public void addUser(String name, int age, String gender, String username, String password, float weight, float height) {
        users.add(new User(nextId++, name, age, gender, username, password, weight, height));
    }

    public User getUser(int uID) {
        return users.stream()
                .filter(user -> user.getuID() == uID)
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void updateUser(int uID, String name, int age, String gender, String username, String password, float weight, float height) {
        User user = getUser(uID);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
            user.setGender(gender);
            user.setUsername(username);
            user.setPassword(password);
            user.setWeight(weight);
            user.setHeight(height);
        }
    }

    public void deleteUser(int uID) {
        users.removeIf(user -> user.getuID() == uID);
    }
}
