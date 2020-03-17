import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    ReaderThread
    @author: Vitor Camargo
    @description: Project to use a thread to read phrases from a file.
*/

public class ReaderThread extends Thread {
    @Override
    public void run() {
        while(true) {
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