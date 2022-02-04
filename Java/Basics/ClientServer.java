import java.io.*;
import java.net.*;

public class ClientServer{
	public static void main(String []args)throws IOException{
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//System.out.println("enter port no");
			ServerSocket server=new ServerSocket(8422);
			Socket client=server.accept();
			BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);

			String s;
			while((s=in.readLine())!=null){
				System.out.println(s);
				out.println(s);
			}
		}
		
		catch(Exception e){
			System.out.println("end of program");
		}
	}
}