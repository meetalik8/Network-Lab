import java.net.*;
import java.io.*;

public class UDPClient2 {
public static void main(String args[]) throws Exception {
	String num1,num2,response;
	DatagramSocket socket = new DatagramSocket();
	InetAddress IPAddress = InetAddress.getByName("localhost");
	BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
	byte [] sendData = new byte[1024];
	byte [] receiveData = new byte[1024];
	System.out.println("Enter the first number: ");
	num1 = in.readLine();
	sendData = num1.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,9876);
	socket.send(sendPacket);
	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	socket.receive(receivePacket);
	response = new String(receivePacket.getData());
	System.out.println("Result is : "+response);
	socket.close();
}
}
