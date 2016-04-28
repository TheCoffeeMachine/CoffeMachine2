package application;


public class BeverageFactory {

	 public Beverage  makeDrink( String type ) {
		 Beverage  beverage = null;

	  if (type.equals("natural")) {
		beverage = new CoffeeNatural();
	  } else if (type.equals("sugar")) {
		beverage = new CoffeeSugar();
	  } else if (type.equals("cream")) {
		  beverage = new CoffeeCream();
	  } else if (type.equals("sugarCream")) {
		  beverage = new CoffeeSugarCream( );
	  } else if (type.equals("bouillon")) {
		  beverage = new Bouillon();
	  }
	  return beverage;
	 }
	}

