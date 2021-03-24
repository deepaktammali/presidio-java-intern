package test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

import core.Estimator;
import core.Holiday;

public class Main {
	
	public static void main(String[] args) {
		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(17,0);
		System.out.println(Estimator.estimateDeliveryDate(LocalDateTime.now(), 10000, 50,startTime, endTime));
	}
	
}
