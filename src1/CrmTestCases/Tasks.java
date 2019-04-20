
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class Tasks extends HelpingFunction {
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
							

				public static void AddTask() throws InterruptedException, AWTException, IOException{
					
						 
						 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Click("Please click at Add Task button",GetData.AddTaskButton);
						 Thread.sleep(2000);
						 Input("Please Enter Task Name", GetData.TaskName, CrmTestData.Task);
						
						 System.out.println( CrmTestData.Task);
						 LocalDate localDate = LocalDate.now();
					     System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
					     String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);

						    int ext=abc.lastIndexOf("/");						
						// Get last word
						    TaskCurdat=abc.substring (ext+1);
						    System.out.println(TaskCurdat);
						 Thread.sleep(2000);
						 
						 Click("Click to open celender",GetData.OpenCalender);
						 driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
						 
						 Click("Click to open celender",GetData.MoreDetail);
						 Thread.sleep(3000);
				/*		 Click("Click to open celender",GetData.AdditionalInformation);
	 
						 Select Priority = new Select(GetData.Priority);
						 Priority.selectByVisibleText("High");
						 Select Status = new Select(GetData.TaskStatus);
						 Status.selectByVisibleText("In Progress");*/
						 Click("Please click at Save Task button",GetData.SaveTask);
						 Click("Please click at Open Task Filter",GetData.OpenTaskFilter);
						 Verify(CrmTestData.Task, GetData.VerifyTask.getText(), "Task content is not showing");
						 RefreshPage();
						 Verify(CrmTestData.Task, GetData.VerifyTask.getText(), "Task content is not showing after refresh");

				} 
				public static void VerifyTaskInAppointment() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click to Appointment" ,GetData.Appointment);
					 Thread.sleep(15000);
					 Click("Click to Appointment" ,GetData.MonthView);

					 Thread.sleep(10000);
					 Assert.assertTrue("Task is not showing in month view", driver.findElement(By.id("appointmentsCalendar")).getText().contains(CrmTestData.Task));
/*					 
					 Click("Click to Appointment" ,GetData.WeekView);

					 Thread.sleep(30000);
					 Assert.assertTrue("Task is not showing in Week view", driver.findElement(By.id("appointmentsCalendar")).getText().contains(CrmTestData.Task));
					 
					 Click("Click to Appointment" ,GetData.DayView);
					 Thread.sleep(10000);
					 Assert.assertTrue("Task is not showing in Day view", driver.findElement(By.id("appointmentsCalendar")).getText().contains(CrmTestData.Task));
			 */
		} 

				
				
				public static void EditTask() throws InterruptedException, AWTException, IOException{
					
					 driver.navigate().back();
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Add Task button",GetData.EditTask);
					 Thread.sleep(2000);
					 Input("Please Enter Task Name", GetData.TaskName, CrmTestData.EditTask);
					 Click("Please click at Save Task button",GetData.SaveTask);
					 Click("Please click at Open Task Filter",GetData.OpenTaskFilter);
					 Thread.sleep(4000);
					 Verify(CrmTestData.EditTask, GetData.VerifyTask.getText(), "Task content is not matching");
					

				}
				
				public static void CompleteTask() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Complete Task checkbox",GetData.CompleteTask);
					 Click("Please click at Completed Task Filter",GetData.CompletedTaskFilter);
					 Thread.sleep(5000);
					 Verify(CrmTestData.EditTask, GetData.VerifyTask.getText(), "Completed content is not matching");
					 RefreshPage();
					
					 Click("Please click at Completed Task Filter",GetData.CompletedTaskFilter);

					 Verify(CrmTestData.EditTask, GetData.VerifyTask.getText(), "Completed task content is not showing after refresh");


				}
				
				public static void DeleteTask() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Complete Task checkbox",GetData.DeleteTask);
					 Thread.sleep(5000);
					 Verify("Success", GetData.Success.getText(), "Task content is not matching");
					

				}
					
			  	public static void AddTaskFromMain() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(20000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
					 Click("Please Click Add Task button",GetData.AddTaskButton);
					 Thread.sleep(2000);
					 Input("Please Enter Main Task Name", GetData.TaskName, CrmTestData.MainTask);
					 Thread.sleep(2000);
					 Click("Click to open celender",GetData.OpenCalender);
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
					 Click("Please Click Save Task button",GetData.SaveTask);
					 Input("Please Enter Main task in Search field", GetData.TaskSearchField, CrmTestData.MainTask);
					 Thread.sleep(10000);
					 Verify(CrmTestData.MainTask, GetData.GetMainTaskContent.getText(), "Task content is not matching");
					 
		  			} 
			  	
				public static void TaskFromAppointment() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click to Appointment" ,GetData.Appointment);
					 Click("Click to Appointment" ,GetData.ToggleButton);
					 Click("Please click at Add Task button", GetData.NewTask);

					
					 Thread.sleep(2000);
					 Input("Please Enter Task Name", GetData.TaskName, CrmTestData.Task);
					
					 Thread.sleep(2000);
					 
					 Click("Click to open celender",GetData.OpenCalender);
					 Thread.sleep(2000);
					 LocalDate localDate = LocalDate.now();
				     System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
				     String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);

					    int ext=abc.lastIndexOf("/");						
					// Get last word
					    TaskCurdat=abc.substring (ext+1);
					    System.out.println(TaskCurdat);
					 driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
					 
					 Click("Please click at Save Task button",GetData.SaveTask);
					 Thread.sleep(2000);
					 Verify("Success", GetData.Success.getText(), "Task content is not matching");


				} 
					  	
			  	public static void CreateDefaultTask() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(10000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Click("Please click at Sales Tax",GetData.DefaultTasks);
					 Click("Please Click Add Task button",GetData.AddDefaultTask);
					 Thread.sleep(2000);
					 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.DefaultTask);
					 Thread.sleep(2000); 
					 Click("Please select Due Date",GetData.DefaultTaskDueDate);
					 Click("Please select Due Date",GetData.DefaultTaskSalesOrderCheckbox);
					 Click("Please select Due Date",GetData.SaveAddress);
				//	 Verify(CrmTestData.MainTask, GetData.GetMainTaskContent.getText(), "Task content is not matching");
					 
		  			} 
			  	
			  	public static void VerifyDefaultTask() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(5000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.Orders);
					 Click("Please click at aviator",GetData.CreateOrder);
					 Click("Please click at aviator",GetData.Save);
					 Thread.sleep(20000);
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.DefaultTask));
					
		  			} 
			  	
			  	public static void DeleteDefaultTask() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(20000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.CloseOrder_Icon);
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at aviator",GetData.settings);
					 Click("Please click at Sales Tax",GetData.DefaultTasks);
					 

					 driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DefaultTask+"')]/parent::tr/td[9]/button[2]")).click();

					 Click("Please click at Sales Tax",GetData.ConfirmDel);
					
		  			} 
			  	
			  	
}
