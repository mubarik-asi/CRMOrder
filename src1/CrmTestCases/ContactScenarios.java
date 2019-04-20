
package CrmTestCases;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class ContactScenarios extends HelpingFunction {
	static String SelectedConROwn;
// static WebElement DefaultVisi1;
	 static boolean bol;
	// static WebElement DefaultVisi2;

	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			
			
			    public static void CreateContact(boolean b) throws InterruptedException, AWTException, IOException{
			    	  	 
					  	 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
				
					 if(b) {
						 Click("Please click at Actionbutton",GetData.ClickAtAction);
						 Thread.sleep(2000);
						 Click("Please click at Create Contact Link",GetData.CreateContactLink);
						
					 }
					 else {
						 Thread.sleep(3000);
						 System.out.println("Else Past is executed");
						 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
						 Click("Please click at add Contact button",GetData.AddContact);
						
				 	}
					 
						 Input("Please Enter First Name", GetData.ContactFName, CrmTestData.ContactFName);
						 Input("Please Enter Last Name", GetData.ContactLName, CrmTestData.ContactLName);
						 Input("Please Enter  Phone", GetData.ContactPhone, CrmTestData.CompPhone);
						 Input("Please Enter Email", GetData.ContactEMail, CrmTestData.CompEmail);
						 Input("Please Enter Website", GetData.ContactWebsite, CrmTestData.CompWebsite);
						
						 Thread.sleep(2000);
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();

				
						 
						 ClickAt("Please click at Save Contact Save button ",GetData.SaveButton);
						 Thread.sleep(6000);
						 Verify(CrmTestData.CompPhone, GetData.PhnVerify.getText(), "Phone content is not matching");
					/*	 Verify(CrmTestData.CompEmail, GetData.EmailVerify.getText(), "Email content is not matching");
						 Verify(CrmTestData.CompWebsite, GetData.WebVerify.getText(), "Web content is not matching");*/
						 		
			    		} 

				
			  		
}
