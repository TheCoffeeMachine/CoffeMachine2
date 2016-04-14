package application;

public class MachineMoney {

	static double amount;
	
	
	public static double getAmout(){
	return amount;
	}
	
	public static void addMoney(double money){
		amount = amount + money;
	}
	
	public static void resetAmount(){
		amount = 0;
	}
	
}
