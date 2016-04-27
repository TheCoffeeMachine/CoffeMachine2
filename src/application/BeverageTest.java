/**
 * 
 */
package application;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author nicklheureux
 *
 */
public class BeverageTest {
	
	
	private Beverage bev; 
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		    bev = new CoffeeCream( );
		  }//end setUp

	public void testGetName( ) {
		 Assert.assertEquals( "CoffeeCream", 
                 bev.getName( ) );
		 }

	  public void testFinishPooring() {
		  Assert.assertEquals( "Your " + "CoffeeCream" + " is now ready", bev.toString());
		 }
	  
	  @SuppressWarnings("deprecation")
	@Test
	  public void testGetPrice( ) {
		  
	     bev.setPrice( 0.5 );
	     Assert.assertEquals( 0.5, bev.getPrice( ), .01 );
	  }//end testGetPrice

	   
	  @SuppressWarnings("deprecation")
	@Test
	  public void testSetPrice( ) {
		  
	     bev.setPrice( 0.5 );
	     Assert.assertEquals( 0.5, bev.getPrice( ), .01 );
	  }//end testSetPrice






	} // end BeverageTest


