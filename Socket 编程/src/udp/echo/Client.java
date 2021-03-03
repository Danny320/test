package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/21 15:35
 */
public class Client {
    public static  final String SERVER_HOST = "39.99.235.95";
    public static void main(String[] args) {
        Scanner stdinScanner = new Scanner(System.in);
        try (DatagramSocket clientSocket = new DatagramSocket()){
            while(stdinScanner.hasNextLine()) {
                String request = stdinScanner.nextLine();
                if(request.equalsIgnoreCase("quit")) {
                    break;
                }

                byte[] sendBuffer = request.getBytes("UTF-8");
                DatagramPacket  sendPacket = new DatagramPacket(sendBuffer,
                        sendBuffer.length,
                        InetAddress.getByName(SERVER_HOST),
                        Server.PORT);
                clientSocket.send(sendPacket);

                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,0,
                        receiveBuffer.length);
                clientSocket.receive(receivePacket);
                String response = new String(receiveBuffer,0,receiveBuffer.length,"UTF-8");
                System.out.println(response);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
