import java.io.*;
import java.net.*;

public class UDPS {

   public static void main(String args[]) throws Exception {
      DatagramSocket serverSocket = new DatagramSocket(8080);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];
      while (true) {
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         String str="",rev="";
         str = new String(receivePacket.getData());
         int len=str.length();
         for (int i=len-1;i>=0;i--)
         rev= rev + str.charAt(i);
         
         System.out.println("Received string");
         
         /*DatagramPacket receivePacket2 = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket2);
         int num2 = Integer.parseInt(new String(receivePacket2.getData()).trim());
         System.out.println("Received second number: " + num2);*/
        
         sendData = rev.getBytes();
         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
         serverSocket.send(sendPacket);
         serverSocket.close();
      }
   }
}
