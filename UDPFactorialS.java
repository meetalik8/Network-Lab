import java.io.*;
import java.net.*;

public class UDPFactorialS {

   public static void main(String args[]) throws Exception {
      DatagramSocket serverSocket = new DatagramSocket(8080);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];
      while (true) {
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         int num = Integer.parseInt(new String(receivePacket.getData()).trim());
         System.out.println("Received string");
         int rev = 1;
         for (int i=1;i<=num;i++)
         rev= rev *i;
         String result= Integer.toString(rev);
         sendData = result.getBytes();
         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
         serverSocket.send(sendPacket);
         serverSocket.close();
      }
   }
}
