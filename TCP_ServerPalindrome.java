import java.io.*;
import java.net.*;

public class Server3 {
	public static void main(String args[]) throws IOException {
	int portNumber =8080;
	ServerSocket serverSocket = new ServerSocket(portNumber);
	System.out.println("Server started");
	try (Socket clientSocket = serverSocket.accept();
	BufferedReader in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
	PrintWriter out = new PrintWriter (clientSocket.getOutputStream(),true))
	{
	System.out.println("CLient is connected!");
	String init="";
	init= in.readLine();
	String rev= "";
	int len =init.length();
	for (int i = len -1;i>=0;i--){
		rev = rev + init.charAt(i);
	}
	if (init.equals(rev)){
		String yes= "Yes its a palindrome";
		out.println(yes);
	}
	else {
		String no = "No its not a palindrome";
		out.println(no);
	}
	}
	catch (Exception e){
	System.out.println("Error handling the client :"+e.getMessage());
}
}
}
