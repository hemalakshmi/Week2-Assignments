package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

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
		
		//Enter the Company name that you have given in CreateLead assignment
		driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("Testleaf");
		//Click on Find Leads using xpath Locator and click on the first result
		driver.findElementByXPath("//button[text()=\"Find Leads\"]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		//Click on the edit Button
		driver.findElementByXPath("//a[text()='Edit']").click();
		//Get the Text of Company Name and Print
		String compName=driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").getAttribute("value");
		System.out.println("Company Name: " + compName);
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").clear();
		
		//Update the Company name with new value
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys("NewTestleaf5");
		//Click the Update button and verify the updated name
		driver.findElementByXPath("//input[@value='Update']").click();

		String text2=driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println("Updated Company Name:" + text2);
		driver.close();
		
	}

}
