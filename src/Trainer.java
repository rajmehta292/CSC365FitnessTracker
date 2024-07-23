public class Trainer
{
    private int tID;
    private String name;
    private String specialty;
    private int experience;

    public Trainer(int tID, String name, String specialty, int experience) {
        this.tID = tID;
        this.name = name;
        this.specialty = specialty;
        this.experience = experience;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "tID=" + tID +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience +
                '}';
    }
}
