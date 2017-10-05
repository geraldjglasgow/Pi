import java.util.Random;
public class Worker implements Runnable {

    double circle=0, total=0;
    long end;
    public Worker(long n) {
    	this.end = n*60000;
    }

    public void run() {
        long start = System.currentTimeMillis();
        end += start;
        Random rnd = new Random();
        while (System.currentTimeMillis() < end){
            if(Math.pow(rnd.nextDouble(),2.0)+Math.pow(rnd.nextDouble(), 2.0) <= 1.0){
            	circle++;
            	total++;
            } else {
            	total++;
            }
        }
    }
    public double getCircle() {
    	return circle;
    }
    public double getTotal() {
    	return total;
    }
}
