import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkoutManager {
    private List<Workout> workouts = new ArrayList<>();
    private int nextId = 1;

    public void addWorkout(int uID, int tID, Date date, List<Integer> eIDs) {
        workouts.add(new Workout(nextId++, uID, tID, date, eIDs));
    }

    public Workout getWorkout(int wID) {
        return workouts.stream()
                .filter(workout -> workout.getwID() == wID)
                .findFirst()
                .orElse(null);
    }

    public List<Workout> getAllWorkouts() {
        return workouts;
    }

    public void updateWorkout(int wID, int uID, int tID, Date date, List<Integer> eIDs) {
        Workout workout = getWorkout(wID);
        if (workout != null) {
            workout.setuID(uID);
            workout.settID(tID);
            workout.setDate(date);
            workout.seteIDs(eIDs);
        }
    }

    public void deleteWorkout(int wID) {
        workouts.removeIf(workout -> workout.getwID() == wID);
    }
}
