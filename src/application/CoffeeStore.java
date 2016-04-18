package application;

public class CoffeeStore 
{
 CoffeeFactory factory;
 
	 public CoffeeStore(CoffeeFactory factory) { 
	  this.factory = factory;
	 }
	 
	 public Coffee orderCoffee(String type) {
	  Coffee coffee;
	 
	  coffee = factory.makeCoffee(type);
	 
	  coffee.prepare();
	  coffee.finishPooring();
	
	  return coffee;
	 }
	 
	 public Coffee setCoffee(String type) 
	 {
		  Coffee coffee;
		 
		  coffee = factory.makeCoffee(type);
	
		  return coffee;
		 }

}
