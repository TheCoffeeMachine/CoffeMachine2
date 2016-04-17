package application;

public class CoffeeFactory {

	 public Coffee makeCoffee( String type ) {
	  Coffee coffee = null;

	  if (type.equals("natural")) {
	   coffee = new CoffeeNatural( );
	  } else if (type.equals("sugar")) {
	   coffee = new CoffeeSugar( );
	  } else if (type.equals("cream")) {
	   coffee = new CoffeeCream( );
	  } else if (type.equals("sugarCream")) {
		   coffee = new CoffeeSugarCream( );
	  } else if (type.equals("init")) {
		   coffee = new Coffeeinit( );
	  }
	  return coffee;
	 }
	}

