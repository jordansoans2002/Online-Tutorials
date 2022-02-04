import java.util.*;
import java.io.*;

public class R_Scanner{
	public static void main(String []args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int ch=1;
		while(ch!=0){
			System.out.println("enter 1 to write to file 2 to read 0 to exit");
			ch=sc.nextInt();
			String file="",data="";
			switch(ch){
				case 1:
				{
					System.out.println("enter file to write");
					file=sc.nextLine();
					BufferedWriter out=new BufferedWriter(new FileWriter(file));
					System.out.println("enter data to be written");
					data=sc.nextLine();			
					out.write(data);
				break;
				}
				
				case 2:
				{
					System.out.println("enter file to read");
					Scanner in=new Scanner(file);
					while(in.hasNext())
						System.out.println(in.next()+" ");
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