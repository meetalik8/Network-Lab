import java.net.*;
import java.io.*;

public class UDPServer2{

public static void main(String[] args) throws Exception {
	DatagramSocket server = new DatagramSocket(8080);
	byte[] receiveData = new byte[1024];
	byte[] sendData=new byte[1024];
	while(true){
	DatagramPacket receivePacket = new DatagramPacket (receiveData,receiveData.length);
	server.receive(receivePacket);
	int num1 = Integer.parseInt( new String (receivePacket.getData()).trim());
	System.out.println("Received first number: " + num1);
         int sum = 1;
         for(int i =1; i<=num1;i++)
         { sum = sum*i;         
         }
         String result = Integer.toString(sum);
         sendData= result.getBytes();
         InetAddress IPAddress = receivePacket.getAddress();
         //int port = receivePacket.getPort();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6000);
         server.send(sendPacket);
        }
       } 
	}
