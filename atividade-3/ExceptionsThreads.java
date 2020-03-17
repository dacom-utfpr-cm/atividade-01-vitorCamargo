import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
    ExceptionThread
    @author: Vitor Camargo
    @description: Project to use thread to send an interruption to 2 threads
*/

class SleepThread extends Thread {
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
            System.out.println("Fui interrompido");
        }
    }
}

class ReaderThread extends Thread {
    @Override
    public void run() {
        while (true) {
            Thread.currentThread();
            try {
                File file = new File("./file-example.txt");
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                String string;

                while ((string = buffer.readLine()) != null) {
                    System.out.println(string);
                }

                buffer.close();

                System.out.println("Vou esperar aqui por 10 segundos");
                Thread.sleep(10 * 1000);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                break;
            } catch (InterruptedException e) {
                System.out.println("Fui interrompido");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

public class ExceptionsThreads {
    public static void main(String args[]) {
        System.out.println("----- READER THREAD");
        ReaderThread reader = new ReaderThread();
        reader.start();
        reader.interrupt();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----- SLEEP THREAD");
        for (int i = 0; i < 3; i++) {
            SleepThread sleeper = new SleepThread();
            sleeper.start();
            sleeper.interrupt();
        }

    }
}