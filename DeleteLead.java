package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL 
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
        //Enter UserName and Password Using Id Locator
		WebElement eleUsername = driver.findElementById("username");
		eleUsername.sendKeys("demosalesmanager");
		WebElement elePassword = driver.findElementById("password");
		elePassword.sendKeys("crmsfa");
		//Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();
		
        //Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();
		
        //Click on Leads Button
		driver.findElementByLinkText("Leads").click();
		//Click on Find Leads
		driver.findElementByLinkText("Find Leads").click();
		
		//Click on Email and Enter the Email that you have given in CreateLead assignment
		driver.findElementByLinkText("Email").click();
		WebElement eleEmailAdd = driver.findElementByXPath("//input[@name='emailAddress']");
		eleEmailAdd.sendKeys("abacad@gmail.com");
		//Click on Find Leads using xpath Locator 
		driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
		Thread.sleep(3000);
		
		//Get the first result LeadId in a variable and click on it
		  String leadID = driver.findElementByXPath("(//a[@class='linktext'])[4]").getText();
		  System.out.println("Lead ID: " + leadID);
		  driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//Click on the Delete Button
		  driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		 
		
		//Click on Find Leads 
		  driver.findElementByLinkText("Find Leads").click();
		  Thread.sleep(3000);
		  //Enter the Deleted LeadID and click Find Leads
		  driver.findElementByXPath("(//span[text()='Advanced']/following::input)[1]").sendKeys(leadID);
		  driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		  //Verify the "No records to display" message.
		  String text1=driver.findElement(By.xpath("(//button[@class='x-btn-text'])[8]/following::div[1]")).getText();
		  System.out.println("No records found  " + text1);
			 
		  driver.close();
		
		
		
	}

}
