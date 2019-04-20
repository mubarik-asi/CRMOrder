package Master;
import static CrmTestCases.StartBrowser.StartupBrowser;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.base.Predicate;

import CrmTestCases.CompanyScenarios;
import CrmTestCases.ContactScenarios;
import CrmTestCases.Email;
import CrmTestCases.ExportScenarios;
import CrmTestCases.Filters;
import CrmTestCases.Login;
import CrmTestCases.Notes;
import CrmTestCases.RecordOwnerAndVisi;
import CrmTestCases.SettingsScenarios;
import CrmTestCases.Systemroperties;
import CrmTestCases.Tasks;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class CRMExecution {
	protected static String SelectedROwn;
	protected static boolean bol;
	protected static WebDriver driver;
	protected static String dest;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static String user;
	public static WebDriverWait wait;
	protected static String GetRecordsOwner;
	protected static String NotificationBefore;
	protected static String NotificationAfter;
	public static String TaskCurdat;
	public static String browser="chrome";
	static Predicate<WebDriver> pageLoaded;

	protected static String envirnment=CrmTestData.prod; // stage, uat, prod
		
	@BeforeSuite
			public static void SystmProperties() throws InterruptedException, AWTException, IOException{

		Systemroperties.Property();
		}

	@BeforeTest
			public void Startup() throws InterruptedException, AWTException, IOException{

					StartupBrowser();
			} 

	 	@Test  (priority=0)
	 		public static void LoginIdaho() throws InterruptedException, AWTException, IOException{
				 	Login.login();
				 	
			 	}

	  		/*  @Test(dependsOnMethods = { "LoginIdaho" })
	  		  public static void VerifyExistingDomain() throws InterruptedException, AWTException, IOException{
					 	Login.VerifyExistingDomain();
					 	
				 	}
  		  @Test(dependsOnMethods = { "LoginIdaho" })
	  		  public static void VerifyStateDDwrtCountry() throws InterruptedException, AWTException, IOException{
			 	  CompanyScenarios.VerifyStateDD();
			 	
		 	}
	*/
		      @Test(dependsOnMethods = { "LoginIdaho" })
		 	  public static void CreateCustomerComp() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.CreateCompany("Customer");	  
			 	}
		      

		      @Test(dependsOnMethods = { "CreateCustomerComp" })
		 	  public static void DeleteCustomerCompany() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.DeleteCompany();	  
			 	}
		
		      
		      @Test(dependsOnMethods = { "DeleteCustomerCompany" })
				 	  public static void CreateSupplierComp() throws InterruptedException, AWTException, IOException{
		    	      CompanyScenarios.CreateCompany("Supplier");	  
					 	}
		      @Test(dependsOnMethods = { "CreateSupplierComp" })
		 	  public static void DeleteSupplierCompany() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.DeleteCompany();	  
			 	}
		
		      @Test(dependsOnMethods = { "DeleteSupplierCompany" })
				 	  public static void CreateDecoratorComp() throws InterruptedException, AWTException, IOException{
						 	  CompanyScenarios.CreateCompany("Decorator");	  
					 	}
		      @Test(dependsOnMethods = { "CreateDecoratorComp" })
		 	  public static void DeleteDecoraorCompany() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.DeleteCompany();	  
			 	}
		
		      @Test(dependsOnMethods = { "DeleteDecoraorCompany" })
				 	  public static void CreateProspectComp() throws InterruptedException, AWTException, IOException{
						 	  CompanyScenarios.CreateCompany("Prospect");	  
					 	}
				      
		      @Test(dependsOnMethods = { "CreateProspectComp" })
		 	  public static void DeleteProspectCompany() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.DeleteCompany();	  
			 	}
		
		      
		      @Test(dependsOnMethods = { "DeleteProspectCompany" })
		 	  public static void CreateComp() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.CreateComp("Supplier"); 
			 	}
		
		      
    
		      @Test(dependsOnMethods = { "CreateComp" })
		 	  public static void VerifyBillingInfoInOrder() throws InterruptedException, AWTException, IOException{
				 	  CompanyScenarios.VerifyBillingInfoInOrder();
				 	  
				 	
			 	}
	 	
			 @Test  (priority=2)
			 public static void RecordOwn() throws InterruptedException, AWTException, IOException{
				 RecordOwnerAndVisi.VerifyRecordOwn();
				
			 	}
			 	
		 	 @Test  (priority=3)
			 public static void CompDefaultVisibility() throws InterruptedException, AWTException, IOException{
			 RecordOwnerAndVisi.VerifyVisibility();
				
			 	}
		 		
			 @Test  (priority=4)
			 public static void CompUpdatedVisibility() throws InterruptedException, AWTException, IOException{
				 RecordOwnerAndVisi.UpdatedVisibility();
				
			 	}

			 @Test  (priority=5)
			 public static void VerifyCompanyDetails() throws InterruptedException, AWTException, IOException{
				 CompanyScenarios.VerifyCompDetail();
				 	
			 	}
			 
			 @Test  (priority=6)
			 public static void AddCompAddress() throws InterruptedException, AWTException, IOException{
				 CompanyScenarios.AddAddress();
				 	
			 	}
			 	
			 @Test  (priority=7)
			 public static void AddCompNote() throws InterruptedException, AWTException, IOException{
				 Notes.AddNote();				 
			 	}

			 @Test  (priority=8)
			 public static void EditCompNote() throws InterruptedException, AWTException, IOException{
				 Notes.EditNote();				 
			 	}
			 
			 @Test  (priority=9)
			 public static void DelCompNote() throws InterruptedException, AWTException, IOException{
				 Notes.DelNote();				 
			 	}
			 
			 @Test  (priority=10)
			 public static void AddTaskUnderComp() throws InterruptedException, AWTException, IOException{
				 Tasks.AddTask();
			 }	 
		 
			 @Test  (priority=11)
			 public static void CompanyTaskDisplayingInAppointmentinAllViews() throws InterruptedException, AWTException, IOException{
				 Tasks.VerifyTaskInAppointment();
			 }	
			 
			 @Test  (priority=12)
			 public static void EditTaskUnderComp() throws InterruptedException, AWTException, IOException{
				 Tasks.EditTask();
			 }	 
				 
			 @Test  (priority=13)
			 public static void CompleteTaskUnderComp() throws InterruptedException, AWTException, IOException{
				 Tasks.CompleteTask();
			 }	
			 			
			 @Test  (priority=14, dependsOnMethods="CompleteTaskUnderComp")
			 public static void DeleteTaskUnderComp() throws InterruptedException, AWTException, IOException{
				 Tasks.DeleteTask();
			 }	
			 			 
			 @Test  (priority=15)
			 public static void AddContactUnderComp() throws InterruptedException, AWTException, IOException{
				 ContactScenarios.CreateContact(true);
			 	}
		 
			 @Test  (priority=16)
			 public static void ConRecordOwn() throws InterruptedException, AWTException, IOException{
				
				 RecordOwnerAndVisi.VerifyRecordOwn();
			 	}
			 @Test  (priority=17)
			 
			 public static void CompanyContactRShipVerificaton() throws InterruptedException, AWTException, IOException{
			 CompanyScenarios.RShipVerifBwContAndComp();
		 	}
	 
			 @Test  (priority=18)
			 public static void ConDefaultVisibility() throws InterruptedException, AWTException, IOException{
			 	RecordOwnerAndVisi.VerifyVisibility();
				
			 	}
			
			 @Test  (priority=19)
			 public static void ConUpdatedVisibility() throws InterruptedException, AWTException, IOException{
				 RecordOwnerAndVisi.UpdatedVisibility();
				
			 	}
			 
			 @Test  (priority=20)
			 
			 public static void AddContactAddress() throws InterruptedException, AWTException, IOException{
				 CompanyScenarios.AddAddress();
			 	}
			
			 @Test  (priority=21)
			 public static void AddContactNotes() throws InterruptedException, AWTException, IOException{
				 Notes.AddNote();
				 	
			 	}

			 @Test  (priority=22)
			 public static void EditNoteContent() throws InterruptedException, AWTException, IOException{
				 Notes.EditNote();				 
			 	}
			 
			 @Test  (priority=23)
			 public static void DelContNote() throws InterruptedException, AWTException, IOException{
				 Notes.DelNote();				 
			 	}
			 			
			 @Test  (priority=24)
			 public static void AddTaskUnderContact() throws InterruptedException, AWTException, IOException{
				 Tasks.AddTask();
				 	
			 	}
			 
			 @Test  (priority=25)
			 public static void ContactTaskDisplayingInAppointmentinAllViews() throws InterruptedException, AWTException, IOException{
				 Tasks.VerifyTaskInAppointment();
			 }	
			 
			 @Test  (priority=26)
			 public static void EditTaskUnderCont() throws InterruptedException, AWTException, IOException{
				 Tasks.EditTask();
			 }	 
			 
			 @Test  (priority=27)
			 
			 public static void CompleteTaskUnderCont() throws InterruptedException, AWTException, IOException{
				 Tasks.CompleteTask();
			 }	
		
			 @Test  (priority=28, dependsOnMethods="CompleteTaskUnderCont")
			 public static void DeleteTaskUnderCont() throws InterruptedException, AWTException, IOException{
				 Tasks.DeleteTask();
			 }	
			 
			 @Test  (priority=29 )
			 public static void SearchCreatedCompany() throws InterruptedException, AWTException, IOException{
				 
				 Filters.Search(true);
			 }
			
			 @Test  (priority=30)
			 public static void SearchCreatedContact() throws InterruptedException, AWTException, IOException{
				 
				 Filters.Search(false);
			 }
			 		
			 @Test  (priority=31)
			 public static void ExemptTaxFromCompany() throws InterruptedException, AWTException, IOException{
				 SettingsScenarios.AddAddress();
				 CompanyScenarios.ExemptTax();
			 }
			 
			 @Test  (priority=32)
			 public static void CreateOrder() throws InterruptedException, AWTException, IOException{
				 CompanyScenarios.CreateOrder();
			 }
		
			 @Test  (priority=33, dependsOnMethods = { "CreateOrder" })
			 public static void DeleteCompanywithOrder() throws InterruptedException, AWTException, IOException{
				 CompanyScenarios.DelOrderCompany();
			 }
			
			 @Test  (priority=34)
			 public static void InactiveCompAndVerifyNotShowingIn_ActiveFilter() throws InterruptedException, AWTException, IOException{
				 
				 CompanyScenarios.InactiveCompany(true);
			 }
			
			 @Test  (priority=35)
			 public static void InactiveContAndVerifyNotShowingIn_ActiveFilter() throws InterruptedException, AWTException, IOException{
				 
				 CompanyScenarios.InactiveCompany(false);
			 }
 	
 			 @Test  (priority=36)
			 public static void CreateContactFromMain() throws InterruptedException, AWTException, IOException{
				 
 				ContactScenarios.CreateContact(false);
			 	}
							
			 @Test  (priority=37)
			 public static void CreateNoteFromMain() throws InterruptedException, AWTException, IOException{
				 
				 Notes.AddNoteFromMain();
			 	}
	
			 @Test  (priority=38)
			 public static void CreateTaskFromMain() throws InterruptedException, AWTException, IOException{
				 
				 Tasks.AddTaskFromMain();
			 	}
			 		 
			 @Test  (priority=39)
			 public static void VerifyCompanyFilter() throws InterruptedException, AWTException, IOException{
				 
				 Filters.VerifyFilters(true);
			 	}
			 @Test  (priority=40)
			 public static void VerifyContactFilter( ) throws InterruptedException, AWTException, IOException{
				 
				 Filters.VerifyFilters(false);
			 	}

			 @Test  (priority=41)
			 public static void CreateAndDeleteComp() throws InterruptedException, AWTException, IOException{
				 
				 CompanyScenarios.CreateCompanyFromMain();
			 }
			
			 @Test  (priority=42)
			 public static void AddContactInCompany() throws InterruptedException, AWTException, IOException{
				 
				 CompanyScenarios.AddContactToCompany();
			 }
			 
			 @Test  (priority=43)
			 public static void ChangeCompaniesRecordOwnerFromDashBoard() throws InterruptedException, AWTException, IOException{
				 
				 RecordOwnerAndVisi.UpdateRecordOwn();
			 }
		
			 @Test  (priority=44)
			 public static void ChangeCompaniesVisibilityFromDashBoard() throws InterruptedException, AWTException, IOException{
				 
				 RecordOwnerAndVisi.UpdateVisibility();
			 }
		
			 @Test  (priority=45)
			 public static void InactiveCompanyFromDashBoard() throws InterruptedException, AWTException, IOException{
				 
				 CompanyScenarios.InactiveCompFromDBoard();
			 }
		
			 @Test  (priority=46)
			 public static void DeleteInactiveCompany() throws InterruptedException, AWTException, IOException{
				 
				 CompanyScenarios.DeleteComp();
			 }
			  
			 @Test  (priority=47)
			 public static void AddAddressUnderSettings() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.AddAddress();
			 	}
			 
			 @Test  (priority=48)
			 public static void DeleteAddressUnderSettings() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.DeleteAddress();
			 	}

			 @Test  (priority=49)
			 public static void CreateRelationship() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.CreateRelationship();
			 	}
		  
			 @Test  (priority=50)
			 public static void DeleteRelationship() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.DeleteRelationship();
			 	}
		
			 @Test  (priority=51)
			 public static void CreateTeam() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.AddTeam();
			 	}
 		
			 @Test  (priority=52)
			 public static void DeleteTeam() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.DeleteTeam();

			 }
			 
			 @Test  (priority=53)
			 public static void CreateRelationshipBtCompAndContact() throws InterruptedException, AWTException, IOException{
				 
				 SettingsScenarios.CreateRelationshipBetweenCompCont();
			 	}
			 
	
			 @Test  (priority=54)
			 public static void ExportCompanyCSV() throws InterruptedException, AWTException, IOException{
			 ExportScenarios.ExortCSV();
			 	  
			}
		 
		 	@Test  (priority=55)
		 	public static void ExportCompanyQB() throws InterruptedException, AWTException, IOException{
			ExportScenarios.ExportCompanyQB();
			 	  
		 	}
		
		 	@Test  (priority=56)
		 	public static void ExportContactCSV() throws InterruptedException, AWTException, IOException{
			ExportScenarios.ExportContactCSV();
			 	  
		 	}

		 	@Test  (priority=57)
		 	public static void ExportoVcard() throws InterruptedException, AWTException, IOException{
			ExportScenarios.ExportoVcard();
			 	  
		 	}
		 
		 	@Test  (priority=58)
		 	public static void AddTaskatAppointmentPage() throws InterruptedException, AWTException, IOException{
			Tasks.TaskFromAppointment();
			 	  
		 	}
	
		 @Test  (priority=59)
		 	public static void MoveEmailToSpam() throws InterruptedException, AWTException, IOException{
				Email.MoveEmailToSpam();
			 	  
		 	}
	
		 @Test  (priority=60)
		 	public static void DeleteEmailFromAllEmail() throws InterruptedException, AWTException, IOException{
				Email.DeleteEmailFromAllEmail();
			 	  
		 	}
		 
	 @Test  (priority=61)
		 	public static void MoveEmailToSpamFromDetailPage() throws InterruptedException, AWTException, IOException{
				Email.MoveEmailToSpamFromDetailPage();
			 	  
		 	}
		
		 @Test  (priority=62)
		 	public static void DeleteEmailFromEmailDetailPage() throws InterruptedException, AWTException, IOException{
				Email.DeleteEmailFromEmailDetailPage();
			 	  
		 	}
	
		 @Test  (priority=63)
		 	public static void MoveEmailToNotSpam() throws InterruptedException, AWTException, IOException{
				Email.MoveEmailToNotSpam();
			 	  
		 	}
		 @Test  (priority=64)
		 	public static void DeleteEmailFromSpam() throws InterruptedException, AWTException, IOException{
			 Email.DeleteEmailFromAllEmail();
			 	  
		 	}
		 

		 @Test  (priority=65)
		 	public static void CreateDefaultTask() throws InterruptedException, AWTException, IOException{
				Tasks.CreateDefaultTask();
			 	  
		 	}
		 
		 @Test  (priority=66)
		 	public static void VerifyDefaultTask() throws InterruptedException, AWTException, IOException{
				Tasks.VerifyDefaultTask();
			 	  
		 	}

		 @Test  (priority=67)
		 	public static void DeleteDefaultTask() throws InterruptedException, AWTException, IOException{
				Tasks.DeleteDefaultTask();
			 	  
		 	}
	
			 @AfterMethod

			public void getResult(ITestResult result) throws IOException, InterruptedException{
				 //System.out.println(result.getStatus());
				if(result.getStatus()==ITestResult.SUCCESS){
	 				test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case is Passed", ExtentColor.GREEN));
	 				test.log(Status.PASS, " Please see attached screenshot");
	 				String screenshotPath = HelpingFunction.capture(result.getName());
		 			test.addScreenCaptureFromPath(screenshotPath);
		 			extent.flush();
		 			
	 				}

	 			
	 			if(result.getStatus()==ITestResult.FAILURE){
				 	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
				 	String screenshotPath = HelpingFunction.capture(result.getName());
				 	test.addScreenCaptureFromPath(screenshotPath);
			 		test.fail(result.getThrowable());
			 		extent.flush();
			 		}
				
	 			
	 			if(result.getStatus()==ITestResult.SKIP){
	 				System.out.print("Test cases is skipped");
					 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
					 test.skip(result.getThrowable());
					 extent.flush();
				    }				 		
	 			
			 }
			 
			@AfterTest
			public void endReport(){
			
				driver.get(System.getProperty("user.dir")+"/Reports/CRMReport.html");
			}
			
		

}
