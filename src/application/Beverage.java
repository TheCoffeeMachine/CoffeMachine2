package application;


abstract public class Beverage {
	
  private String name;
  private String type;
  private double price;
 

 public Beverage (String name, String type, double price){
	 
	 this.name = name;
	 this.type = type;
	 this.price = price;
	 
 }
 
 public double getPrice(){
	 return price ;
 }
 
 public void setPrice( double newPrice){
	 this.price = newPrice ;
 }
 
 public String getName( ) {
  return name;
 }

 public void prepare() {
  System.out.println("Preparing " + name);
	  System.out.println ("with " + type );
	  
  System.out.println();
 }

 public void finishPooring() {
  System.out.println("Your " + name + " is now ready");
 }

 public String toString( ) {
  StringBuffer display = new StringBuffer( );
  display.append("---- " + name + " ----\n");
  return display.toString( );
 }
}
