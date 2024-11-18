import java.io.*;
import java.net.*;

public class Client {
    public static void startClient() {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            writer.println("Hello from Client");
            System.out.println("Server Response: " + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
