package days20;

import java.util.Date;

public class Ex02test {

	public static void main(String[] args) {
		int year = 2023;
		int month = 8;


		int dayOfWeek = getDayOfWeek(year, month, 1);
		int lastDay = getLastDay(year, month);


		Date d = new Date(year - 1900, month - 1, 1); // 2023.8.1

		int date = d.getDate() - dayOfWeek;
		d.setDate(date);
		
		System.out.printf("\t\t%d.%d\n",year,month);
		for (int i = 0; i < 7; i++) {
			System.out.printf("%s\t", "일월화수목금토".charAt(i));
		} // for
		System.out.println();
		for (int i = 1; i <= 35; i++) {


			int m = d.getMonth() + 1;

			// d.getDate() );
			if (m != month) {
				System.out.printf("\t");
			} else {
				System.out.printf("%2d\t", d.getDate());
			}
			// 년, 월, 일

			if (i % 7 == 0) {
				System.out.println();
			}
			date = d.getDate() + 1;
			d.setDate(date);

		} // for

	} // main

	private static int getLastDay(int year, int month) {
		Date d = new Date(year - 1900, month, 1);
		int date = d.getDate() - 1;
		d.setDate(date);
		return d.getDate();
	}

	private static int getDayOfWeek(int year, int month, int date) {
		Date d = new Date(year - 1900, month - 1, date);
		return d.getDay(); // 0(일)~6(토)
	} // main
}
