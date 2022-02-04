import java.io.*;
import java.net.*;

public class UsingUrls{
	public static void main(String []args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the url");
		String u=br.readLine();
		URL url;
		//try{
			url=new URL(u);
		//}
		/*catch(MalformedURLException e){
			System.out.println("invalid url");
		}*/

		//using open stream(not much preferred)
		/*BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));
		
		while(in.readLine()!= null)
			System.out.println(in.readLine());
		in.close();*/

		//using open connection(more usage)
		URLConnection connect=url.openConnection();
		BufferedReader input=new BufferedReader(new InputStreamReader(connect.getInputStream()));

		while(input.readLine() != null)
			System.out.println(input.readLine());
		input.close();
	}
}