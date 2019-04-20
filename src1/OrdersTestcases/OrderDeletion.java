package OrdersTestcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.OrdersExecution;
import PageFactoryandTestdata.OrdersLocators;


public class OrderDeletion extends OrdersExecution {
	static OrdersLocators  DeleteOrder = PageFactory.initElements(driver, OrdersLocators.class);
	 static Robot rb;
	public static void PayWith_ElectronicFundsOption_DropdownVerification() throws IOException, InterruptedException, AWTException{
        try{
		
       Click("Click order home page", DeleteOrder.ESPWebHomePage_OrdersTab);
	 
	 Click("Click order button", DeleteOrder.OrdersScreen_OrderButton);
	   
	 //Select the Sales Order option from toggle dropdown
		 Click("Click  button", DeleteOrder.CreateOrder_SalesOrderOption);

	 
	   if(driver.getPageSource().contains("Electronic Funds Transfer"))
		{
		   System.out.println("Pay with drop down should contain new value 'Electronic Funfs Transfer' option");
		   
		   resultPass("Pay with drop down should contain new value 'Electronic Funfs Transfer' option", "Pay with drop down should contain new value 'Electronic Funfs Transfer' option");
		}
		else{
	        System.out.println("Pay with drop down is not showing dropdown value 'Electronic Funfs Transfer' option");
			
	        resultFail("Pay with drop down is not showing value 'Electronic Funfs Transfer' option", "Pay with drop down is not showing dropdown value 'Electronic Funfs Transfer' option");
		}	
        }catch(NoSuchElementException e)
        {
        	e.getStackTrace();
        }
	} 
        public static void ShipVia_LoomisGroundOption_DropdownVerifcation() throws IOException, InterruptedException{
    	   try{
	   
	   if(driver.getPageSource().contains("Loomis Ground"))
			{
			System.out.println("Two new entires (Loomis Ground , Loomis Air) are shwoing"); 
		   
		   resultPass("Two new entires (Loomis Ground , Loomis Air) are showing", "Two new entires (Loomis Ground , Loomis Air) are shwoing");
			}
			else{
		        System.out.println("Two new entires (Loomis Ground , Loomis Air) are not shwoing");
				
				resultFail("Two new entires (Loomis Ground , Loomis Air) are not shwoing", "Two new entires (Loomis Ground , Loomis Air) are not shwoing");
			}	
		   
       }catch(NoSuchElementException e)
    	   {
    	   e.getStackTrace();
    	   }
	   
        }
        
