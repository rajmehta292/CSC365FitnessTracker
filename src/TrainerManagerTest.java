import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrainerManagerTest {
    private TrainerManager trainerManager;

    @Before
    public void setUp() {
        trainerManager = new TrainerManager();
    }

    @Test
    public void testAddTrainer() {
        trainerManager.addTrainer("Alice Smith", "Strength", 5);
        Trainer trainer = trainerManager.getTrainer(1);
        assertNotNull(trainer);
        assertEquals("Alice Smith", trainer.getName());
    }

    @Test
    public void testUpdateTrainer() {
        trainerManager.addTrainer("Alice Smith", "Strength", 5);
        trainerManager.updateTrainer(1, "Bob Johnson", "Cardio", 7);
        Trainer trainer = trainerManager.getTrainer(1);
        assertEquals("Bob Johnson", trainer.getName());
    }

    @Test
    public void testDeleteTrainer() {
        trainerManager.addTrainer("Alice Smith", "Strength", 5);
        trainerManager.deleteTrainer(1);
        Trainer trainer = trainerManager.getTrainer(1);
        assertNull(trainer);
    }

    @Test
    public void testViewTrainers() {
        trainerManager.addTrainer("Alice Smith", "Strength", 5);
        List<Trainer> trainers = trainerManager.getAllTrainers();
        assertEquals(1, trainers.size());
    }
}
