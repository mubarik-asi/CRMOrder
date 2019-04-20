package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import Master.OrdersExecution;
import PageFactoryandTestdata.OrdersLocators;


public class OrderDeletion extends OrdersExecution {
	static OrdersLocators  DeleteOrder = PageFactory.initElements(driver, OrdersLocators.class);
	 
	 public static String Projectpath;
	public static void PayWith_ElectronicFundsOption_DropdownVerification() throws IOException, InterruptedException, AWTException{
        try{
		
       Click("Click order home page", DeleteOrder.ESPWebHomePage_OrdersTab);
	 
	 Click("Click order button", DeleteOrder.OrdersScreen_OrderButton);
	   
	 //Select the Sales Order option from toggle dropdown
		 Click("Click  button", DeleteOrder.CreateOrder_SalesOrderOption);
		 
		 Thread.sleep(5000);

	 
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
        
       public static void OrderSaving_WithoutSalesPerson_Validation_Verification() throws InterruptedException, IOException{
    	   try{
    		   
    		   Click("Click the Remove (X) for Sales Person Remove", DeleteOrder.SalesPerson_Remove_FromOrder_Icon);
    		   
    		   Click("Click at save button", DeleteOrder.SampleRequestSaveButton);
    			  
    		   if(DeleteOrder.OrderSaving_WithoutSalesPerson_Validation_Verification.isDisplayed()){
    			   System.out.println("Order Doesn't Save Without Sales Person, so test case is pass");
    			   resultPass("OrderSaving_WithoutSalesPerson_Validation_Verification", "Order Doesn't Save Without Sales Person, so test case is pass");
    		   }
    		   else{
    			   System.out.println("Order Doesn't Save Without Sales Person, so test case is pass");
    			   resultFail("OrderSaving_WithoutSalesPerson_Validation_Verification", "Order Does Save Without Sales Person, so test case is Fail");
    		   }
    		    
    	   }catch(NoSuchElementException e){
    		   e.getMessage();
    	   }
       
       finally {
		DeleteOrder.SalesPerson_Validation_Check_OK_Button.click();
		
		Thread.sleep(1000);
		
		DeleteOrder.SalesPersonField_CreateOrder.click();
		
		Thread.sleep(1000);
		
		DeleteOrder.SalesPerson_dropdown_Selection_CreateOrder.click();
		
		Thread.sleep(1000);
	}
       
       
       }
        
        
        
        
        
        public static void UploadDSTFile_Orderlevel() throws IOException, InterruptedException, AWTException{
    	  try{
	  
	   Thread.sleep(2000);
	 //Press the save button
	   Click("Click at save button", DeleteOrder.SampleRequestSaveButton);
	  
	    waitForPageLoadSave();
	   // Thread.sleep(2000);
	   //waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
	  
	   Thread.sleep(6000);
	    //rb =new Robot();
	  // waitForPageLoad();
	  
	  
	   DeleteOrder.PushMenu.click();
	   Thread.sleep(2000);
	   DeleteOrder.UploadFile.click();
	   
	  
	   
	   //waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
	   
	   
	   
	   Thread.sleep(3000);
			
	
			//waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
			
	   
	   Projectpath=System.getProperty("user.dir");
		System.out.println(Projectpath);
   	 
       Runtime.getRuntime().exec(Projectpath+"/Img/foil.exe");
	   
	   waitForPageLoading();  
			   
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
	 
		
	   Projectpath=System.getProperty("user.dir");
		System.out.println(Projectpath);
  	 
      Runtime.getRuntime().exec(Projectpath+"/Img/test.exe");
		
		
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
      finally {
    	  DeleteOrder.PushMenu.click();
 		 
	      Thread.sleep(2000);
	}
      
      }
      
      public static void Upload_AIExtension_File() throws InterruptedException, IOException{
    	  try{
    		  DeleteOrder.PushMenu.click();
    		  
    		  Thread.sleep(2000);
		  DeleteOrder.UploadFile.click();
		
	   Thread.sleep(3000);
	 
		
	   Projectpath=System.getProperty("user.dir");
		System.out.println(Projectpath);
  	 
      Runtime.getRuntime().exec(Projectpath+"/Img/Sample.exe");
      
      waitForPageLoading(); 
      
      Thread.sleep(12000);
		
		
	if(DeleteOrder.AIFileVerification.isDisplayed()) {
		System.out.println("AI Extension File Uploaded Sucessfully");
		   resultPass("Upload_AIExtension_File_Verification", "AI Extension File Uploaded Sucessfully");

	}
	else {
		System.out.println("AI Extension File Uploaded Sucessfully");

		 resultFail("Upload_AIExtension_File_Verification", "AI Extension File Uploaded UnSucessfully");

	}

    	  }catch(NoSuchElementException e)
    	  {
    		  e.getStackTrace();
    	  
    	  }
      finally {
    	  DeleteOrder.PushMenu.click();
 		 
	      Thread.sleep(2000);
	}
      
      }
      
      
      public static void CustomProducts_SupplierSelection_Dropdown_Verification() throws InterruptedException, IOException{
		  try{
			  
		  //Press the Custom Product Option
			  DeleteOrder.CreateCustomProduct_CaretIcon.click();
			  
			  DeleteOrder.NewProduct_Link_CustomPro.click();
			  
			  Thread.sleep(3000);
			  
			  //Validate if the Supplier Selection Dropdown occurs or not
			  if(DeleteOrder.CustomProduct_SupplierDropdown_Verification.isDisplayed())
			  {
				  System.out.println("Supplier Selection Dropdown for Custom Products Displayed Successfully");
				  resultPass("CustomProducts_SupplierSelection_Dropdown_Verification", "Supplier Selection Dropdown for Custom Products Displayed Successfully");
			  }
			  else{
				  System.out.println("Supplier Selection Dropdown for Custom Products Displayed UnSuccessfully");
				  resultFail("CustomProducts_SupplierSelection_Dropdown_Verification", "Supplier Selection Dropdown for Custom Products Displayed UnSuccessfully");
			  }
		  }catch(NoSuchElementException e){
			  e.getMessage();
			  
		  }
	   
	  
	  
	  }
	  
     public static void cogWheelIcon_CustomProducts_Verification() throws IOException, InterruptedException{
    	 try{
    		 
    	 if(DeleteOrder.CogWheelIcon_CustomProducts.isDisplayed()){
    		 System.out.println("Cog Wheel Icon for Custom Products Displayed Successfully");
    		 resultPass("cogWheelIcon_CustomProducts_Verification", "Cog Wheel Icon for Custom Products Displayed Successfully");
    	 }
    	 else{
    		 System.out.println("Cog Wheel Icon for Custom Products Displayed UnSuccessfully");
    		 resultFail("cogWheelIcon_CustomProducts_Verification", "Cog Wheel Icon for Custom Products Displayed UnSuccessfully");
    	 }
    	 
    	 }catch(NoSuchElementException e){
    		 e.getMessage();
    	 }
     
    	 finally {
    			DeleteOrder.CustomProduct_Popup_Cancel_Button.click();
    			
    			Thread.sleep(3000);
    		}
     
     }
      
      
      
      
      
      
      
      public static void DeleteOrder() throws InterruptedException, IOException{
		  try{
			  
	      
		 //Press the more button
		   Click("Click at more button", DeleteOrder.Orderdetails_MoreButton);
		   
		   Thread.sleep(1000);
		 //Press the Delete Order Button
		   Click("Click at more button",  DeleteOrder.Orderdetails_MoreButton_DeleteOrder);
		   
		   Click("Click at more button",    DeleteOrder.DeleteOrder_Okbutton);
		   
		   //waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
		   waitForPageLoading();
		  
		   
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
