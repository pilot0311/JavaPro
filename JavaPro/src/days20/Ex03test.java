package days20;

import java.util.Date;

public class Ex03test {

	public static void main(String[] args) {
		Date d = new Date(2023-1900,7-1,13,9, 0);
		Date today = new Date();
		long ms = d.getTime();
		long todayMs = today.getTime();
		long day = (todayMs-ms)/(1000*60*60*24);  //(초*분*시간*하루)
		System.out.println(day+"일 지났음");
		
	} // main
}
