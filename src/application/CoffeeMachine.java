package application;

import java.text.DecimalFormat;

public class CoffeeMachine {
	
	BeverageFactory factory = new BeverageFactory( );
	  BeverageStore store = new BeverageStore( factory );
	  Beverage beverage;
	  String payment;
	  String drinkType;
	  //double price;
	  
	  public final DecimalFormat MONEY = new DecimalFormat("$##.00");

	public CoffeeMachine()
	{
		
	}
	
	public String checkStatus()
	{
		 if (MachineStock.CheckStock() == true)
			 // to update as the text on the controller
			 return ("The machine is ready to use, you can put your money");
		 //We should also at this moment enable the button so the user can use them
		 else 
			 return ("We are sorry but the machine is actually not working");
		 //Keep the buttons disabled to make sure the user does nothing
	}
	
	public void init(){
		//coffee = store.orderCoffee("init");
	}
	
	public void Start()
	{
	
			MachineMoney.resetAmount();
			MachineMoney.resetBadge();
			beverage = store.orderDrink(drinkType);
			System.out.println("you just ordered a " + beverage.getName( ) + "\n");
			MachineStock.updateStock(drinkType);
			afterpurchase();
		
	}
	
	public void addMoney (double amount){
		//try catch
		MachineMoney.addMoney(amount);
	}
	
	public boolean checkMoney()
	{	
		
		if (MachineMoney.getAmout() >= beverage.getPrice())
		{
			return true;
		}
		else if (MachineMoney.checkCard() == true)
			{
			return true;
			}
		else return false;
			
	}
	
	public String displayMoney()
	
	{
		if (payment == "cash"){
		if (MachineMoney.getAmout() <= beverage.getPrice())
		{
			if (MachineMoney.getAmout() != beverage.getPrice())
		return ( "Please insert " + MONEY.format((beverage.getPrice() - MachineMoney.getAmout())));
			else 
		return ( "You put " + MONEY.format( MachineMoney.getAmout()) + " ready to order");
		}
		else
			{
			return ("take you change " + MONEY.format((MachineMoney.getAmout() - beverage.getPrice())) );
			}
		}
		else{
		if (payment == "card"){
			if (MachineMoney.checkCard() == true)
			return ( beverage.getPrice() + " has been charged on your card" );
			else return "This badge is not valid, please swipe a valid badge ";
			}
		else if (MachineMoney.getBadge() < 1)
			return "Swipe your badge or pay by cash";
		else return "An error occured";
		}
			
		//return ("you put: " + MachineMoney.getAmout());
	}
	
	public String showMoney(){
		return ( "You put " + MONEY.format(MachineMoney.getAmout()));
	}
	
	public String afterpurchase(){
		
		if (MachineStock.CheckStock() == false){
			if (MachineStock.getCoffeeStock() <= 0)
			  return ("The coffee needs to be refreshed");
			else if (MachineStock.getSugarStock() <= 0)
			 return ("The sugar needs to be refreshed");
			else if (MachineStock.getCreamStock() <= 0)
				return  ("The cream needs to be refreshed");
		}
		
		//We should reset the money count here 
		
		return (" Thank you for your purchase, the next coffee is now ready to be served");
	}
	
	public boolean CheckStock(){
	
		if (MachineStock.CheckStock() == false){
			return false;
		}
		else return true;
	}
	
	public void refreshStock(){
		MachineStock.refreshStock("type");
	}
	
	public void setCoffeeType(String ct)
	{
		this.drinkType = ct;
		beverage = store.setDrink(ct);
		
	}
	
	public void chargeCard (int ID){
		MachineMoney.setBadgeNumber(ID);
		MachineMoney.checkCard();
	}
	
	public void setPayment(String pay){
		this.payment = pay;
	}
	
}
