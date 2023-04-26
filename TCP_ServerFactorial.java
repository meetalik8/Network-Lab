import java.io.*;
import java.net.*;

public class Server2 {
	public static void main(String args[]) throws IOException {
	int portNumber =8080;
	ServerSocket serverSocket = new ServerSocket(portNumber);
	System.out.println("Server started");
	try (Socket clientSocket = serverSocket.accept();
	BufferedReader in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
	PrintWriter out = new PrintWriter (clientSocket.getOutputStream(),true))
	{
	System.out.println("CLient is connected!");
	String[] number= in.readLine().split(" ");
	int res =1;
	int no = Integer.parseInt(number[0]);
	for(int i =1;i<=no;i++)
		res=res*i;
	String result = res + " "; 
	out.println(result);
	}
	catch (NumberFormatException | IOException e){
	System.out.println("Error handling the client :"+e.getMessage());
}
}
}
