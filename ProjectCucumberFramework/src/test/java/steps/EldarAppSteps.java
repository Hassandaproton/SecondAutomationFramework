package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.cy_gb.Ond;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EldarAppSteps {
    WebDriver driver = Driver.getDriver();
    EldarAddYardPage eldarAddYardPage = new EldarAddYardPage();
    EldarHomePage eldarHomePage = new EldarHomePage();
    EldarLoginPage eldarLoginPage = new EldarLoginPage();
    EldarYardListPage eldarYardListPage = new EldarYardListPage();
    EldarAddCompanyPage eldarAddCompanyPage = new EldarAddCompanyPage();
    List<Map<String, Object>> data;
    Random random = new Random();


    @Given("user navigates to EldarApp")
    public void user_navigates_to_eldar_app() {
        driver.get(ConfigReader.getProperty("eldarUrl"));
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String user, String pass) {
        eldarLoginPage.loginEldar(user, pass);
    }


    @When("user clicks on Company List icon")
    public void user_clicks_on_company_list_icon() {
        BrowserUtils.waitForElementToBeClickable(eldarHomePage.companyPanelBtn, 3);
        eldarHomePage.companyPanelBtn.click();
    }

    @When("user clicks on Add Company button")
    public void user_clicks_on_add_company_button() {
        eldarHomePage.addCompanyBtn.click();
    }
//    @When("user inputs eleven characters {string}")
//    public void user_inputs_eleven_characters(String string) {
//    }
//
//    @Then("user validates only ten characters appear {string}")
//    public void user_validates_only_ten_characters_appear(String string) {
//    }

    @When("user clicks on IFTA field")
    public void user_clicks_on_ifta_field() {
        eldarAddCompanyPage.ifta.click();
    }


    @Then("user identifies {int} options no {string} and yes {string}")
    public void user_identifies_options_no_and_yes(Integer numberOfChoices, String noSelect, String yesSelect) {
        int actualResult = 0;


        for (WebElement choice : eldarAddCompanyPage.choicesIfta) {
            actualResult++;
        }

        eldarAddCompanyPage.ifta.click();
        String actualNo = eldarAddCompanyPage.noChoiceIfta.getText();
        String actualYes = eldarAddCompanyPage.yesChoiceIfta.getText();


        Assert.assertEquals(noSelect, actualNo);
        Assert.assertEquals(yesSelect, actualYes);
        Assert.assertEquals(numberOfChoices, Integer.valueOf(actualResult));
        System.out.println(actualNo);
        System.out.println(actualYes);
        System.out.println(actualResult);
    }

//    @When("user clears the field")
//    public void user_clears_the_field() throws InterruptedException {
//       eldarAddCompanyPage.ifta.sendKeys(Keys.CLEAR);
//       eldarAddCompanyPage.ifta.click();
//       Thread.sleep(2000);
//    }
//    @Then("user validates that value no or yes appears")
//    public void user_validates_that_value_no_or_yes_appears(io.cucumber.datatable.DataTable dataTable) {
//        List<String> data = dataTable.asList();
//        String actual = "";
//        for (String el:data){
//            if (eldarAddCompanyPage.ifta.getText().contains(el)){
//                actual = el;
//                break;
//            }
//        }
//        Assert.assertEquals(eldarAddCompanyPage.iftaField.getText(),actual);
//
//    }


    @When("user clicks on DOT field")
    public void user_clicks_on_dot_field() {
        eldarAddCompanyPage.dotinput.click();
    }

    @When("user inputs {string}")
    public void user_inputs(String string) {
        eldarAddCompanyPage.dotinput.sendKeys(string);

    }

    @Then("validates that {string} appears")
    public void validates_that_appears(String string) {
        System.out.println(eldarAddCompanyPage.dotinput.getAttribute("value"));
        Assert.assertEquals(string, eldarAddCompanyPage.dotinput.getAttribute("value"));
    }

    @Then("validates that error message {string} appears")
    public void validatesThatErrorMessageAppears(String errormsg) {
        Assert.assertEquals(errormsg, eldarAddCompanyPage.errorMsg1.getText());
    }


    @When("user inputs one character {string}")
    public void user_inputs_one_character(String string) {
        eldarAddCompanyPage.dotinput.sendKeys(string);

    }


    @When("user clears the input")
    public void user_clears_the_input() {
        eldarAddCompanyPage.mcInput.click();
        eldarAddCompanyPage.dotinput.sendKeys(Keys.BACK_SPACE);


    }

    @Then("user validates error message {string} appears")
    public void user_validates_error_message_appears(String string) {
        BrowserUtils.waitForTextToBePresent(eldarAddCompanyPage.errorMsg1, string);
        Assert.assertEquals(string, eldarAddCompanyPage.errorMsg1.getText());
    }


    @When(": user inputs data {string} into MC field")
    public void user_inputs_data_into_mc_field(String data) {
        eldarAddCompanyPage.mcNumber.sendKeys(data);
    }

    @Then(": user validates the correct output {string} appears")
    public void user_validates_the_correct_output_appears(String output) {
        if (eldarAddCompanyPage.mcNumber.getAttribute("value").length() > 3) {
            Assert.assertEquals(eldarAddCompanyPage.mcNumber.getAttribute("value"), output);
        } else {
            Assert.assertEquals(eldarAddCompanyPage.errorMsg1.getText(), output);
        }
    }

    @When("user deletes the data in MC field")
    public void user_deletes_the_data_in_mc_field() throws InterruptedException {
        eldarAddCompanyPage.mcNumber.sendKeys(Keys.BACK_SPACE);
    }


    @Then(": user verifies error {string} appears")
    public void user_verifies_error_appears(String error) {
        Assert.assertEquals(eldarAddCompanyPage.errorMsg1.getText(), error);
    }

    @And("user input {string} into DOT field")
    public void userInputIntoDOTField(String arg0) throws InterruptedException {
        eldarAddCompanyPage.dotinput.sendKeys(arg0);
        Thread.sleep(4000);

    }

    @Then("user validates the if error msg appears {string}")
    public void userValidatesTheIfErrorMsgAppears(String arg0) {
        Assert.assertEquals(arg0, eldarAddCompanyPage.errorMsg1.getText());
    }


    @When("user creates a company with test data and using random numbers for MC and DOT inputs")
    public void user_creates_a_company_with_test_data_and_using_random_numbers_for_mc_and_dot_inputs(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        data = dataTable.asMaps(String.class, Object.class);
        int min = 100000;
        int max = 10000000;

        int mcInput = random.nextInt(max - min + 1) + min;
        ;
        int dotInput = random.nextInt(max - min + 1) + min;
        ;
        eldarAddCompanyPage.name.sendKeys(data.get(0).get("Name").toString() + String.valueOf(dotInput));

        eldarAddCompanyPage.mcInput.sendKeys(String.valueOf(mcInput));

        eldarAddCompanyPage.dotinput.sendKeys(String.valueOf(dotInput));

        eldarAddCompanyPage.phone.sendKeys(data.get(0).get("Phone").toString());

        eldarAddCompanyPage.street.sendKeys(data.get(0).get("Street").toString());

        eldarAddCompanyPage.city.sendKeys(data.get(0).get("City").toString());

        BrowserUtils.selectOptionByVisibleText(eldarAddCompanyPage.stateChoices, data.get(0).get("State").toString());

        eldarAddCompanyPage.zip.sendKeys(data.get(0).get("Zip code").toString());
        eldarAddCompanyPage.email.sendKeys(data.get(0).get("Email").toString());
        eldarAddCompanyPage.insuranceName.sendKeys(data.get(0).get("Insurance(producer company name)").toString());
        eldarAddCompanyPage.policyExpirationBtn.click();
        for (WebElement day : eldarAddCompanyPage.calenderDays) {
            if (day.getText().contains(data.get(0).get("Calender Day").toString())) {
                day.click();
                break;
            }
        }
        eldarAddCompanyPage.policyExpirationBtn.click();
        eldarAddCompanyPage.policyNumber.clear();
        eldarAddCompanyPage.policyNumber.sendKeys(data.get(0).get("Policy number").toString());
        eldarAddCompanyPage.employeeIDNum.sendKeys(data.get(0).get("Employer id number").toString());
        eldarAddCompanyPage.addCompanyBtn.click();
        Thread.sleep(5000);

        driver.navigate().refresh();
        eldarHomePage.companyPanelBtn.click();
        Thread.sleep(30000);

        eldarHomePage.addCompanyBtn.click();
        Thread.sleep(5000);

        eldarAddCompanyPage.dotinput.sendKeys(String.valueOf(dotInput));


    }


    @Then("user verifies that the error message {string} appears")
    public void user_verifies_that_the_error_message_appears(String expectedErrorMsg) {
        Assert.assertEquals(expectedErrorMsg, eldarAddCompanyPage.errorMsg1.getText());
    }


    @When("user creates a company with test data.")
    public void user_creates_a_company_with_test_data(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        data = dataTable.asMaps(String.class, Object.class);
        int min = 100000;
        int max = 10000000;

        int mcInput = random.nextInt(max - min + 1) + min;
        ;
        int dotInput = random.nextInt(max - min + 1) + min;
        ;
        eldarAddCompanyPage.name.sendKeys(data.get(0).get("Name").toString() + String.valueOf(mcInput));

        eldarAddCompanyPage.mcInput.sendKeys(String.valueOf(mcInput));

        eldarAddCompanyPage.dotinput.sendKeys(String.valueOf(dotInput));

        eldarAddCompanyPage.phone.sendKeys(data.get(0).get("Phone").toString());

        eldarAddCompanyPage.street.sendKeys(data.get(0).get("Street").toString());

        eldarAddCompanyPage.city.sendKeys(data.get(0).get("City").toString());

        BrowserUtils.selectOptionByVisibleText(eldarAddCompanyPage.stateChoices, data.get(0).get("State").toString());

        eldarAddCompanyPage.zip.sendKeys(data.get(0).get("Zip code").toString());
        eldarAddCompanyPage.email.sendKeys(data.get(0).get("Email").toString());
        eldarAddCompanyPage.insuranceName.sendKeys(data.get(0).get("Insurance(producer company name)").toString());
        eldarAddCompanyPage.policyExpirationBtn.click();
        for (WebElement day : eldarAddCompanyPage.calenderDays) {
            if (day.getText().contains(data.get(0).get("Calender Day").toString())) {
                day.click();
                break;
            }
        }
        eldarAddCompanyPage.policyExpirationBtn.click();
        eldarAddCompanyPage.policyNumber.clear();
        eldarAddCompanyPage.policyNumber.sendKeys(data.get(0).get("Policy number").toString());
        eldarAddCompanyPage.employeeIDNum.sendKeys(data.get(0).get("Employer id number").toString());
        eldarAddCompanyPage.addCompanyBtn.click();
        Thread.sleep(5000);

        driver.navigate().refresh();
        eldarHomePage.companyPanelBtn.click();
        Thread.sleep(30000);

        eldarHomePage.addCompanyBtn.click();
        Thread.sleep(5000);

        eldarAddCompanyPage.mcInput.sendKeys(String.valueOf(mcInput));


    }


    @Then("user verifies that using the same data for mc input will make the error message {string} appear")
    public void user_verifies_that_using_the_same_data_for_mc_input_will_make_the_error_message_appear(String expectedErrorMsg) {
        Assert.assertEquals(expectedErrorMsg, eldarAddCompanyPage.errorMsg1.getText());

    }


    @When("user inputs data {string} into the insurance field")
    public void user_inputs_data_into_the_insurance_field(String testData) {
        eldarAddCompanyPage.insuranceName.sendKeys(testData);
    }

    @Then("user identifies output expectation {string} in insurance field")
    public void user_identifies_output_expectation_in_insurance_field(String expectedResult) {
       Assert.assertEquals(expectedResult,eldarAddCompanyPage.insuranceName.getAttribute("value"));
    }

    @When("user clears the insurance input field")
    public void user_clears_the_insurance_input_field() {
        eldarAddCompanyPage.insuranceName.sendKeys(Keys.BACK_SPACE);

    }
    @Then("user validates data {string} appears in the insurance field")
    public void user_validates_data_appears_in_the_insurance_field(String string) {
        Assert.assertEquals(string,eldarAddCompanyPage.insuranceName.getAttribute("value"));
    }

    @When("user clicks on Policy effective day field and selects the day {string}")
    public void user_clicks_on_policy_effective_day_field_and_selects_the_day(String day) throws InterruptedException {
        eldarAddCompanyPage.policyEffectiveDay.click();
        for (WebElement days : eldarAddCompanyPage.calenderDays){
            if (days.getText().equals(day)) days.click();
        }
        eldarAddCompanyPage.policyEffectiveDay.click();
        Thread.sleep(5000);

    }

    @Then("user identifies the selected date {string} appears in the Policy effective day field")
    public void user_identifies_the_selected_date_appears_in_the_policy_effective_day_field(String expected) {
        Assert.assertEquals(expected, eldarAddCompanyPage.policyEffectiveDay.getAttribute("value"));
    }

    @When("user inputs data {string} into the type of insurance field")
    public void user_inputs_data_into_the_type_of_insurance_field(String data) {
        eldarAddCompanyPage.typeOfInsurance.sendKeys(data);
    }

    @Then("user identifies output expectation {string} in type of insurance field")
    public void user_identifies_output_expectation_in_type_of_insurance_field(String expected) {
        Assert.assertEquals(expected,eldarAddCompanyPage.typeOfInsurance.getAttribute("value"));
    }

    @When("user inputs data {string} into type of insurnace field")
    public void user_inputs_data_into_type_of_insurnace_field(String data) {
        eldarAddCompanyPage.typeOfInsurance.sendKeys(data);

    }





}