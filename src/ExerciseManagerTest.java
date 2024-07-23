import org.junit.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ExerciseManagerTest {
    private ExerciseManager exerciseManager;


    public void setUp() {
        exerciseManager = new ExerciseManager();
    }


    public void testAddExercise() {
        exerciseManager.addExercise("Push", "Bench Press", "Chest exercise");
        Exercise exercise = exerciseManager.getExercise(1);
        assertNotNull(exercise);
        assertEquals("Bench Press", exercise.getName());
    }

    @Test
    public void testUpdateExercise() {
        exerciseManager.addExercise("Push", "Bench Press", "Chest exercise");
        exerciseManager.updateExercise(1, "Push", "Push Up", "Chest exercise");
        Exercise exercise = exerciseManager.getExercise(1);
        assertEquals("Push Up", exercise.getName());
    }

    @Test
    public void testDeleteExercise() {
        exerciseManager.addExercise("Push", "Bench Press", "Chest exercise");
        exerciseManager.deleteExercise(1);
        Exercise exercise = exerciseManager.getExercise(1);
        assertNull(exercise);
    }

    @Test
    public void testViewExercises() {
        exerciseManager.addExercise("Push", "Bench Press", "Chest exercise");
        List<Exercise> exercises = exerciseManager.getAllExercises();
        assertEquals(1, exercises.size());
    }
}
