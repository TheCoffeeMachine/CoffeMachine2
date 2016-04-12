package application;

public class MachineMoney {

	private static double CoffeePrice = 0.35;
	private static double amount;
	
	
	public static void setPrice(double price){
		CoffeePrice = price;
	}
	
	public static double getAmout(){
	return amount;
	}
	
	public static void addMoney(double money){
		amount = amount+money;
	}
	
	public static double checkChange(){
		return (CoffeePrice-amount);
	}
	
	public static double getPrice(){
		return CoffeePrice;
	}
	
	public static void resetAmount(){
		amount = 0;
	}
	
}
