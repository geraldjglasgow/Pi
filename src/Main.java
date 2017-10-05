import java.lang.Thread;
public class Main {
    // generate points.
    // calculate if in circle or square
    // store in total and if in circle
    // main is updating pi while threads run

    public static void main(String[] args) throws InterruptedException{
        int processors = Runtime.getRuntime().availableProcessors();
        Thread[] thread = new Thread[processors];
        for(int i=0;i<processors;i++){
            thread[i] = new Thread(new Worker());
            thread[i].start();
        }
        boolean t = true;
        while (t){
            Thread.sleep(1000);
            System.out.println(4.0*(Worker.circle/Worker.total));
        }
    }
}
