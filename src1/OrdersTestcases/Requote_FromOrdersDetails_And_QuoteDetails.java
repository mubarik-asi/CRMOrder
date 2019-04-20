package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import Master.OrdersExecution;
import PageFactoryandTestdata.OrdersLocators;


public class Requote_FromOrdersDetails_And_QuoteDetails extends OrdersExecution{
	
	
	static OrdersLocators Requote = PageFactory.initElements(driver, OrdersLocators.class);
	public static void Requote_From_Orders_Details() throws IOException, InterruptedException, AWTException{
		try{
	 
			Click("Click the More Button", Requote.Orderdetails_MoreButton);
			
			Click("Click the Create Quote option", Requote.Orderdetails_MoreButton_CreateQuote);
			
			Thread.sleep(2000);
			
			if(!Requote.Copy_NoInstructions_To_NewQuote.isSelected())
			{
				Click("Instructions Checkbox is not selected", Requote.Copy_NoInstructions_To_NewQuote);
			}
			Click("Click the Continue Button To Complete Requote From Order Details", Requote.CreateQuote_CopyOptions_Continue_Button);
			
			waitForElementNotVisible(120, driver,Requote.SpinnerLoader);
			
			Thread.sleep(25000);
			
			if(Requote.CopyQuote_FromOrderDetails_Verification.getText().contains("Your Quote has been copied") & Requote.ViewInstructions.isDisplayed())
			{
				System.out.println("Quote Copy from Orders details Successfully");
				
				resultPass("Requote_From_Orders_Details", "Quote Copy from Orders details Successfully");
			}
    	
			else{
                System.out.println("Quote Copy from Orders details UnSuccessfully");
				
				resultFail("Requote_From_Orders_Details", "Quote Copy from Orders details UnSuccessfully");
			}
		
		
		}
     	catch (NoSuchElementException e) {
     	      e.getMessage();
         }
     	
	}
		
   public static void Requote_From_Quote_Details() throws InterruptedException, IOException{
	   try{
		   
		   Click("Click the More Button", Requote.Orderdetails_MoreButton);
		   
		   Click("Click the Create Quote option", Requote.Requote_Option_QuoteDetails);
			
		   Thread.sleep(1000);
			
		   
		   Click("Uncheck the Instruction Checkbox", Requote.Copy_NoInstructions_To_NewQuote);
		   
		   Thread.sleep(1000);
		   
		   Click("Click the Continue Button To Complete Requote From Order Details", Requote.CreateQuote_CopyOptions_Continue_Button);
		   
		   waitForElementNotVisible(120, driver,Requote.SpinnerLoader);
			
		   Thread.sleep(25000);
		   
		   List<WebElement> records = Requote.NoViewInstructions_Verification_AfterCopyingQuote;
		   int size=records.size();
		   System.out.println(size);
		   
		   
		   if(Requote.CopyQuote_FromOrderDetails_Verification.getText().contains("Your Quote has been copied") & size==0)
			{
				System.out.println("Quote Copy from Quote details Successfully");
				
				resultPass("Requote_From_Quote_Details", "Quote Copy from Quote details Successfully");
			}
   	
			else{
               System.out.println("Quote Copy from Quote details UnSuccessfully");
				
				resultFail("Requote_From_Quote_Details", "Quote Copy from Quote details UnSuccessfully");
			}
		
		
			
		   
		   
	   
	   
	   }catch(NoSuchElementException e){
		   e.getMessage();
	   }
   }



}
