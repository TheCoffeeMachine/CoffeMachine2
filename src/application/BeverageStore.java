package application;

public class BeverageStore 
{
 BeverageFactory factory;
 
	 public BeverageStore(BeverageFactory factory) { 
	  this.factory = factory;
	 }
	 
	 public Beverage orderDrink(String type) {
	  Beverage coffee;
	 
	  coffee = factory.makeDrink(type);
	 
	  coffee.prepare();
	  coffee.finishPooring();
	
	  return coffee;
	 }
	 
	 public Beverage setDrink(String type) 
	 {
		  Beverage beverage;
		 
		  beverage = factory.makeDrink(type);
	
		  return beverage;
		 }

}
