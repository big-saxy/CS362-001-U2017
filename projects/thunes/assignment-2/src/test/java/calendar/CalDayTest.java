package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalDayTest {

	/**
	* Test constructors and iterator
	*/	 
	 @Test
	  public void test01()  throws Throwable  {
		  
		  CalDay calday = new CalDay();
		  assertFalse(calday.isValid());
		  assertNull(calday.iterator());
		  //use GregorianCalendar object
		  GregorianCalendar cal = new GregorianCalendar();
		  calday = new CalDay(cal);
		  assertTrue(calday.isValid());
		  assertNotNull(calday.iterator());

	 }
	/**
	* Test addAppt method
	*/	 
	 @Test
	  public void test02()  throws Throwable  {
		  
		  //create calday object
		  CalDay calday = new CalDay(new GregorianCalendar(1970, 10, 9));
		  //create and add appointment
		  Appt appt = new Appt(10,10,10,10,1970,"this","that");
		  calday.addAppt(appt);
		  //create and add different appointment
		  Appt apptNew = new Appt(9,10,10,10,1970,"those","these");
		  calday.addAppt(apptNew);
		  //create and add another appointment
		  Appt apptAfter = new Appt(11,10,10,10,1970,"a","b");
		  //create and add bad appointment
		  Appt apptBad = new Appt(-1, 10, 10, 10, 1970, "those","these");
		  calday.addAppt(apptBad);
		  
		  //check number of appts
		  assertEquals(3, calday.getSizeAppts());
		  
		 
	 }


	 
	/**
	* Test toString method
	*/	  
	 @Test
	  public void test03()  throws Throwable  {
		  CalDay calday = new CalDay();
		  String result = calday.toString();
		  
		  calday = new CalDay(new GregorianCalendar());
		  result = calday.toString();
		  //add appointment
		  calday.addAppt(new Appt(1,1,1,1,1,"a","b"));
		  result = calday.toString();
	  }
}
