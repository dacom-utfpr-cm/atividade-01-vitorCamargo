import java.util.Random;

/*
    MonitorThread
    @author: Vitor Camargo
    @description: Project to use a thread as a monitor to verify if threads are still alive.
*/

class ChildThread extends Thread {
    Random random = new Random();

    @Override
    public void run() {
        while(true) {
            int rand = 0;
            while (rand == 0) {
                rand = random.nextInt(10);
            }

            Thread.currentThread();
            try {
                System.out.println("[CHILD] Vou parar aqui por " + rand + " segundos");
                Thread.sleep(rand * 1000);
            } catch (InterruptedException e) {
                System.out.println("[CHILD] Fui interrompido");
                break;
            }
        }
    }
}

public class MonitorThread {
    public static void main(String args[]) {
        Random random = new Random();

        int aux = 0;
        while (aux == 0) {
            aux = random.nextInt(10);
        }

        final int rand = aux;

        System.out.println("[MONITOR] Serão " + rand + " threads");
        final ChildThread[] threads = new ChildThread[rand];

        for (int i = 0; i < rand; i++) {
            threads[i] = new ChildThread();
            threads[i].start();
        }

        new Thread(() -> {
            int[] verifiers = new int[rand];
            for (int i = 0; i < rand; i++) {
                verifiers[i] = 1;
            }

            while(true) {
                for (int i = 0; i < rand; i++) {
                    if (!threads[i].isAlive() && verifiers[i] == 1) {
                        System.out.println("[MONITOR] A thread " + i + " foi interrompida");
                        verifiers[i] = 0;
                    }
                }
            }
        }).start();

        for (int i = 0; i < rand; i++) {
            int randInterruption = 0;
            while (randInterruption <= 5) {
                randInterruption = random.nextInt(10);
            }

            try {
                Thread.sleep(randInterruption * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            threads[i].interrupt();
        }
    }
}