import java.io.*;
import java.net.*;

public class Client2 {
public static void main (String args[]) throws IOException {
	String serverHostname = "localhost";
	int serverPort = 8080;
	Socket socket = new Socket(serverHostname, serverPort);
	BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
	PrintWriter out= new PrintWriter(socket.getOutputStream(),true);
	BufferedReader stdIn = new BufferedReader (new InputStreamReader (System.in));
	
	String num1;
	System.out.println("Enter the number:");
	num1 = stdIn.readLine();
	out.println(num1);
	String response = in.readLine();
	System.out.println("Results " + response);
	}
	}
