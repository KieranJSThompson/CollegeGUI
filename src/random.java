/**
 * Created by kieran on 09/03/16.
 */
import java.util.Random;
public class random {

    public static void main(String [] args){
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            int a = r.nextInt(200);
            System.out.println(a);
        }
    }
}
