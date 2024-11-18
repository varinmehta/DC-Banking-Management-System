import java.io.*;
import java.net.*;

public class Server {
    public static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ClientHandler(socket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);
                writer.println("Processed: " + request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
