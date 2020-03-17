import java.util.Random;

/*
    SleepThread
    @author: Vitor Camargo
    @description: Project to use threads to put in sleep for a random seconds
*/

public class SleepThread extends Thread {
    Random random = new Random();

    @Override
    public void run() {
        int rand = 0;
        while (rand == 0) {
            rand = random.nextInt(10);
        }

        Thread.currentThread();
        try {
            System.out.println("Vou parar aqui por " + rand + " segundos");
            Thread.sleep(rand * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 3; i++) {
            new SleepThread().start();
        }
    }
}