package application;

public class CoffeeStore {
 CoffeeFactory factory;
 
 public CoffeeStore(CoffeeFactory factory) { 
  this.factory = factory;
 }
 
 public Coffee orderCoffee(String type) {
  Coffee coffee;
 
  coffee = factory.makeCoffee(type);
 
  coffee.prepare();
  coffee.heatWater();
  coffee.finishPooring();

  return coffee;
 }

}
