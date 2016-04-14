package application;


abstract public class Coffee {
	
   String name;
   String type;
   double price;
 

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
	  System.out.print ("cost " + getPrice() );
	  
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
