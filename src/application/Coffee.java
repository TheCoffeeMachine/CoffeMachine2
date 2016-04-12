package application;


abstract public class Coffee {
 String name;
 String type;
 

 public String getName( ) {
  return name;
 }

 public void prepare() {
  System.out.println("Preparing " + name);
	  System.out.print ("with " + type );
  System.out.println();
 }

 public void heatWater( ) {
  System.out.println("heating water ");
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
