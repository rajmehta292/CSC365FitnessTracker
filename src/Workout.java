import java.util.Date;
import java.util.List;

public class Workout
{
    private int wID;
    private int uID;
    private int tID;
    private Date date;
    private List<Integer> eIDs;

    public Workout(int wID, int uID, int tID, Date date, List<Integer> eIDs) {
        this.wID = wID;
        this.uID = uID;
        this.tID = tID;
        this.date = date;
        this.eIDs = eIDs;
    }

    public int getwID() {
        return wID;
    }

    public void setwID(int wID) {
        this.wID = wID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Integer> geteIDs() {
        return eIDs;
    }

    public void seteIDs(List<Integer> eIDs) {
        this.eIDs = eIDs;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "wID=" + wID +
                ", uID=" + uID +
                ", tID=" + tID +
                ", date=" + date +
                ", eIDs=" + eIDs +
                '}';
    }
}
