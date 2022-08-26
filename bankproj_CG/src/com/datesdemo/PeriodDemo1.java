package com.datesdemo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo1 {
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.of(2022, Month.JANUARY, 10);
		
		/*
		 * Computing Difference between Dates using period
		 */
		System.out.println("----using period-----");
		int days = Period.between(ld2, ld1).getDays();
		int months = Period.between(ld2, ld1).getMonths();
		System.out.println(days);
		System.out.println(months);
		
		/*
		 * Compute Difference using ChronoUnit
		 */
		System.out.println("----using ChronoUnit----");
		long d = ChronoUnit.DAYS.between(ld2, ld1);
		long m =ChronoUnit.MONTHS.between(ld2, ld1);
		System.out.println(d);
		System.out.println(m);
		
		/*
		 * Computing Difference between 2 Times
		 */
		
		System.out.println("---Computing Difference between 2 Times---");
		LocalTime curt = LocalTime.now();
		LocalTime transt = LocalTime.of(10, 30);
		
		Duration duration = Duration.between(transt, curt);
		
		System.out.println(duration.toMinutes());
		System.out.println(duration.toHours());
		
		/*
		 * Computing time difference using ChronoUnit
		 */
		
		System.out.println("---Computing time difference using ChronoUnit---");
		
		long m1 = ChronoUnit.MINUTES.between(transt, curt);
		long h1 = ChronoUnit.HOURS.between(transt, curt);
		
		System.out.println(m1);
		System.out.println(h1);
		
	}
}
