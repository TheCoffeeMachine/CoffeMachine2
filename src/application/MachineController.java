package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MachineController {

		@FXML private RadioButton natural, sugar, cream, sugarCream;
		@FXML private Label finish, machineStatus, moneyStatus;
		@FXML private Button pay, brew, refresh;
		@FXML private TextField moneyPaid;
		
		private CoffeeMachine cm;

		/** Initialization that define a scale of 10 by default
		It also enable to guess button and text field**/
		@FXML public void initialize() {
			
			cm = new CoffeeMachine();
			
			cm.setCoffeeType ("natural");
			cm.init();
			
			machineStatus.setText( cm.checkStatus());
			
			pay.setDisable(false);
			moneyPaid.setDisable(false);
			
			natural.setDisable(true);
			sugar.setDisable(true);
			cream.setDisable(true);
			sugarCream.setDisable(true);
			brew.setDisable(true);
			refresh.setDisable(true);

		}
		/** Initialization that define a scale of 10 by default
		 *It also enable to guess button and text field**/
		@FXML protected void setCoffee( ActionEvent event) {
			
			if ( event.getSource() == natural ) {
				cm.setCoffeeType ("natural");
			}
			else if ( event.getSource() == sugar ) {
				cm.setCoffeeType ("sugar");
			}
			else if ( event.getSource() == cream ) {
				cm.setCoffeeType ("cream");
			}
			else if ( event.getSource() == sugarCream ) {
				cm.setCoffeeType ("sugarCream");
			}
		}
		
		/** This method enable the text field and guess button.
		 * It also create a random number and set it in the model class  **/
		@FXML protected void checkMoney( ActionEvent event) {
			
			cm.addMoney(Double.parseDouble(moneyPaid.getText()));
			
			if (cm.checkMoney() == true)
				
				{
				natural.setDisable(false);
				sugar.setDisable(false);
				cream.setDisable(false);
				sugarCream.setDisable(false);
				brew.setDisable(false);
				}
			
			moneyStatus.setText(cm.displayMoney());
		}
		
		/** This method calls the model class methods that compare the 
		 * two numbers and return a string that is shown on the 
		 * bottom of the box **/
		@FXML protected void makeCoffee ( ActionEvent event) {
			
			cm.Start();
			
			finish.setText( cm.afterpurchase());
			
			if (cm.CheckStock() == false){
				
			refresh.setDisable(false);
			
			pay.setDisable(true);
			moneyPaid.setDisable(true);
			natural.setDisable(true);
			sugar.setDisable(true);
			cream.setDisable(true);
			sugarCream.setDisable(true);
			brew.setDisable(true);
			
			}
		}
		
		@FXML protected void refreshStock ( ActionEvent event){
			cm.refreshStock();
			initialize();
		}
		
	}
