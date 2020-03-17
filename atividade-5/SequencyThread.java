import java.util.Random;
import java.util.Scanner;

/*
    SequencyThread
    @author: Vitor Camargo
    @description: Project to use a thread to sum values.
*/

public class SequencyThread extends Thread {
    public static int sum = 0;

    @Override
    public void run() {
        Random random = new Random();

        int rand = 0;
        while (rand <= 1) {
            rand = random.nextInt(10);
        }

        Scanner aux = new Scanner(System.in);
        
        System.out.println("Serão informados " + rand + " números");
        for (int i = 0; i < rand; i++) {
            System.out.print("> " + (i+1) + "º valor inteiro: ");
            int value = aux.nextInt();
            sum = sum + value;
        }

        aux.close();
    }

    public static void main(String args[]) {
        SequencyThread sequency = new SequencyThread();
        sequency.start();

        try {
            sequency.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Acabei aqui, a soma deu: " + sum);
    }
}