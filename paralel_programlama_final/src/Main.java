import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step-1: İki farklı veriyi sırayla alma işlemini gerçekleştiren thread'ler
        Thread firstThread = new Thread(() -> {
            // Step-2: Kullanıcı bilgilerini alıp person.txt dosyasına kaydeden işlem
            Scanner scanner = new Scanner(System.in);
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            try {
                FileWriter fileWriter = new FileWriter("person.txt");
                fileWriter.write("Username: " + username + "\n");
                fileWriter.write("Password: " + password + "\n");
                fileWriter.write("Email: " + email + "\n");
                fileWriter.close();
                System.out.println("person.txt'e bilgiler kaydedildi");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread secondThread = new Thread(() -> {
            // Step-3: Kullanıcının secretInformation'ı secret.txt dosyasına kaydeden işlem
            Scanner scanner = new Scanner(System.in);
            System.out.print("Secret Information: ");
            String secretInformation = scanner.nextLine();

            try {
                FileWriter fileWriter = new FileWriter("secret.txt");
                fileWriter.write("Secret Information: " + secretInformation + "\n");
                fileWriter.close();
                System.out.println("secret.txt'e bilgiler kaydedildi");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // İlk thread
        firstThread.start();
        try {
            firstThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // İkinci thread
        secondThread.start();
    }
}
