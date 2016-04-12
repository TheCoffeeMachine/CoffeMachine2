package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MachineController {

		@FXML private RadioButton natural, sugar, cream, sugarCream;
		@FXML private Label finish;
		@FXML private Button pay, brew;
		@FXML private TextField moneyPaid;
		
		private CoffeeMachine cm;

		/** Initialization that define a scale of 10 by default
		It also enable to guess button and text field**/
		@FXML public void initialize( ) {
			cm = new CoffeeMachine();
			/*
			natural.setDisable(true);
			sugar.setDisable(true);
			cream.setDisable(true);
			sugarCream.setDisable(true);
			brew.setDisable(true);
			*/
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
			
		}
		
		/** This method calls the model class methods that compare the 
		 * two numbers and return a string that is shown on the 
		 * bottom of the box **/
		@FXML protected void makeCoffee ( ActionEvent event) {
			cm.Start();
		}
	}
