import java.io.*;
import java.net.*;

public class ServerU {

   public static void main(String args[]) throws Exception {
      DatagramSocket serverSocket = new DatagramSocket(8080);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];
      while (true) {
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         int num1 = Integer.parseInt(new String(receivePacket.getData()).trim());
         System.out.println("Received first number: " + num1);
         DatagramPacket receivePacket2 = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket2);
         int num2 = Integer.parseInt(new String(receivePacket2.getData()).trim());
         System.out.println("Received second number: " + num2);
         int sum = num1 + num2;
         String result = Integer.toString(sum);
         sendData = result.getBytes();
         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
         serverSocket.send(sendPacket);
      }
   }
}
