import java.io.IOException;

public class Main {
    //запросы
    public static final String REQ_DEFAULT = ">>";
    public static final String REQ_NAME = "Ваше имя: ";
    public static final String REQ_YEAR = "Год рождения: ";
    public static final String REQ_COUNTRY = "Страна ";
    public static final String REQ_CITY = "Город: ";
    public static final String REQ_FILM = "Фильм: ";
    public static final String REQ_BOOK = "Книга: ";
    //команды
    public static final String RESP_CMD_NEXT_USER = "EDIT";
    public static final String RESP_CMD_SHOW_USER = "SHOW";
    public static final String RESP_CMD_EXIT = "EXIT";

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(50000);
        Client client = new Client("netology.homework", 50000);
        server.start();
        client.start();
        client.join();
    }
}