      public static void UploadDSTFile_Orderlevel() throws IOException, InterruptedException, AWTException{
    	  try{
	  
	   Thread.sleep(2000);
	 //Press the save button
	   Click("Click at save button", DeleteOrder.SampleRequestSaveButton);
	  
	   // waitForPageLoad();
	   // Thread.sleep(2000);
	   waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
	   
	   Thread.sleep(8000);
	    rb =new Robot();
	  // waitForPageLoad();
	  
	  
	   DeleteOrder.PushMenu.click();
	   Thread.sleep(2000);
	   DeleteOrder.UploadFile.click();
	   
	   
	   
	   waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
	   
	   
	   
	   Thread.sleep(1000);
			
	   rb.keyPress(KeyEvent.VK_C);
			
			rb.keyRelease(KeyEvent.VK_C);
			
			Thread.sleep(2000);
			
			 
			
			rb.keyPress(KeyEvent.VK_SHIFT);
			
			rb.keyPress(KeyEvent.VK_SEMICOLON);
			
			rb.keyRelease(KeyEvent.VK_SEMICOLON);
			
			rb.keyRelease(KeyEvent.VK_SHIFT);
			
			 
			
			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			
			
			
			 
			
			rb.keyPress(KeyEvent.VK_F);
			
			rb.keyRelease(KeyEvent.VK_F);
			
			 
			
			rb.keyPress(KeyEvent.VK_O);
			
			rb.keyRelease(KeyEvent.VK_O);
			
			 
			
			rb.keyPress(KeyEvent.VK_I);
			
			rb.keyRelease(KeyEvent.VK_I);
			
			
			rb.keyPress(KeyEvent.VK_L);
			
			rb.keyRelease(KeyEvent.VK_L);
			Thread.sleep(1000);
			
			rb.keyPress(KeyEvent.VK_DOWN);
			
			rb.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
			   
			   
			Thread.sleep(8000);
		if(DeleteOrder.DSTFileVerification.isDisplayed()) {
			System.out.println("Success message displaying while uploading DST file");
			   resultPass("Success message displaying while uploading DST file", "Success message displaying while uploading DST file");

		}
		else {
			System.out.println("Success message not displaying while uploading DST file");

			   resultFail("Success message  not displaying while uploading improper file", "Success message not displaying while uploading DST file");

		}
		
    	  }catch(NoSuchElementException e){
    		  e.getStackTrace();
    	  }
      finally {
    	  
    	  DeleteOrder.PushMenu.click();
	}
      
      
      
      }
      public static void InvalidFileUpload_ErrorMessageVerification() throws InterruptedException, IOException{
    	  try{
    		  DeleteOrder.PushMenu.click();
    		  
    		  Thread.sleep(2000);
		  DeleteOrder.UploadFile.click();
		
	   Thread.sleep(3000);
	 
		rb.keyPress(KeyEvent.VK_C);
		
		rb.keyRelease(KeyEvent.VK_C);
		
		Thread.sleep(2000);
		
		 
		
		rb.keyPress(KeyEvent.VK_SHIFT);
		
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		
		rb.keyRelease(KeyEvent.VK_SEMICOLON);
		
		rb.keyRelease(KeyEvent.VK_SHIFT);
		
		 
		rb.keyPress(KeyEvent.VK_BACK_SLASH);
		
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		
		Thread.sleep(2000);
		
		 
		
		rb.keyPress(KeyEvent.VK_T);
		
		rb.keyRelease(KeyEvent.VK_T);
		
		 
		
		rb.keyPress(KeyEvent.VK_E);
		
		rb.keyRelease(KeyEvent.VK_E);
		
		 
		
		rb.keyPress(KeyEvent.VK_S);
		
		rb.keyRelease(KeyEvent.VK_S);
		
		Thread.sleep(2000);
		
	   
		rb.keyPress(KeyEvent.VK_T);
		
		rb.keyRelease(KeyEvent.VK_T);
		
		Thread.sleep(1000);
		
		rb.keyPress(KeyEvent.VK_DOWN);
		
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	if(DeleteOrder.TitleMesg.getText().contains("Error")) {
		System.out.println("Error message displaying while uploading improper file");
		   resultPass("Error message displaying while uploading improper file", "Error message displaying while uploading improper file");

	}
	else {
		System.out.println("Error message displaying while uploading improper file");

		   resultFail("Error message  not displaying while uploading improper file", "Product Added To Order Successfully");

	}

    	  }catch(NoSuchElementException e)
    	  {
    		  e.getStackTrace();
    	  
    	  }
      }
      
	   
	  public static void DeleteOrder() throws InterruptedException, IOException{
		  try{
			  
	      DeleteOrder.PushMenu.click();
		 
	      Thread.sleep(2000);
		 //Press the more button
		   Click("Click at more button", DeleteOrder.Orderdetails_MoreButton);
		   
		   Thread.sleep(1000);
		 //Press the Delete Order Button
		   Click("Click at more button",  DeleteOrder.Orderdetails_MoreButton_DeleteOrder);
		   
		   Click("Click at more button",    DeleteOrder.DeleteOrder_Okbutton);
		   
		   waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
		   
		   
		   
		   Thread.sleep(2000);
		   
		   DeleteOrder.CloseAndExit.click();
			System.out.println("Order Deleted Successfully");
			resultPass("Delete Order", "Order Deleted Successfully");
		   
		

	
        }
	
	   catch(NoSuchElementException e){
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	   }
	}  
	
	  
}
