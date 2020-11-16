package com.csis3275.controller_cwu_18;

import java.util.Random;

import com.csis3275.model_cwu_18.User_sho_38;

public class IdGenerator_cwu_18 {

	public static int generateUserId(User_sho_38 user) {

		int userId = 0;
		if (user.getUser_type() == 1) {
			userId = 100000000 + getRandomBookingID();

		} else if (user.getUser_type() == 2) {
			userId = 200000000 + getRandomBookingID();

		}
		return userId;

	}
	
	// Random Number Generator
		public static int getRandomBookingID() {
			// It will generate 6 digit random Number.
			// from 0 to 999999
			Random rand = new Random();
	        int result= rand.nextInt(1000000);
	        return result;
			
			
		}
}
