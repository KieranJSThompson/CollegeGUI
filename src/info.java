import java.sql.Time;

/**
 * Created by kieran on 08/03/16.
 */
public class info {

    private String title;
    private int releaseYear;
    private String length;

    public info(String title, int releaseYear, String length){
        this.title = title;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    public String toString(){
        return title + " -- " + releaseYear +  " -- " + length;
    }
}
