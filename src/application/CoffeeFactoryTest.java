package application;

public class CoffeeFactoryTest {
	 
	 public static void main( String[] args ) {
	  BeverageFactory factory = new BeverageFactory( );
	  BeverageStore store = new BeverageStore( factory );

	  Beverage coffee = store.orderDrink("Sugar");
	  System.out.println("You just ordered a " + coffee.getName( ) + "\n");
	 
	  coffee = store.orderDrink("Natural");
	  System.out.println("you just ordered a " + coffee.getName( ) + "\n");
	  
	 coffee = store.orderDrink("SugarCream");
	  System.out.println("You just ordered a " + coffee.getName( ) + "\n");
	  
	  coffee = store.orderDrink("Cream");
	  System.out.println("You just ordered a " + coffee.getName( ) + "\n");
	  
	 }
	}