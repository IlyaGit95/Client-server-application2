import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {

    public static void main(String[] args) {
        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            out.println("Write your name");
            String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            out.println("Are you child? (yes/no)");
            String isChild = in.readLine();
            if (isChild.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else if (isChild.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
