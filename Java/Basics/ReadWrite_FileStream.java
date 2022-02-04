import java.io.*;

public class ReadWrite_FileStream{
	public static void main(String []args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch;
		do{
			System.out.println("enter 1 to write to file and 2 to read file 0 to exit");
			ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:
				{
					try{
						System.out.println("enter file to write to");
						String fileName=br.readLine();
						System.out.println("Enter input to file");
						String input=br.readLine();
						byte ip[]=input.getBytes();
						FileOutputStream out=new FileOutputStream(fileName);
						out.write(ip);
						System.out.println();
						out.close();
					}catch(Exception e){System.out.println(e);}
					break;
				}
				
				case 2:
				{
					try{
						System.out.println("Enter file to be read");
						String fileName=br.readLine();
						FileInputStream in=new FileInputStream(fileName);
						int ip=in.read();
						while(ip!=-1){
							System.out.print((char)ip);
							ip=in.read();
						}
						System.out.println();
						in.close();
					}catch(Exception e){;}
					break;
				}
	
				case 0:
				break;
			
				default:
					System.out.println("invalid input");
			}
		}while(ch!=0);
	}
}