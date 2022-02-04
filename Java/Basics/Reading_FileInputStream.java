import java.io.*;
public class Reading_FileInputStream{
	public static void main(String []args){
		try{
			FileInputStream in=new FileInputStream("text.txt");
			int ip=in.read();
			while(ip!=-1){
				System.out.print((char)ip);
				ip=in.read();
			}
		}catch(Exception e){System.out.println(e);}
	}
}