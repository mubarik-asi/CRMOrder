package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Functions.Conversions;
import Master.OrdersExecution;
import PageFactoryandTestdata.OrdersLocators;



public class Settings_SalesTaxDisabling_WithConfiguration extends OrdersExecution {

    public static String PAStateExistence_in_TaxesRate;
    public static WebElement toClear;
	public static void AutomaticSalesTax_Uncheck() throws IOException, InterruptedException{
		       try{
		// This is to Instantiate Services  class  
	   	 OrdersLocators Settings_SalesTax = PageFactory.initElements(driver, OrdersLocators.class);	
	
	     //Press the save button
	   	Settings_SalesTax.ProductConfiguration_AddCharge_SaveButton.click();
		    
	   	waitForPageLoad();
		    
	   	Thread.sleep(2000);
	
	       
	 Conversions.OrdernumberRegularExpressionStringConversion();
		   
	

    //Now Applying Manual Tax Rate Scenario
	 Settings_SalesTax.CloseOrder_Icon.click();
		   
		    waitForPageLoad();
		    
		    Thread.sleep(2000);
	   	 
    //Click the userInfoIcon on My Order screen	 
	   	 Settings_SalesTax.OrderListing_UserInfoIcon.click();
	   	 
	   	 
	  //Click the settings option
	   	 Settings_SalesTax.UserInfoIcon_Settings.click();
	   	 
	   	 
	  //Now Select the sales tax option in settings
	   	 Settings_SalesTax.Settings_SalesTax.click();
	   	 
	   	 
	 //Check if the automatically taxes calculation checkbox is selected or not
	   	 if(Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.isSelected())
	   	 {
	   	   Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.click();
	   	   
	   	   
	   	if(Settings_SalesTax.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
	   	 {
	   	  System.out.println("Automatic Sales Tax Calculated Checkbox and New Manual Rate entered unchecked Successfully");
	   	  resultPass("Disabling Automatic Sales Tax(Settings)", "Automatic Sales Tax Calculated Checkbox unchecked and New Manual Rate entered Successfully");
	   	 }
	   	 else{
	   		System.out.println("Automatic Sales Tax Calculated Checkbox and New Manual Rate entered unchecked UnSuccessfully");
		   	resultFail("Disabling Automatic Sales Tax(Settings)", "Automatic Sales Tax Calculated Checkbox and New Manual Rate entered unchecked UnSuccessfully");
	   	 }
	   	   
	   	 }
		   	 
		       }	   	
		   
		    catch(NoSuchElementException e) {
		    	 System.err.println("NoSuchElementException: " + e.getMessage());
		    }
   }

}

