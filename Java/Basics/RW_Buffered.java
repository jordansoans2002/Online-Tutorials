import java.util.*;
import java.io.*;

public class RW_Buffered{
	public static void main(String []args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int ch=1;
		while(ch!=0){
			System.out.println("enter 1 to write to file 2 to read 0 to exit");
			ch=sc.nextInt();
			String file="a.txt",data="";
			switch(ch){
				case 1:
				{
					System.out.println("enter file to write");
					sc.next();
					file=sc.nextLine();
					BufferedWriter out=new BufferedWriter(new FileWriter(file));
					System.out.println("enter data to be written");
					sc.next();
					data=sc.nextLine();			
					out.write(data);
				break;
				}
				
				case 2:
				{
					System.out.println("enter file to read");
					file=sc.nextLine();
					BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					while((data=in.readLine())!="")
						System.out.println(data);
					System.out.println("end of file");
					break;
				}
				
				case 0:
				break;
		
				default:
					System.out.println("invalid input");
			}
		}
	}
}