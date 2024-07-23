public class Exercise
{
    private int eID;
    private String group;
    private String name;
    private String description;

    public Exercise(int eID, String group, String name, String description) {
        this.eID = eID;
        this.group = group;
        this.name = name;
        this.description = description;
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "eID=" + eID +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
