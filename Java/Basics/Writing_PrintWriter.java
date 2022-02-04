//accepts input and writes it to the text file
import java.io.*;

public class Writing_PrintWriter{
	public static void main(String []args)throws IOException{
		try{
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			PrintStream out=new PrintStream("text.txt");
			System.out.println("Please enter the text");
			String ip=in.readLine();
			while(ip!=""){
				out.println(ip);
				ip=in.readLine();
			}
			in.close();out.close();
		}
		catch(Exception e){System.out.println("error"+e);}
	}
}

/*
C:\Users\Dell\Desktop\Jordan\Java>java Typewriter
Please enter the text
Hey Im Jordan
How are you
Im having a good day

output(in the text file type.txt)
Hey Im Jordan
How are you
Im having a good day
*/
