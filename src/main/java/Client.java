import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8081;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println(in.readLine());
            String name = "Ilya";
            System.out.println(name);
            out.println(name);
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            String isChild = "no";
            System.out.println(isChild);
            out.println(isChild);
            String answer = in.readLine();
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
