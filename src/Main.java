import java.lang.Thread;
public class Main {
    // generate points.
    // calculate if in circle or square
    // store in total and if in circle
    // main is updating pi while threads run

    public static void main(String[] args) throws InterruptedException{
        int processors = Runtime.getRuntime().availableProcessors();
        double total=0, circle=0;
        Thread[] thread = new Thread[processors];
        Worker[] worker = new Worker[processors];
        for(int i=0;i<processors;i++){
        	worker[i] = new Worker(30); // input time in minutes
            thread[i] = new Thread(worker[i]);
            thread[i].start();
        }
        for(int i=0;i<processors;i++) {
        	thread[i].join();
        }
        for(int i=0;i<processors;i++) {
        	circle += worker[i].getCircle();
        	total += worker[i].getTotal();
        }
        System.out.println(4.0*(circle/total));
    }
}
