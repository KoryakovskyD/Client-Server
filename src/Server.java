/**
 * Created by Дмитрий on 19.06.2017.
 */
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {


        System.out.println("Запускаем сервер...");
        ServerSocket servers = new ServerSocket(4444);


        System.out.println("Ждем подключение клиента...");
        Socket serversocket= servers.accept();
        System.out.println("Клиент подключился!");



        BufferedReader in  = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
        PrintStream out = new PrintStream(serversocket.getOutputStream());

        System.out.println("Ждем сообщения от клиента...");

        String message;

        while (true) {
            message=in.readLine();
            if (message.equalsIgnoreCase("exit")) break;
            out.println("Отправляем на сервер:     " + message);
            System.out.println("Сервер принял:     " + message);
        }

        serversocket.close();
        servers.close();
    }
}
