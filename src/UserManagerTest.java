import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserManagerTest {
    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testAddUser() {
        userManager.addUser("John Doe", 30, "Male", "johndoe", "password123", 75.0f, 175.0f);
        User user = userManager.getUser(1);
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testUpdateUser() {
        userManager.addUser("John Doe", 30, "Male", "johndoe", "password123", 75.0f, 175.0f);
        userManager.updateUser(1, "Jane Doe", 28, "Female", "janedoe", "password456", 65.0f, 165.0f);
        User user = userManager.getUser(1);
        assertEquals("Jane Doe", user.getName());
    }

    @Test
    public void testDeleteUser() {
        userManager.addUser("John Doe", 30, "Male", "johndoe", "password123", 75.0f, 175.0f);
        userManager.deleteUser(1);
        User user = userManager.getUser(1);
        assertNull(user);
    }

    @Test
    public void testViewUsers() {
        userManager.addUser("John Doe", 30, "Male", "johndoe", "password123", 75.0f, 175.0f);
        List<User> users = userManager.getAllUsers();
        assertEquals(1, users.size());
    }
}
