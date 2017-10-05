import java.util.Random;
import java.util.concurrent.Semaphore;
public class Worker implements Runnable {

    static double circle=0, total=0;
    static Semaphore semaphore = new Semaphore(1);


    public void run() {
        boolean t = true;
        Random rnd = new Random();
        while (t){
            if(Math.pow(rnd.nextDouble(),2.0)+Math.pow(rnd.nextDouble(), 2.0) < 1.0){
                try {
                    semaphore.acquire();
                    circle++;
                    total++;
                    semaphore.release();
                } catch (InterruptedException e){

                }
            } else {
                try {
                    semaphore.acquire();
                    total++;
                    semaphore.release();
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
