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
import com.csis3275.model_cwu_18.Login_epe_07;

class BookingTest_cwu_18 {
	public String title = "Test Titile";

	Booking_cwu_18 bookingTest1 =  new Booking_cwu_18();
	
	Login_epe_07 login = new Login_epe_07();
	
	@BeforeEach
	void setUp() throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date startTestDate = formatter.parse("2010-05-23T09:30:00");
		Instant instant1 = Instant.ofEpochMilli(startTestDate.getTime());
		LocalTime start = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalTime();
		
		Date endTestDate = formatter.parse("2010-05-23T11:30:00");
		Instant instant2 = Instant.ofEpochMilli(startTestDate.getTime());
		LocalTime end = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalTime();
		
		//Date locTme = isoFormat.parse("2010-05-23T09:01:02");
		bookingTest1 = new Booking_cwu_18(null, null, null, 
				title, null, 100326589, "D0123");
		
		
		login = new Login_epe_07("test@test.com", "1234");
		
	}
	
//	@Test
//	public void testTitle() {
//		
//		assertEquals(title, bookingTest1.getTitle());
//	}
	
	@Test
	public void testEmail() {
		
		assertEquals("1234", login.getPassword());
	}
}
