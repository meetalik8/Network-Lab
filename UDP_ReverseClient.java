import java.io.*;
import java.util.Scanner;
import java.net.*;

public class UDP{
public static void main(String args[]) throws Exception {
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      System.out.print("Enter String: ");
      String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8080);
      clientSocket.send(sendPacket);
      /*System.out.print("Enter second number: ");
      sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
      sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8080);
      clientSocket.send(sendPacket);*/
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String result = new String(receivePacket.getData());
      System.out.println("Result: " + result.trim());
      clientSocket.close();
   }
   }
