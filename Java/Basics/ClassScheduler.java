import java.time.*;
import java.util.concurrent.*;
import java.net.*;
import java.awt.Desktop;

public class ClassScheduler{
	
	static ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
	static LocalDateTime t;
	static 
	static int hr,min;

	public static void main(String []args){
		try{
			scheduler.scheduleAtFixedRate(ClassScheduler::run,0,60,TimeUnit.SECONDS);
		}catch(Exception e){
			System.out.println("please open manually");
		}
	}

	public static void run(){
		t=LocalDateTime.now();
		day=t.getDayOfWeek().toString();
		hr=t.getHour();
		min=t.getMinute();

		
		if(hr>=12&&hr<=15){
			try{
				callUrl();
			}catch(Exception e){
				System.out.println("class over");
			}
		}else{
			System.out.println("out of time bound");
			System.exit(0);
		}
	}

	static void callUrl()throws Exception{
		
		switch(day){
			case "MONDAY":
				if(hr==12)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==13)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==14)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==15){
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
					System.exit(0);
				}
			break;

			case "TUESDAY":
				if(hr==12)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==13)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==14)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==15){
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
					System.exit(0);
				}
			break;

			case "WEDNESDAY":
				if(hr==12)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==13)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==14)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
				if(hr==15){
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+""));
					System.exit(0);
				}
			break;

			case "THURSDAY":
				if(hr==12)
					if(min==30)
						Desktop.getDesktop().browse(new URI(url+"eip-oeam-epk"));
				if(hr==13)
					if(min==35)
						Desktop.getDesktop().browse(new URI(url+"ihd-btwn-sak"));
				if(hr==14){
					if(min==05)
						Desktop.getDesktop().browse(new URI(url+"abb-auas-hxh"));
					if(min==34)
						Desktop.getDesktop().browse(new URI(url+"mns-nptt-fki"));
				}if(hr==15){
					if(min==04)
						Desktop.getDesktop().browse(new URI(url+"yyy-xoau-oao"));
					System.exit(0);
				}

			break;

			case "FRIDAY":
				if(hr==12)
					if(min==29)
						Desktop.getDesktop().browse(new URI(url+"pcs-ggyz-ctp"));
				if(hr==13)
					if(min==00)
						Desktop.getDesktop().browse(new URI(url+"fwm-ywzi-sny"));
				if(hr==14){
					if(min==04)
						Desktop.getDesktop().browse(new URI(url+"uui-izhs-vga"));
					if(min==34)
						Desktop.getDesktop().browse(new URI(url+"wcp-xvpw-yxo"));

				}if(hr==15){
					if(min==00)
						Desktop.getDesktop().browse(new URI(url+"tak-vrhh-iid"));
					System.exit(0);
				}

	
			break;
	
			case"SATURDAY":
			case"SUNDAY":
			default:
				System.exit(0);
		}
				
	}
}