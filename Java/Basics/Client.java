import java.io.*;
import java.net.*;

public class Client{
	public static void main(String []args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the ip address");
		//String hostName=br.readLine();
		//System.out.println("enter the port no");
		//int portNo=Integer.parseInt(br.readLine());
		
		try{
			Socket socket=new Socket(127.0.0.1,8422);
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s;
			while((s=br.readLine())!=null){
				//System.out.println(s);
				out.println(s);
				System.out.println("echo: "+in.readLine());
			}
			//br.close();out.close();socket.close();

		}
		
		catch(Exception e){
			System.out.println(e);
		}
	}
}