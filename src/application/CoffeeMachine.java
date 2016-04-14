package application;

public class CoffeeMachine {
	
	  CoffeeFactory factory = new CoffeeFactory( );
	  CoffeeStore store = new CoffeeStore( factory );
	  Coffee coffee;
	  String coffeeType;
	  double price;

	public CoffeeMachine()
	{
		
	}
	
	
	// Should be onAction on the controller to initialize the machine and check that it works
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
	
	// this method is called every time the costumer try to order a coffee
	//and 
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
	
	//Check if there is enough money
	public boolean checkMoney()
	{	
		
		/*if (MachineMoney.getAmout() >= .35)
		{
			return true;
		}
		else
			{
			return false;
			}
			*/
		return true;
	}
	
	//Displays if there is enough money
	public String displayMoney()
	
	{/*
		if (MachineMoney.getAmout() >= coffee.getPrice()){
		return ( "Please add " + (coffee.getPrice() - MachineMoney.getAmout()));
		}
		else
			{
			return ("take you change" + (MachineMoney.getAmout() - coffee.getPrice()) );
			}
			*/
		return ("you put: " + MachineMoney.getAmout());
	}
	
	public String moneyProblem(){
		return ("Please add more money");
	}
	
	//after the purchase we check the stock again to make sure it's good for the 
	//next costumer or send a message to refresh the stock 
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
		
		return ("Next coffee is ready to be served");
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
	}
	
	public void setPrice(double sp){
		this.price = sp;;
	}
}
