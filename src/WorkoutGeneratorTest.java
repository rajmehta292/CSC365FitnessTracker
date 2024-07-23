import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WorkoutGeneratorTest {
    private ExerciseManager exerciseManager;
    private WorkoutGenerator workoutGenerator;

    @Before
    public void setUp() {
        exerciseManager = new ExerciseManager();
        workoutGenerator = new WorkoutGenerator(exerciseManager);

        // Add sample exercises
        exerciseManager.addExercise("Push", "Bench Press", "Chest exercise");
        exerciseManager.addExercise("Push", "Push Up", "Chest exercise");
        exerciseManager.addExercise("Push", "Tricep Dip", "Tricep exercise");
        exerciseManager.addExercise("Pull", "Pull Up", "Back exercise");
        exerciseManager.addExercise("Pull", "Bicep Curl", "Bicep exercise");
        exerciseManager.addExercise("Legs", "Squat", "Leg exercise");
        exerciseManager.addExercise("Legs", "Leg Press", "Leg exercise");
        exerciseManager.addExercise("Cardio", "Running", "Cardio exercise");
        exerciseManager.addExercise("Cardio", "Cycling", "Cardio exercise");
    }

    @Test
    public void testGenerateRandomWorkouts() {
        List<Workout> workouts = workoutGenerator.generateRandomWorkouts(1, 1);
        assertEquals(4, workouts.size());
    }
}
