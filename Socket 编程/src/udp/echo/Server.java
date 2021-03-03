package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/21 15:36
 */
public class Server {
    public static final int PORT = 8260;
    public static void main(String[] args) {
        //1.作为服务端，需要先开张
        //这里也就是创建一个socket出来
        try(DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("DEBUG:服务端已经创建");
            //2.在一个循环中，不停的接受请求
            while(true) {
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,0,receiveBuffer.length);
                serverSocket.receive(receivePacket);
                String host = receivePacket.getAddress().getHostName();
                int port = receivePacket.getPort();
                int length = receivePacket.getLength();
                String request = new String(receiveBuffer,0,length,"UTF-8");
                String response = service(host,port,request);
                byte[] sendBuffer = response.getBytes("UTF-8");
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,receivePacket.getAddress(),port);
                serverSocket.send(sendPacket);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String service(String host, int port, String request) {
        return request;
    }
}
