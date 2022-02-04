import java.awt.Desktop;
import java.net.*;

public class openUrl{
	
	public static void main(String []args)throws Exception{
		String url="https://meet.google.com/?hs=197&pli=1&authuser=0";
		Desktop.getDesktop().browse(new URI(url));
	}
}