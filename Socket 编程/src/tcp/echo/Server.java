package tcp.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/21 17:52
 */
public class Server {
    public static final int PORT = 9260;

    public static void main(String[] args) throws IOException{

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true) {
                Socket  socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Scanner scanner = new Scanner(inputStream,"UTF-8");
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream,"UTF-8") {
                });

                String request = scanner.nextLine();//接受请求
                String response = echoService(request);
                writer.printf("%s\r\n",response);//发送响应
                writer.flush();
                socket.close();
            }
        }
    }

    private static String echoService(String request) {
        return request;
    }
}
