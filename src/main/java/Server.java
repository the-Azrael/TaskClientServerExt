import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private final ServerSocket serverSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server(int port) {
        this.setName("ServerThread");
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Сервер начал работу!");
        try {
            Socket clientConnection = serverSocket.accept();
            out = new PrintWriter(clientConnection.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
            User user = new User();
            while (true) {
                String req = Main.REQ_DEFAULT;
                out.println(req);
                String resp = in.readLine();
                if (resp.equals(Main.RESP_CMD_EXIT)) {
                    break;
                } else if (resp.equals(Main.RESP_CMD_NEXT_USER)) {
                    user.setName(getParam(Main.REQ_NAME));
                    user.setYearOfBirth(Integer.parseInt(getParam(Main.REQ_YEAR)));
                    user.setCountry(getParam(Main.REQ_COUNTRY));
                    user.setCity(getParam(Main.REQ_CITY));
                    user.setFavoriteBook(getParam(Main.REQ_FILM));
                    user.setFavoriteFilm(getParam(Main.REQ_BOOK));
                } else if(resp.equals(Main.RESP_CMD_SHOW_USER)) {
                    System.out.println(user.toString());
                }
            }
            clientConnection.close();
            System.out.println("Сервер завершил работу!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getParam(String cmd) throws IOException {
        out.println(cmd);
        return in.readLine();
    }

}
