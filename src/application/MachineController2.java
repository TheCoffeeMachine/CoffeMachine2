package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class MachineController2 {

		@FXML private Label finish, machineStatus, moneyStatus, moneyMissing, moneyReturn;
		@FXML private Button fivec, tenc, twentyfivec, oned, fived, refresh, swipeCard, payCard, payCash;
		@FXML private Button natural, sugar, cream, sugarCream, bouillon;
		
		private CoffeeMachine cm;

		/** Initialization that define natural coffee by default
		It also enable to guess button and text field**/
		@FXML public void initialize() {
			
			//ImageView iv = new ImageView(new Image(getClass().getResourceAsStream("src/image.png")));
			
			// iv.setImage(image2);
			 
			cm = new CoffeeMachine();
			
			cm.setCoffeeType ("natural");
			cm.setPayment("cash");
			cm.init();
			
			machineStatus.setText( cm.checkStatus());
			
			refresh.setDisable(true);
			swipeCard.setDisable(true);
			payCard.setDisable(false);
			payCash.setDisable (true);
			
			fivec.setShape(new Circle(40));
			fivec.setMaxSize(40,40);
			tenc.setShape(new Circle(5));
			tenc.setMaxSize(50,50);
			twentyfivec.setShape(new Circle(5));
			twentyfivec.setMaxSize(55,55);

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
			
			finish.setText( "");
			
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
				payCash.setDisable(true);
				swipeCard.setDisable(true);
				payCard.setDisable(true);
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
		
		@FXML protected void payCard( ActionEvent event) {
			
			cm.setPayment("card");
			fivec.setDisable(true);
			tenc.setDisable(true);
			twentyfivec.setDisable(true);
			oned.setDisable(true);
			fived.setDisable(true);
			payCard.setDisable(true);
			swipeCard.setDisable(false);
			payCash.setDisable (false);
			
		}
		
		@FXML protected void payCash( ActionEvent event) {
			
			cm.setPayment("cash");
			fivec.setDisable(false);
			tenc.setDisable(false);
			twentyfivec.setDisable(false);
			oned.setDisable(false);
			fived.setDisable(false);
			swipeCard.setDisable(true);
			payCard.setDisable(false);
			payCash.setDisable (true);
			
		}
		
		@FXML protected void chargeCard( ActionEvent event) {
			
			Random ran = new Random();
			int x = ran.nextInt(10);
			
			cm.chargeCard(x);
		}
		
		
	}
