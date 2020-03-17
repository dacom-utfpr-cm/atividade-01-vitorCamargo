import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    ReaderThread
    @author: Vitor Camargo
    @description: Project to use threads to put in sleep for a random seconds
*/

public class ReaderThread extends Thread {
    @Override
    public void run() {
        while(true) {
            Thread.currentThread();
            try {
                final File file = new File("./file-example.txt");
                final BufferedReader br = new BufferedReader(new FileReader(file));
                String string;

                System.out.println("Vou esperar aqui por 10 segundos");
                Thread.sleep(10 * 1000);

                while ((string = br.readLine()) != null) {
                    System.out.println(string);
                }

                br.close();
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
                break;
            } catch (final InterruptedException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String args[]) {
        new ReaderThread().start();
    }
}