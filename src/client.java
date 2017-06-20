/**
 * Created by Дмитрий on 19.06.2017.
 */
import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {


        System.out.println("Запуск клиента...");
        System.out.println("Подключаемся к серверу...");



        Socket clientsocket = new Socket("localhost",4444);


        BufferedReader in  = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
        PrintStream out = new PrintStream(clientsocket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message;

        while (true) {
            message=reader.readLine();
            out.println(message);
            System.out.println(in.readLine());
            if (message.equalsIgnoreCase("exit")) break;
        }


        clientsocket.close();
    }
}