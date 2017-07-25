package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	/**
	* Test the getApptRange and getNextApptOccurrence methods
	* adapted from Canvas forum post by Dr. Ali Aburas
	*/	 
	 @Test
	 public void test01()  throws Throwable  {
		 TimeTable t = new TimeTable();


		 //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type 
		//		GregorianCalendar today = new GregorianCalendar(2, 3, 4);
			//get todays date
		//get current date
		Calendar curCal = Calendar.getInstance();
		int curMonth = curCal.get(Calendar.MONTH)+1;
		int curYear = curCal.get(Calendar.YEAR);
		int curDay = curCal.get(Calendar.DAY_OF_MONTH);

		//create the same appt, recurring differently
        Appt appt = new Appt(10, 10, curDay ,curMonth, curYear, "a", "b");
		Appt appt2 = new Appt(10, 10, curDay, curMonth, curYear, "a", "b");
		Appt appt3 = new Appt(10, 10, curDay, curMonth, curYear, "a", "b");
		//create same appt, recurring differently (this will actually occur multiple times
		Appt appt4 = new Appt(10, 10, curDay ,curMonth, 2001, "a", "b");
		Appt appt5 = new Appt(10, 10, curDay ,curMonth, 2001, "a", "b");
		Appt appt6 = new Appt(10, 10, curDay ,curMonth, 2001, "a", "b");
        /** Collection of all of the appointments for the calendar day */	
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
		appts.add(appt2);
		appts.add(appt3);
		appts.add(appt4);
		appts.add(appt5);
		appts.add(appt6);

        //Change the  default recurring information in the object appt 
		//using setRecurrence method in the Appt class 
        int[] recurringDays =  new int[0];
		int[] recurring2 = {2};
       appt.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 1);
	   appt2.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 0, 1);
	   appt3.setRecurrence(recurringDays, Appt.RECUR_BY_YEARLY, 0, 1);
	   appt4.setRecurrence(recurring2, Appt.RECUR_BY_MONTHLY, 0, 6);
	   appt5.setRecurrence(recurring2, Appt.RECUR_BY_WEEKLY, 0, 7);
	   appt6.setRecurrence(recurring2, Appt.RECUR_BY_YEARLY, 0, 9);
	   
		//get a list of appointments for one day that are occurred between today and tomorrow!
		
        GregorianCalendar firstDay = new GregorianCalendar(2000, 1, 1);		//jan 1, 2000
		GregorianCalendar lastDay = new GregorianCalendar(curYear,curMonth,curDay);
		
       try {
    	  // Retrieves a range of appointments between two dates (i.e., today and tomorrow).
           t.getApptRange(appts, firstDay, lastDay);
       }
       catch( NullPointerException e) {}  

	 }
	 @Test
	  public void test02()  throws Throwable  {
		  
		TimeTable t = new TimeTable();
		  
		//create and add appt
		Appt appt = new Appt(10,10,10,10,1995,"a","b");
		LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
		//create first and last day
		GregorianCalendar firstDay = new GregorianCalendar(1990,1,1); //jan 1 1970
		GregorianCalendar lastDay = new GregorianCalendar(2000,10,10); //oct 10, 2000
			
		
			try {
				t.getApptRange(appts, firstDay, firstDay);
			}
			catch( DateOutOfRangeException e) {}
			catch( NullPointerException e) {}
	 }
	 
	/**
	* Test permuting and removing appointments
	*/	  
	 @Test
	  public void test03()  throws Throwable  {
		 
		TimeTable t = new TimeTable();
		  LinkedList<Appt> appts = new LinkedList<Appt>();
		  Appt appt1 = new Appt(10,10,10,10,1995,"a","b");
		  Appt appt2 = new Appt(10,10,10,10,1996,"a","b");
		  Appt appt3 = new Appt(10,10,10,10,1997,"a","b");
		  Appt appt4 = new Appt(-1,10,10,10,1998,"a","b"); //bad
		  
		  appts.add(appt1);
		  appts.add(appt2);
		  appts.add(appt3);
		  
		//remove and re-add appt1
		t.deleteAppt(appts, appt1);
		appts.add(appt1);
		  
		int[] positions = {1,0,2};
		t.permute(appts, positions);
		
		int[] pos2 = {0,1,2};
		t.permute(appts,pos2);
		
		int[] pos3 = {2,1};
		//t.permute(appts,pos3);
		
		//remove appt from null list
		t.deleteAppt(null,appt1);
		//remove null appt
		t.deleteAppt(appts,null);
		//remove valid appt
		t.deleteAppt(appts,appt3);
		//remove appt again
		t.deleteAppt(appts,appt3);
		//remove bad appointments
		t.deleteAppt(appts,appt4);
		  
	  }
}
