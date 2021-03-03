package tcp.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/21 18:19
 */
public class Client {
    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = Server.PORT;

    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket(SERVER_HOST,SERVER_PORT)) {
             SocketAddress localSocketAddress = socket.getLocalSocketAddress();//本地地址
             int localPort = socket.getLocalPort();//本地端口
             SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();//远端地址
             int port = socket.getPort();//远端端口


            String request = "hello world";
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(inputStream,"UTF-8");
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            writer.printf("%s\r\n",request);//发送请求
            writer.flush();
            String response = scanner.nextLine();//接受响应
            System.out.println(response);


        }
    }
}
