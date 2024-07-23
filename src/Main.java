import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ExerciseManager exerciseManager = new ExerciseManager();
    private static UserManager userManager = new UserManager();
    private static TrainerManager trainerManager = new TrainerManager();
    private static WorkoutManager workoutManager = new WorkoutManager();
    private static WorkoutGenerator workoutGenerator = new WorkoutGenerator(exerciseManager);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageExercises();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    manageTrainers();
                    break;
                case 4:
                    manageWorkouts();
                    break;
                case 5:
                    generateRandomWorkouts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the application.");
    }

    private static void printMenu() {
        System.out.println("Fitness Tracker Application Menu:");
        System.out.println("1. Manage Exercises");
        System.out.println("2. Manage Users");
        System.out.println("3. Manage Trainers");
        System.out.println("4. Manage Workouts");
        System.out.println("5. Generate Random Workouts");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void manageExercises() {
        boolean managing = true;

        while (managing) {
            System.out.println("\nManage Exercises:");
            System.out.println("1. Add Exercise");
            System.out.println("2. Update Exercise");
            System.out.println("3. Delete Exercise");
            System.out.println("4. View Exercises");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addExercise();
                    break;
                case 2:
                    updateExercise();
                    break;
                case 3:
                    deleteExercise();
                    break;
                case 4:
                    viewExercises();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExercise() {
        System.out.print("Enter group: ");
        String group = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        exerciseManager.addExercise(group, name, description);
        System.out.println("Exercise added successfully.");
    }

    private static void updateExercise() {
        System.out.print("Enter exercise ID to update: ");
        int eID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Exercise exercise = exerciseManager.getExercise(eID);
        if (exercise != null) {
            System.out.print("Enter new group (current: " + exercise.getGroup() + "): ");
            String group = scanner.nextLine();
            System.out.print("Enter new name (current: " + exercise.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new description (current: " + exercise.getDescription() + "): ");
            String description = scanner.nextLine();

            exerciseManager.updateExercise(eID, group, name, description);
            System.out.println("Exercise updated successfully.");
        } else {
            System.out.println("Exercise not found.");
        }
    }

    private static void deleteExercise() {
        System.out.print("Enter exercise ID to delete: ");
        int eID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        exerciseManager.deleteExercise(eID);
        System.out.println("Exercise deleted successfully.");
    }

    private static void viewExercises() {
        List<Exercise> exercises = exerciseManager.getAllExercises();
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }

    private static void manageUsers() {
        boolean managing = true;

        while (managing) {
            System.out.println("\nManage Users:");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. View Users");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    viewUsers();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter weight: ");
        float weight = scanner.nextFloat();
        System.out.print("Enter height: ");
        float height = scanner.nextFloat();
        scanner.nextLine();  // Consume newline

        userManager.addUser(name, age, gender, username, password, weight, height);
        System.out.println("User added successfully.");
    }

    private static void updateUser() {
        System.out.print("Enter user ID to update: ");
        int uID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        User user = userManager.getUser(uID);
        if (user != null) {
            System.out.print("Enter new name (current: " + user.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new age (current: " + user.getAge() + "): ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter new gender (current: " + user.getGender() + "): ");
            String gender = scanner.nextLine();
            System.out.print("Enter new username (current: " + user.getUsername() + "): ");
            String username = scanner.nextLine();
            System.out.print("Enter new password (current: " + user.getPassword() + "): ");
            String password = scanner.nextLine();
            System.out.print("Enter new weight (current: " + user.getWeight() + "): ");
            float weight = scanner.nextFloat();
            System.out.print("Enter new height (current: " + user.getHeight() + "): ");
            float height = scanner.nextFloat();
            scanner.nextLine();  // Consume newline

            userManager.updateUser(uID, name, age, gender, username, password, weight, height);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        int uID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        userManager.deleteUser(uID);
        System.out.println("User deleted successfully.");
    }

    private static void viewUsers() {
        List<User> users = userManager.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void manageTrainers() {
        boolean managing = true;

        while (managing) {
            System.out.println("\nManage Trainers:");
            System.out.println("1. Add Trainer");
            System.out.println("2. Update Trainer");
            System.out.println("3. Delete Trainer");
            System.out.println("4. View Trainers");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTrainer();
                    break;
                case 2:
                    updateTrainer();
                    break;
                case 3:
                    deleteTrainer();
                    break;
                case 4:
                    viewTrainers();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTrainer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialty: ");
        String specialty = scanner.nextLine();
        System.out.print("Enter experience (years): ");
        int experience = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        trainerManager.addTrainer(name, specialty, experience);
        System.out.println("Trainer added successfully.");
    }

    private static void updateTrainer() {
        System.out.print("Enter trainer ID to update: ");
        int tID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Trainer trainer = trainerManager.getTrainer(tID);
        if (trainer != null) {
            System.out.print("Enter new name (current: " + trainer.getName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new specialty (current: " + trainer.getSpecialty() + "): ");
            String specialty = scanner.nextLine();
            System.out.print("Enter new experience (current: " + trainer.getExperience() + "): ");
            int experience = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            trainerManager.updateTrainer(tID, name, specialty, experience);
            System.out.println("Trainer updated successfully.");
        } else {
            System.out.println("Trainer not found.");
        }
    }

    private static void deleteTrainer() {
        System.out.print("Enter trainer ID to delete: ");
        int tID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        trainerManager.deleteTrainer(tID);
        System.out.println("Trainer deleted successfully.");
    }

    private static void viewTrainers() {
        List<Trainer> trainers = trainerManager.getAllTrainers();
        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }
    }

    private static void manageWorkouts() {
        boolean managing = true;

        while (managing) {
            System.out.println("\nManage Workouts:");
            System.out.println("1. Add Workout");
            System.out.println("2. Update Workout");
            System.out.println("3. Delete Workout");
            System.out.println("4. View Workouts");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addWorkout();
                    break;
                case 2:
                    updateWorkout();
                    break;
                case 3:
                    deleteWorkout();
                    break;
                case 4:
                    viewWorkouts();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addWorkout() {
        System.out.print("Enter user ID: ");
        int uID = scanner.nextInt();
        System.out.print("Enter trainer ID (optional, 0 if none): ");
        int tID = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        Date date = java.sql.Date.valueOf(dateString);

        List<Integer> eIDs = new ArrayList<>();
        while (true) {
            System.out.print("Enter exercise ID to add (0 to stop): ");
            int eID = scanner.nextInt();
            if (eID == 0) break;
            eIDs.add(eID);
        }
        scanner.nextLine();  // Consume newline

        workoutManager.addWorkout(uID, tID, date, eIDs);
        System.out.println("Workout added successfully.");
    }

    private static void updateWorkout() {
        System.out.print("Enter workout ID to update: ");
        int wID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Workout workout = workoutManager.getWorkout(wID);
        if (workout != null) {
            System.out.print("Enter new user ID (current: " + workout.getuID() + "): ");
            int uID = scanner.nextInt();
            System.out.print("Enter new trainer ID (current: " + workout.gettID() + "): ");
            int tID = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter new date (current: " + workout.getDate() + ") (YYYY-MM-DD): ");
            String dateString = scanner.nextLine();
            Date date = java.sql.Date.valueOf(dateString);

            List<Integer> eIDs = new ArrayList<>();
            while (true) {
                System.out.print("Enter new exercise ID to add (0 to stop): ");
                int eID = scanner.nextInt();
                if (eID == 0) break;
                eIDs.add(eID);
            }
            scanner.nextLine();  // Consume newline

            workoutManager.updateWorkout(wID, uID, tID, date, eIDs);
            System.out.println("Workout updated successfully.");
        } else {
            System.out.println("Workout not found.");
        }
    }

    private static void deleteWorkout() {
        System.out.print("Enter workout ID to delete: ");
        int wID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        workoutManager.deleteWorkout(wID);
        System.out.println("Workout deleted successfully.");
    }

    private static void viewWorkouts() {
        List<Workout> workouts = workoutManager.getAllWorkouts();
        for (Workout workout : workouts) {
            System.out.println(workout);
        }
    }

    private static void generateRandomWorkouts() {
        System.out.print("Enter user ID: ");
        int uID = scanner.nextInt();
        System.out.print("Enter trainer ID (optional, 0 if none): ");
        int tID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Workout> workouts = workoutGenerator.generateRandomWorkouts(uID, tID);
        for (Workout workout : workouts) {
            workoutManager.addWorkout(workout.getuID(), workout.gettID(), workout.getDate(), workout.geteIDs());
        }
        System.out.println("Random workouts generated and added successfully.");
    }
}
