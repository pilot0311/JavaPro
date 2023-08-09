package Programmer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class testCalendar {

	public static void main(String[] args) {
		int year = 2023;
		int month = 8;
		
		Calendar c = new GregorianCalendar(year,month-1,1);
		Calendar t = Calendar.getInstance();
		//t.set
		System.out.println(c.getTime());
		System.out.println(t.getTime());
		int n =	c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_MONTH, -n+1);
		//System.out.println(c.getTime());
		
		for (int i = 1; i <= 42; i++) {
			System.out.printf(c.equals(t)?"%d\t":"(%d)\t",c.get(Calendar.DAY_OF_MONTH));
			c.add(Calendar.DAY_OF_MONTH, 1);
			
			if(i%7==0)System.out.println();
		} // for
		
	} // main
	
}
