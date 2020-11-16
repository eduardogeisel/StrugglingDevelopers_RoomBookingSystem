package com.csis3275.model_cwu;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.csis3275.model_cwu_18.Booking_cwu_18;

class BookingTest_cwu_18 {
	

	Booking_cwu_18 bookingTest1 = new Booking_cwu_18();


	Date startTestDate;
	Date endTestDate;
	String title = "Test Titile";
	@BeforeEach
	void setUp() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

		startTestDate = formatter.parse("2010-05-23T09:30:00");
		Instant instant1 = Instant.ofEpochMilli(startTestDate.getTime());
		LocalTime start = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalTime();

		endTestDate = formatter.parse("2010-05-23T11:30:00");
		Instant instant2 = Instant.ofEpochMilli(startTestDate.getTime());
		LocalTime end = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalTime();

		// Date locTme = isoFormat.parse("2010-05-23T09:01:02");
		bookingTest1 = new Booking_cwu_18(startTestDate, start, end, 
				title, "Test description", 100326589, "D0123");


	}

	/*
	 * Author: Travis
	 * Test for method getTitle within entity Booking_cwu_18 
	 * Test booking_id should return the input string
	 */
	@Test
	public void testTitle() {

		assertEquals(title, bookingTest1.getTitle());
	}
	
	/*
	 * Author: Travis
	 * Test for method generateId within entity Booking_cwu_18 
	 * Test booking_id should return the required length witch is a 6 digits number
	 */
	@Test
	public void testBookingIdDigits() {

		int length = String.valueOf(bookingTest1.generateId()).length();
		assertEquals(6, length);
	}
	
	/*
	 * Author: Travis
	 * Test for method getDatetime within entity Booking_cwu_18 
	 * Test dateTime should return the required date model
	 */
	@Test
	public void testDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = bookingTest1.getDateTime();
		assertEquals(startTestDate, date);
	}

	
}
