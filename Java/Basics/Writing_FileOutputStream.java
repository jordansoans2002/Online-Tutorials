import java.io.*;
public class Writing_FileOutputStream{
	public static void main(String []args)throws IOException{
		try{
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			FileOutputStream out=new FileOutputStream("text.txt");
			System.out.println("enter characters");
			char ip=in.readLine().charAt(0);
			while(ip!='x'){
				out.write(ip);
				ip=in.readLine().charAt(0);
			}
			in.close();out.close();
		}catch(Exception e){System.out.println(e);}
	}
}