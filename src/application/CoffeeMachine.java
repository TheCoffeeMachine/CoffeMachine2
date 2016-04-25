package application;

import java.text.DecimalFormat;

public class CoffeeMachine {
	
	BeverageFactory factory = new BeverageFactory( );
	  BeverageStore store = new BeverageStore( factory );
	  Beverage beverage;
	  String payment;
	  String drinkType;
	  
	  public final DecimalFormat MONEY = new DecimalFormat("$#0.00");

	public CoffeeMachine()
	{
		
	}
	
	/** This method check the status of the machine. I return a different String 
	according if the machine has enough stock and is ready to use or not **/
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

	
	/** This method send the information to the serve the beverage and 
	 * reset the amount of money so the next costumer has to insert his own money 
	 * or card. Finally this method also update the stock a display an internal 
	 * message that says the coffee is served **/
	public void Start()
	{
	
			MachineMoney.resetAmount();
			MachineMoney.resetBadge();
			beverage = store.orderDrink(drinkType);
			System.out.println("you just ordered a " + beverage.getName( ) + "\n");
			MachineStock.updateStock(drinkType);
			afterpurchase();
		
	}
	
	/** This method adds the amount of money added by the user **/
	public void addMoney (double amount){
		MachineMoney.addMoney(amount);
	}
	
	/** This method check if the amount of money is added is enough or if the card is valid **/
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
	
	/** This method returns a String with the money status for the user**/
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
				
				if (MachineMoney.getBadge() < 0)
				return "Swipe your badge or pay by cash";
				
				else
					return "This badge is not valid, please swipe a valid badge ";
			}
		}
		return "an error occured";	
	}
	
	/** This method return a String to show the user the amount of money already entered**/
	public String showMoney(){
		return ( "You put " + MONEY.format(MachineMoney.getAmout()));
	}
	
	/** This method returns a String to tell which stock needs to be refreshed **/
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
	
	/** This method returns a boolean if the Stock is good or bad**/
	public boolean CheckStock(){
	
		if (MachineStock.CheckStock() == false){
			return false;
		}
		else return true;
	}
	
	/** This method refresh the stock of an element **/
	public void refreshStock(){
		MachineStock.refreshStock("type");
	}
	
	/** This method set the type of beverage the user wants**/
	public void setCoffeeType(String ct)
	{
		this.drinkType = ct;
		beverage = store.setDrink(ct);
		
	}
	
	/** This method charges a card according to the card number swiped **/
	public void chargeCard (int ID){
		MachineMoney.setBadgeNumber(ID);
		MachineMoney.checkCard();
	}
	
	/** This method sets the type of payment the user wants to use**/
	public void setPayment(String pay){
		this.payment = pay;
	}
	
}
