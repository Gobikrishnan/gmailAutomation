package Definitions;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	WebDriver driver;

	@Before
	public void TestSetup() {
		driver = new FirefoxDriver();
	}

	@After
	public void TestShutdown() {
		driver.quit();
	}

	@Given("^I navigate to \"([^\"]*)\"$")
	public void navigateGmail(String address) throws Exception {
		driver.navigate().to(address);
		driver.manage().window().maximize();
	}

	@And("^I enter username \"([^\"]*)\"$")
	public void enterUsername(String userName) throws Exception {
		driver.findElement(By.id("Email")).sendKeys(userName);
	}

	@Then("^I click next button$")
	public void clickNextButton() throws Exception {
		driver.findElement(By.id("next")).click();
	}

	@Then("^I enter password \"([^\"]*)\"$")
	public void enterPassword(String password) throws Exception {

		driver.findElement(By.id("Passwd")).sendKeys(password);
	}

	@When("^I click signin button$")
	public void clickSingInButton() throws Exception {
		driver.findElement(By.id("signIn")).click();

	}

	@Then("^I wait for five sec$")
	public void pagewaitFive() throws Exception {
		Thread.sleep(5000);
		System.out.println("Done 5000");
	}

	@Then("^I wait for sometime$")
	public void pagewaitNine() throws Exception {
		Thread.sleep(9000);
		System.out.println("Done 9000");
	}

	@Given("^I logged as \"([^\"]*)\"$")
	public void loggedinAs(String userName) throws Exception {
		WebElement element = driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div/div[4]/div[1]/a"));
		String title = element.getAttribute("title");
		Assert.assertEquals(title, "Google Account: gobikrishnan0010@gmail.com");
		System.out.println("Title :" + title);
	}

	@Then("^i must be in \"([^\"]*)\"$")
	public void checkInboxPage(String myCurrentUrl) throws Exception {
		String userCurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(userCurrentUrl, myCurrentUrl);
		System.out.println("Current :" + userCurrentUrl);
	}

	@Then("^I cick on compose button$")
	public void clickComposeButton() throws Exception {
		System.out.println("Start compose");
		driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div"))
				.click();
		System.out.println("Done compose");
	}

	@Then("^I add recption email as \"([^\"]*)\"$")
	public void addRecptionAddress(String emailId) throws Exception {
		driver.findElement(By.className("vO")).sendKeys(emailId);
	}

	@And("^I add subject as \"([^\"]*)\"$")
	public void addSubject(String subject) throws Exception {
		driver.findElement(By.className("aoT")).sendKeys(subject);
	}

	@And("^I add email message as \"([^\"]*)\"$")
	public void addBody(String bodyMessage) throws Exception {

		driver.findElement(By.className("Am")).sendKeys(bodyMessage);

	}

	@Then("^i click on send button$")
	public void clickOnSendButton() throws Exception {
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
	}

	@Then("^i navigate to sent mail page$")
	public void navigateToSentMail() throws Exception {
		driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
	}

	@Then("^I check last sent subject \"([^\"]*)\"$")
	public void checkSentMailSubject(String sentMailSubject) throws Exception {
		WebElement element = driver.findElement(By.xpath(
				"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div[4]/div[1]/div/table/tbody/tr/td[6]/div/div/div/span[1]"));
		String title = element.getText();
		System.out.println("Title :" + title);

	}

	@Then("^I logout from gmail$")
	public void logout() throws Exception {
				driver.findElement(
				By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div/div[4]/div[1]/a"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.className("gb_nd")).click(); // To click the sign
															// out button
	}

	@And("^I check that I have logged out$")
	public void checkLogout() throws Exception {
		driver.findElement(By.id("Passwd"));
	}

}
