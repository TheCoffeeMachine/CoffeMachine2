package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MachineController2 {

		@FXML private Label finish, machineStatus, moneyStatus, moneyMissing, moneyReturn;
		@FXML private Button fivec, tenc, twentyfivec, oned, fived, refresh;
		@FXML private Button natural, sugar, cream, sugarCream, bouillon;
		
		private CoffeeMachine cm;

		/** Initialization that define a scale of 10 by default
		It also enable to guess button and text field**/
		@FXML public void initialize() {
			
			cm = new CoffeeMachine();
			
			cm.setCoffeeType ("natural");
			cm.init();
			
			machineStatus.setText( cm.checkStatus());
			
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
			else if ( event.getSource() == bouillon ) {
				cm.setCoffeeType ("bouillon");
			}
		}
		
		/** This method enable the text field and guess button.
		 * It also create a random number and set it in the model class  **/
		@FXML protected void addMoney( ActionEvent event) {
			
			if ( event.getSource() == fivec ) {
				cm.addMoney(.05);
			}
			else if ( event.getSource() == tenc ) {
				cm.addMoney(.10);
			}
			else if ( event.getSource() == twentyfivec ) {
				cm.addMoney(.25);
			}
			else if ( event.getSource() == oned ) {
				cm.addMoney(1.0);
			}
			else if ( event.getSource() == fived ) {
				cm.addMoney(5.0);
			}
			
			if (cm.checkMoney() == true)
				
				{
				
				finish.setText( "");
				}
			
			moneyStatus.setText(cm.showMoney());
		}
		
		/** This method calls the model class methods that compare the 
		 * two numbers and return a string that is shown on the 
		 * bottom of the box **/
		@FXML protected void makeCoffee ( ActionEvent event) {
			
			setCoffee(event);
			
			moneyReturn.setText(cm.displayMoney());
			
			if (cm.checkMoney() == true)
			{
				
				cm.Start();
				
				finish.setText( cm.afterpurchase());
				
				if (cm.CheckStock() == false){
					
				refresh.setDisable(false);
				
				fivec.setDisable(true);
				tenc.setDisable(true);
				twentyfivec.setDisable(true);
				oned.setDisable(true);
				fived.setDisable(true);
				natural.setDisable(true);
				sugar.setDisable(true);
				cream.setDisable(true);
				sugarCream.setDisable(true);
				bouillon.setDisable(true);
				}
			
			}
			
		}
		/* This method calls the refreshStock in the CoffeeMachine 
		 * class and enable the buttons so then they can be used again
		 * */
		@FXML protected void refreshStock ( ActionEvent event){
			cm.refreshStock();
			initialize();
			fivec.setDisable(false);
			tenc.setDisable(false);
			twentyfivec.setDisable(false);
			oned.setDisable(false);
			fived.setDisable(false);
			natural.setDisable(false);
			sugar.setDisable(false);
			cream.setDisable(false);
			sugarCream.setDisable(false);
			bouillon.setDisable(false);
		}
		
	}
