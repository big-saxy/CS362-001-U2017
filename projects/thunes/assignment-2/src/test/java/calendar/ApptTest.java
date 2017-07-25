package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 
	/**
	* Test hour mutator and getValid method with bad hour
	*/
	 @Test
	  public void test02()  throws Throwable  {
		  
		 int startHour=-5;			//bad!
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
	// change hour to valid time, assert
		appt.setStartHour(20);
		assertEquals(20, appt.getStartHour());
		assertTrue(appt.getValid());
	//change to incorrectly large minute value
		appt.setStartHour(70);
		assertTrue(!appt.getValid());
	  }
	/**
	* Test minute mutator and getValid method with bad minute
	*/
	 @Test
	  public void test03()  throws Throwable  {
		 int startHour=13;
		 int startMinute=-1;		//bad!
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
	// change hour to valid time, assert
		appt.setStartMinute(20);
		assertEquals(20, appt.getStartMinute());
		assertTrue(appt.getValid());
	//change to incorrectly large minute value
		appt.setStartMinute(70);
		assertTrue(!appt.getValid());
	  }
	  
	/**
	* Test day mutator and getValid method with bad day
	*/
	 @Test
	  public void test04()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=-1;		//bad!
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
	// change hour to valid time, assert
		appt.setStartDay(20);
		assertEquals(20, appt.getStartDay());
	  }
	  	  
	/**
	* Test month mutator and getValid method with bad month
	*/
	 @Test
	  public void test05()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=20;
		 int startMonth=8;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
	// assertions
	// change hour to valid time, assert
		appt.setStartMonth(2);
		assertEquals(2, appt.getStartMonth());
		assertTrue(appt.getValid());
	// use bad month
		appt.setStartMonth(13);		//crashes

	  }

	/**
	* Test year, title, description mutator methods
	*/	  
	 @Test
	  public void test06()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=20;
		 int startMonth=8;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		//assertions
		//test year mutator
		appt.setStartYear(45545);
		assertEquals(45545, appt.getStartYear());
		//test title mutator
		appt.setTitle("This");
		assertEquals("This", appt.getTitle());
		//test title mutator with null input
		appt.setTitle(null);
		assertEquals("", appt.getTitle());
		//test desc mutator
		appt.setDescription("That");
		assertEquals("That", appt.getDescription());
		//test desc mutator with null input
		appt.setDescription(null);
		assertEquals("", appt.getDescription());
		
	  }
	  
	/**
	* Test toString and 
	*/	  
	 @Test
	  public void test07()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions		  
		String result = appt.toString();
		//use AM hour
		appt.setStartHour(5);
		result = appt.toString();
		//use 0 hour
		appt.setStartHour(0);
		result = appt.toString();
		//use invalid date
		appt.setStartHour(30);
		result = appt.toString();
	  }	
}
