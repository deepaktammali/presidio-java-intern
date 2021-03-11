package day4;

import java.time.YearMonth;

final class DaysInMonthQ21 {
	
	private int getDaysInMonth(int month,int year) {
		YearMonth yearMonth = YearMonth.of(year, month);
		return yearMonth.lengthOfMonth();
	}
	
	public static void main(String[] args) {
		DaysInMonthQ21 daysInMonth = new DaysInMonthQ21();
		int month = 6;
		int year = 1994;
		
		System.out.println("Number of days in month "+month+" year "+year+" are "+daysInMonth.getDaysInMonth(month, year));
	}
}
