import java.io.*;
import java.net.*;

public class Client3 {
public static void main (String args[]) throws IOException {
	String serverHostname = "localhost";
	int serverPort = 8080;
	Socket socket = new Socket(serverHostname, serverPort);
	BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
	PrintWriter out= new PrintWriter(socket.getOutputStream(),true);
	BufferedReader stdIn = new BufferedReader (new InputStreamReader (System.in));
	
	String str;
	System.out.println("Enter a string:");
	str = stdIn.readLine();
	out.println(str);
	String response = in.readLine();
	System.out.println(response);
	}
	}
