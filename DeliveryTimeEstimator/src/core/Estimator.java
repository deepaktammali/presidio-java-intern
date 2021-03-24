package core;

import java.time.*;

public class Estimator {

/**
 * @param deliveryInitiatedDateTime The time and date at which the product delivery started
 * @param distanceToCustomer The distance between customer and delivery service (km)
 * @param transitSpeed 	The speed at which the transit takes place (km/hr)
 * @param workShiftStartTime The time at which work shift starts
 * @param workShiftEndTime The time at which work shift ends
 * @return LocalDateTime Estimated delivery date and time not-null
 */
	
	public static LocalDateTime estimateDeliveryDate(LocalDateTime deliveryInitiatedDateTime,double distanceToCustomer,double transitSpeed,LocalTime workShiftStartTime,LocalTime workShiftEndTime) {
		double remainingTransitTime = (double)(distanceToCustomer/transitSpeed)*60*60; //in seconds
		
		LocalDateTime currentDateTime = deliveryInitiatedDateTime;
		
		// The product has not yet reached customer.
		while(remainingTransitTime!=0) {
			
			boolean productInTransitNow = (currentDateTime.toLocalTime().compareTo(workShiftEndTime)<0) && (currentDateTime.toLocalTime().compareTo(workShiftStartTime)>=0);
			boolean transitYetToStartToday = (currentDateTime.toLocalTime().compareTo(workShiftStartTime)<0);
			
			if(productInTransitNow||transitYetToStartToday) {
				Duration remainingTransitDuration;
				if(transitYetToStartToday) { //transit will start once working hours commence
					remainingTransitDuration = Duration.between(workShiftStartTime,workShiftEndTime); //can travel whole working hours
				}
				else { //transit started current day
					remainingTransitDuration = Duration.between(currentDateTime.toLocalTime(),workShiftEndTime);
				}
				
			
				if(remainingTransitTime>remainingTransitDuration.getSeconds()) {
					// should travel whole shift current day
					remainingTransitTime = remainingTransitTime - remainingTransitDuration.toSeconds();
					currentDateTime = LocalDateTime.of(currentDateTime.toLocalDate(), workShiftEndTime);
				}
				else {
					//can reach destination before work shift completes current day
					currentDateTime = LocalDateTime.of(currentDateTime.toLocalDate(),currentDateTime.toLocalTime().plusSeconds((long) remainingTransitTime));
					remainingTransitTime = 0;
					
				}
				
			}
			
			// end of the shift check whether next day is holiday
			
			else {
//				see if next day is a holiday
				
//				change current time to start of the working hours the next day
				currentDateTime = LocalDateTime.of(currentDateTime.toLocalDate(), workShiftStartTime);
				
				LocalDate nextDay;
				boolean isHoliday;
				
//				change to nextDay until 
				do {
					isHoliday=false;
					currentDateTime = currentDateTime.plusDays(1);
					nextDay = currentDateTime.toLocalDate();
					
//					If the day is sunday i.e. holiday continue
					if(nextDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
						isHoliday=true;
						continue;
					}
					
//					If the day is holiday
					for(Holiday holiday:Holiday.values()) {
						isHoliday = holiday.compare(nextDay);
						if(isHoliday) {
							break;
						}
					}
					
				}while(isHoliday);
			}
			
		}
		
		// transit complete
		return currentDateTime;
		
	}
}
