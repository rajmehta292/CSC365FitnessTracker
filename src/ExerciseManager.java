import java.util.ArrayList;
import java.util.List;

public class ExerciseManager {
    private List<Exercise> exercises = new ArrayList<>();
    private int nextId = 1;

    public void addExercise(String group, String name, String description) {
        exercises.add(new Exercise(nextId++, group, name, description));
    }

    public Exercise getExercise(int eID) {
        return exercises.stream()
                .filter(exercise -> exercise.geteID() == eID)
                .findFirst()
                .orElse(null);
    }

    public List<Exercise> getAllExercises() {
        return exercises;
    }

    public void updateExercise(int eID, String group, String name, String description) {
        Exercise exercise = getExercise(eID);
        if (exercise != null) {
            exercise.setGroup(group);
            exercise.setName(name);
            exercise.setDescription(description);
        }
    }

    public void deleteExercise(int eID) {
        exercises.removeIf(exercise -> exercise.geteID() == eID);
    }
}
