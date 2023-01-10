package org.stepdefinition;

import java.util.Map;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSignin extends BaseClass {
	@Given("To launch the chrome browser and maximize the window")
	public void toLaunchTheChromeBrowserAndMaximizeTheWindow() {
		LaunchBrowser();
		windowMaximize();
	}

	@When("To launch the url")
	public void toLaunchTheUrl() {
		LaunchUrl("https://www.amazon.com/");
	}

	@When("To click the account and list btn")
	public void toClickTheAccountAndListBtn() {
		WebElement ac = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		ac.click();
	}

	@When("To hit the mobile no or email id")
	public void toHitTheMobileNoOrEmailId(io.cucumber.datatable.DataTable d) {
		Map<String, String> m = d.asMap(String.class, String.class);
		WebElement mno = driver.findElement(By.id("ap_email"));
		mno.sendKeys(m.get("email2"));
	}

	@When("To click the continue btn")
	public void toClickTheContinueBtn() {
		WebElement cntue = driver.findElement(By.id("continue"));
		cntue.click();
	}

	@When("To check the credentials")
	public void toCheckTheCredentials() {
		System.out.println("To check the credentials....");
	}

	@Then("To close the browser")
	public void toCloseTheBrowser() {
		CloseBrowser();
	}

}
