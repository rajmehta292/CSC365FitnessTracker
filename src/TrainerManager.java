import java.util.ArrayList;
import java.util.List;

public class TrainerManager
{
    private List<Trainer> trainers = new ArrayList<>();
    private int nextId = 1;

    public void addTrainer(String name, String specialty, int experience) {
        trainers.add(new Trainer(nextId++, name, specialty, experience));
    }

    public Trainer getTrainer(int tID) {
        return trainers.stream()
                .filter(trainer -> trainer.gettID() == tID)
                .findFirst()
                .orElse(null);
    }

    public List<Trainer> getAllTrainers() {
        return trainers;
    }

    public void updateTrainer(int tID, String name, String specialty, int experience) {
        Trainer trainer = getTrainer(tID);
        if (trainer != null) {
            trainer.setName(name);
            trainer.setSpecialty(specialty);
            trainer.setExperience(experience);
        }
    }

    public void deleteTrainer(int tID) {
        trainers.removeIf(trainer -> trainer.gettID() == tID);
    }
}
