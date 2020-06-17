package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
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
		// Click on Create Leads
		driver.findElementByLinkText("Create Lead").click();
		
		//Enter Company Name Field Using Xpath Locator
		WebElement eleCompanyname = driver.findElementByXPath("//input[@id='createLeadForm_companyName']");
		eleCompanyname.sendKeys("Testleaf");
		//Enter First Name Field Using Xpath Locator
		WebElement eleFirstname = driver.findElementByXPath("//input[@id='createLeadForm_firstName']");
		eleFirstname.sendKeys("Hema");
		//Enter Last Name Field Using Xpath Locator
		WebElement eleLastname = driver.findElementByXPath("//input[@id='createLeadForm_lastName']");
		eleLastname.sendKeys("M");
		//Select Source as Employee using SelectByValue
		WebElement eleSource = driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']");
		Select dd=new Select(eleSource);
		dd.selectByValue("LEAD_EMPLOYEE");
		//Enter value for AnnualRevenue Field using Xpath Locator
		WebElement eleAnnualRevenue = driver.findElementByXPath("//input[@id='createLeadForm_annualRevenue']");
		eleAnnualRevenue.sendKeys("300000");
		//Select Industry as ComputerSoftware
		WebElement eleIndustryEnum = driver.findElementByXPath("//select[@id='createLeadForm_industryEnumId']");
		eleIndustryEnum.sendKeys("Computer Software");
		//Select OwnerShip as S-Corporation using SelectByVisibletext
		WebElement eleOwnership = driver.findElementByXPath("//select[@id='createLeadForm_ownershipEnumId']");
		Select ss=new Select(eleOwnership);
		ss.selectByVisibleText("S-Corporation");
		// Enter Description 
		WebElement eleDescription = driver.findElementByXPath("//textarea[@id='createLeadForm_description']");
	    eleDescription.sendKeys("Selenium Automation Tester");
	    //Select Marketing Campaign
	    WebElement eleMarketingCamp = driver.findElementByXPath("//select[@id='createLeadForm_marketingCampaignId']");
	    Select mm=new Select(eleMarketingCamp);
		mm.selectByIndex(6);
		//Select State/Province
		WebElement eleState = driver.findElementByXPath("//select[@id='createLeadForm_generalStateProvinceGeoId']");
		Select pp=new Select(eleState);
		pp.selectByValue("TX");
		// Enter E-Mail Address 
		WebElement eleEmail = driver.findElementByXPath("//input[@id='createLeadForm_primaryEmail']");
	    eleEmail.sendKeys("abacad@gmail.com");
	    //Enter Phone Number
	    WebElement elePhoneNo = driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneNumber']");
	    elePhoneNo.sendKeys("9747474889");
	    
	    //Click Create Lead button using Xpath Locator
		driver.findElementByXPath("//input[@name='submitButton']").click();

		String text=driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		System.out.println("Company Name: " + text);
		driver.close();

	}

}
