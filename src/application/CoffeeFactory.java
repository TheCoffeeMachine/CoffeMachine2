package application;

public class CoffeeFactory {

	 public Coffee makeCoffee( String type ) {
	  Coffee coffee = null;

	  if (type.equals("Natural")) {
	   coffee = new CoffeeNatural( );
	  } else if (type.equals("Sugar")) {
	   coffee = new CoffeeSugar( );
	  } else if (type.equals("Cream")) {
	   coffee = new CoffeeCream( );
	  } else if (type.equals("SugarCream")) {
		   coffee = new CoffeeSugarCream( );
	  }
	  return coffee;
	 }
	}

