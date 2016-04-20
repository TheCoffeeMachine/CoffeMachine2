package application;

import java.text.DecimalFormat;

public class CoffeeMachine {
	
	  CoffeeFactory factory = new CoffeeFactory( );
	  CoffeeStore store = new CoffeeStore( factory );
	  Coffee coffee;
	  String coffeeType;
	  double price;
	  
	  public final DecimalFormat MONEY = new DecimalFormat("$##.##");

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
			coffee = store.orderCoffee(coffeeType);
			System.out.println("you just ordered a " + coffee.getName( ) + "\n");
			MachineStock.updateStock(coffeeType);
			afterpurchase();
		
	}
	
	public void addMoney (double amount){
		//try catch
		MachineMoney.addMoney(amount);
	}
	
	public boolean checkMoney()
	{	
		
		if (MachineMoney.getAmout() >= coffee.getPrice())
		{
			return true;
		}
		else
			{
			return false;
			}
	}
	
	public String displayMoney()
	
	{
		if (MachineMoney.getAmout() <= coffee.getPrice())
		{
			if (MachineMoney.getAmout() != coffee.getPrice())
		return ( "Please insert " + MONEY.format((coffee.getPrice() - MachineMoney.getAmout())));
			else 
		return ( "You put " + MONEY.format( MachineMoney.getAmout()) + " ready to order");
		}
		else
			{
			return ("take you change " + MONEY.format((MachineMoney.getAmout() - coffee.getPrice())) );
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
		this.coffeeType = ct;
		coffee = store.setCoffee(ct);
		
	}
	
	public void setPrice(double sp){
		this.price = sp;;
	}
}
