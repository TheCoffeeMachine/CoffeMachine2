package application;

public class CoffeeMachine {
	
	  CoffeeFactory factory = new CoffeeFactory( );
	  CoffeeStore store = new CoffeeStore( factory );
	  Coffee coffee;
	  String CoffeeType;

	public CoffeeMachine()
	{
		
	}
	
	
	// Should be onAction on the controller to initialize the machine and check that it works
	public void initialisation()
	{
		 if (MachineStock.CheckStock() == true)
			 // to update as the text on the controller
			 System.out.println("The machine is ready to use, you can put your money");
		 //We should also at this moment enable the button so the user can use them
		 else 
			 System.out.println("We are sorry but the machine is actually not working");
		 //Keep the buttons disabled to make sure the user does nothing
	}
	
	// this method is called every time the costumer try to order a coffee
	//and 
	public void Start()
	{
		if (checkMoney() == true)
		{
			displayMoney();
		}
		else 
		{
			
			displayMoney();
			coffee = store.orderCoffee(CoffeeType);
			  System.out.println("you just ordered a " + coffee.getName( ) + "\n");
			  MachineStock.updateStock(CoffeeType);
			  afterpurchase();
		}
		 
		
		
	}
	
	public void addMoney (double amount){
		MachineMoney.addMoney(amount);
	}
	
	//Check if there is enough money
	public boolean checkMoney()
	{
		if (MachineMoney.checkChange() > 0)
			return true;
			else return false;
	}
	
	//Displays if there is enough money
	public void displayMoney()
	{
		if (MachineMoney.getAmout() < MachineMoney.getPrice()){
			System.out.println ("Please insert " + MachineMoney.checkChange());
		}
		else if (MachineMoney.getAmout() > MachineMoney.getPrice()){
			System.out.println ("Take your change: " + (MachineMoney.checkChange() * (-1)));
			MachineMoney.resetAmount();
		}
		
	}
	
	//after the purchase we check the stock again to make sure it's good for the 
	//next costumer or send a message to refresh the stock 
	public void afterpurchase(){
		
		if (MachineStock.CheckStock() == false){
			if (MachineStock.getCoffeeStock() <= 0)
			 System.out.println("The coffee needs to be refreshed");
			else if (MachineStock.getSugarStock() <= 0)
			 System.out.println("The sugar needs to be refreshed");
			else if (MachineStock.getCreamStock() <= 0)
				 System.out.println("The cream needs to be refreshed");
		}
		
		//We should reset the money count here 
		
		System.out.println("Next coffee is ready to be served");
	}
	
	public void setCoffeeType(String ct){
		this.CoffeeType =ct;
	}
}
