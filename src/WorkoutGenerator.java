import java.util.*;

public class WorkoutGenerator {
    private ExerciseManager exerciseManager;

    public WorkoutGenerator(ExerciseManager exerciseManager) {
        this.exerciseManager = exerciseManager;
    }

    public List<Workout> generateRandomWorkouts(int uID, int tID) {
        List<Workout> workouts = new ArrayList<>();
        List<Exercise> pushExercises = filterExercisesByGroup("Push");
        List<Exercise> pullExercises = filterExercisesByGroup("Pull");
        List<Exercise> legExercises = filterExercisesByGroup("Legs");
        List<Exercise> cardioExercises = filterExercisesByGroup("Cardio");

        //Garbage Generator
        workouts.add(generateWorkout("Push", pushExercises, uID, tID));
        workouts.add(generateWorkout("Pull", pullExercises, uID, tID));
        workouts.add(generateWorkout("Legs", legExercises, uID, tID));
        workouts.add(generateWorkout("Cardio", cardioExercises, uID, tID));

        return workouts;
    }

    private Workout generateWorkout(String group, List<Exercise> exercises, int uID, int tID)
    {
        //Garbage Generator

        Collections.shuffle(exercises);
        int exerciseCount = Math.min(3, exercises.size());
        List<Integer> selectedExerciseIds = new ArrayList<>();

        for (int i = 0; i < exerciseCount; i++) {
            selectedExerciseIds.add(exercises.get(i).geteID());
        }

        return new Workout(0, uID, tID, new Date(), selectedExerciseIds);
    }

    private List<Exercise> filterExercisesByGroup(String group)
    {

        List<Exercise> filteredExercises = new ArrayList<>();
        for (Exercise exercise : exerciseManager.getAllExercises()) {
            if (exercise.getGroup().equalsIgnoreCase(group)) {
                filteredExercises.add(exercise);
            }
        }
        return filteredExercises;
    }
}
