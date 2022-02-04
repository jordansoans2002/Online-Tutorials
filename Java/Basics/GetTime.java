import java.time.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class GetTime{

	Timer timer;
	ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);


	public static void main(String []args){
		GetTime time=new GetTime();
		time.launch();
	}
	
	public void launch(){
		//setTimer();

		scheduler.scheduleAtFixedRate(GetTime::runSchedule,0,30,TimeUnit.SECONDS);
		
		scheduler.schedule(GetTime::stop,2,TimeUnit.MINUTES);
	}

	public static void runSchedule(){
		LocalDateTime t=LocalDateTime.now();
		String day=t.getDayOfWeek().toString();
		System.out.println(day);
		System.out.println(t.getHour());
		System.out.println(t.getMinute());
		System.out.println(t.getSecond());
	}
	public static void stop(){
		System.exit(0);
	}		
	
	public void setTimer(){
		timer =new Timer();
		timer.schedule(new TimeTable(),0,60*1000);
	}
}

class TimeTable extends TimerTask{
	public void run(){
		LocalDateTime t=LocalDateTime.now();
		System.out.println(t.getMinute());
		if(t.getHour()==23&&t.getMinute()==3){
			System.out.println("finished");
			cancel();
		}
	}
}