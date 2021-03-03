import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/22 11:52
 */
public class HTTPClientDemo {
    public static void main(String[] args) throws IOException {
        //URL:http://www.baidu.com/s?wd=java
        String SERVER_HOST = "www.baidu.com";
        int PORT = 80;

        try(Socket socket = new Socket(SERVER_HOST,PORT)) {
            String request = "GET /s?wd=java HTTP/1.0\r\nHost: www.baidu.com\r\n\r\n";
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            Scanner scanner = new Scanner(socket.getInputStream(),"UTF-8");
            writer.printf("%s",request);
            writer.flush();

            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            socket.close();
        }
    }
}
