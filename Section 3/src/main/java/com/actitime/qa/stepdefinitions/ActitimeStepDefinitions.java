package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class ActitimeStepDefinitions extends TestBase {


	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;
	String sheetName = "Users";
	TestUtil testUtil;
	Logger log = Logger.getLogger(this.getClass());


	@Given("^User in the Actitime Loging Page")
	public void user_in_the_Actitime_Loging_Page() throws Throwable {

		initialization();
		loginPage = new LoginPage();
	}

	@When("^User Enter the User Name as  \"([^\"]*)\"$")
	public void user_Enter_the_User_Name_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^User Enter the Password as  \"([^\"]*)\"$")
	public void user_Enter_the_Password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User click in Loging button")
	public void user_click_in_Loging_button() throws Throwable {
		homePage =loginPage.clickSubmitButton();
	}

	@Then("^User should be able to successfuly loging to Actitime")
	public void user_should_be_able_to_successfuly_loging_to_Actitime() throws Throwable {

		homePage.validateActiTimeLogo();
		driver.quit();

	}

	@Given("^User is logged in as an admin")
	public void user_is_logged_in_as_an_admin() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		homePage = loginPage.clickSubmitButton();
	}

	@Given("^User in the Actitime Users Page$")
	public void user_in_the_Actitime_Users_Page() throws Throwable {
		usersPage = homePage.clickOnUsersLink();
	}

	@When("^User clicks the new user button$")
	public void user_clicks_the_new_user_button() throws Throwable {
		usersPage.clickNewUserButton();
	}

	@And("^User Enter the First Name as  \"([^\"]*)\"$")
	public void user_Enter_the_First_Name_as(String firstName) throws Throwable {
		usersPage.enterFirstName(firstName);
	}

	@And("^User Enter the Last Name as  \"([^\"]*)\"$")
	public void user_Enter_the_Last_Name_as(String lastName) throws Throwable {
		usersPage.enterLastName(lastName);
	}

	@And("^User Enter the Email as  \"([^\"]*)\"$")
	public void user_Enter_the_Email_as(String email) throws Throwable {
		usersPage.enterEmail(email);
	}

	@And("^User clicks the Save & Send Invitation button")
	public void user_Clicks_the_Save_and_Send_Invitation_Button() throws Throwable {
		usersPage.clickCreateUserLink();
	}

	@Then("User should be created successfully with first name {string} and last name {string}")
	public void user_created_successfully(String firstName, String lastName) {
		String userCreationMessage = usersPage.getUserCreationMessage();
		String validationMessage = "Account for " + firstName + " " + lastName + " has been created.";

		try {
			Assert.assertEquals(userCreationMessage, validationMessage);
			log.info("User created successfully with first name " + firstName + " and last name " + lastName);
		} catch (AssertionError error) {
			log.fatal("User creation failed");
			Assert.fail();
		}
	}
}
