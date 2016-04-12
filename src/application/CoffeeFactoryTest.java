package application;

public class CoffeeFactoryTest {
	 
	 public static void main( String[] args ) {
	  CoffeeFactory factory = new CoffeeFactory( );
	  CoffeeStore store = new CoffeeStore( factory );

	  Coffee coffee = store.orderCoffee("Sugar");
	  System.out.println("You just ordered a " + coffee.getName( ) + "\n");
	 
	  coffee = store.orderCoffee("Natural");
	  System.out.println("you just ordered a " + coffee.getName( ) + "\n");
	  
	 coffee = store.orderCoffee("SugarCream");
	  System.out.println("You just ordered a " + coffee.getName( ) + "\n");
	  
	  coffee = store.orderCoffee("Cream");
	  System.out.println("You just ordered a " + coffee.getName( ) + "\n");
	  
	 }
	}