import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class WorkoutManagerTest {
    private WorkoutManager workoutManager;

    @Before
    public void setUp() {
        workoutManager = new WorkoutManager();
    }

    @Test
    public void testAddWorkout() {
        List<Integer> eIDs = new ArrayList<>();
        eIDs.add(1);
        eIDs.add(2);
        workoutManager.addWorkout(1, 1, new Date(), eIDs);
        Workout workout = workoutManager.getWorkout(1);
        assertNotNull(workout);
        assertEquals(1, workout.getuID());
    }

    @Test
    public void testUpdateWorkout() {
        List<Integer> eIDs = new ArrayList<>();
        eIDs.add(1);
        eIDs.add(2);
        workoutManager.addWorkout(1, 1, new Date(), eIDs);
        eIDs.add(3);
        workoutManager.updateWorkout(1, 2, 2, new Date(), eIDs);
        Workout workout = workoutManager.getWorkout(1);
        assertEquals(2, workout.getuID());
    }

    @Test
    public void testDeleteWorkout() {
        List<Integer> eIDs = new ArrayList<>();
        eIDs.add(1);
        eIDs.add(2);
        workoutManager.addWorkout(1, 1, new Date(), eIDs);
        workoutManager.deleteWorkout(1);
        Workout workout = workoutManager.getWorkout(1);
        assertNull(workout);
    }

    @Test
    public void testViewWorkouts() {
        List<Integer> eIDs = new ArrayList<>();
        eIDs.add(1);
        eIDs.add(2);
        workoutManager.addWorkout(1, 1, new Date(), eIDs);
        List<Workout> workouts = workoutManager.getAllWorkouts();
        assertEquals(1, workouts.size());
    }
}
