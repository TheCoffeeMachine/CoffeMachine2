package application;

public class MachineStock {
	
	private static int CoffeeStock = 3;
	private static int SugarStock = 100;
	private static int CreamStock = 100;
	private static int StockCapacity = 100;
	
	
	/** This method decrease the stock each time a 
	 * beverage is pored according to what ingredients 
	 * have been used for it **/
	public static void updateStock (String type)
	{	
		if (type == "natural"){
			CoffeeStock--;
		}else if (type == "sugar"){
			CoffeeStock--;
			SugarStock--;
		}else if (type == "cream"){
			CoffeeStock--;
			CreamStock--;
		}else if (type == "sugarCream"){
			CoffeeStock--;
			SugarStock--;
			CreamStock--;
		}
		
	}
	
	//When we refresh the stock we call this method
	public static void refreshStock(String type)
	{
		//if (type == "Coffee"){
			CoffeeStock += StockCapacity;
		//} else if (type == "Sugar"){
			SugarStock += StockCapacity;
		//} else if (type == "Cream"){
			CreamStock += StockCapacity;
		//}
		
	}
	
	public static int getCoffeeStock(){
		return CoffeeStock;
	}
	public static int getSugarStock(){
		return SugarStock;
	}
	public static int getCreamStock(){
		return CreamStock;
	}
	
	public static boolean CheckStock(){
		if (CoffeeStock > 0 && SugarStock > 0 && CreamStock > 0){
			return true;
		}
		else return false;
	}
}
