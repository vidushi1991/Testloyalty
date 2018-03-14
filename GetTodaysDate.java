package com.clavax.novusloyality.transactionsScripts;

import java.util.Date;

import org.testng.annotations.Test;

public class GetTodaysDate {
	
	
	public Date   getTodaysDate(){
		Date date = new Date();
		System.out.println("the current date is " +date);
		return date;
	}

}
