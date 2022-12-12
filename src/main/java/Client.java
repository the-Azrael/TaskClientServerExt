import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private Socket clientSocket;
    private String host;
    private int port;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Клиент начал работу!");
        try {
            setName("ClientThread");
            clientSocket = new Socket(host, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String req = in.readLine();
                if (req.equals(Main.REQ_DEFAULT)) {
                    System.out.println("Введите команду:");
                    String cmd = scanner.nextLine();
                    out.println(cmd);
                    if (cmd.equals(Main.RESP_CMD_EXIT)) {
                        break;
                    }
                } else {
                    System.out.println(req);
                    String par = scanner.nextLine();
                    out.println(par);
                }
            }
            clientSocket.close();
            System.out.println("Клиент завершил работу!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
