package core;

import java.time.LocalDate;
import java.time.Month;

public enum Holiday {
	NEWYEAR(2021,Month.JANUARY,1,false),
	GANDHIJAYANTHI(2021,Month.OCTOBER,2,false),
	REPUBLICDAY(2021,Month.JANUARY,26,false),
	INDEPENDENCEDAY(2021,Month.AUGUST,15,false);
	
	private LocalDate eventDate;
	private boolean yearDependent;
	
	private Holiday(int year, Month month, int date, boolean yearDependent) {
		this.eventDate = LocalDate.of(year, month, date);
		this.yearDependent = yearDependent;
	}

	public boolean compare(LocalDate dateToCompare){
		
		if(!yearDependent) {
			eventDate = LocalDate.of(dateToCompare.getYear(), eventDate.getMonth(), eventDate.getDayOfMonth());
		}
		
		return (eventDate.compareTo(dateToCompare)==0);
	}
}
