package application;

public class MachineMoney {

	private static double amount;
	private static int badgeNumber;
	
	
	public static double getAmout(){
	return amount;
	}
	
	public static void addMoney(double money){
		amount = amount + money;
	}
	
	public static void resetAmount(){
		amount = 0;
	}
	
	public static boolean chargeCard(int ID){
		//method that remove the money from the account 
		//and returns true once done or false if not
		return true;
	}
	
	public static boolean checkCard(){
		
		if (badgeNumber > 2 && badgeNumber < 9){
			chargeCard(badgeNumber);
			return true;
		}
		else return false;
	}
	
	public static void resetBadge(){
		badgeNumber = -1;
	}
	
	public static void setBadgeNumber(int ID){
		badgeNumber = ID;
	}
	
	public static int getBadge(){
		return badgeNumber;
	}
	
}
