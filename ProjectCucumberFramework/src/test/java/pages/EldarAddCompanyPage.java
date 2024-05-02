package pages;

import io.cucumber.java.zh_cn.那么;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.temporal.WeekFields;
import java.util.List;

public class EldarAddCompanyPage {
    WebDriver driver;

    public EldarAddCompanyPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy(name = "company_name")
    public WebElement name;

    @FindBy(name = "mc_number")
    public WebElement mcNumber;

    @FindBy(name = "dot_number")
    public WebElement dotinput;

    @FindBy(xpath = "//select[@name='ifta']")
    public WebElement ifta;

    @FindBy(xpath = "(//option[contains(text(),'No')])[2]")
    public WebElement noChoiceIfta;

    @FindBy(xpath = "(//option[contains(text(),'Yes')])[2]")
    public WebElement yesChoiceIfta;

    @FindBy(xpath ="//html/body/div/div/main/div/div/div[3]/form/div//div/div[2]/p[3]/span/span//select/optgroup/option")
    public List<WebElement> choicesIfta;

    @FindBy(xpath = "(//input[@class='input-phone input-form border disabled-company'])[1]")
    public WebElement phone;

    @FindBy(name = "address")
    public WebElement street;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "state")
    public WebElement stateBtn;

    @FindBy(xpath = "//html/body/div/div/main/div/div/div[3]/form/div/div/div[3]/div[3]/p[4]/span/span/select")
    public WebElement stateChoices;

    @FindBy(name = "zip_code")
    public WebElement zip;

    @FindBy(xpath = "//input[@class='input-form disabled-not-ext border disabled-company lowercase']")
    public WebElement email;

    @FindBy(name = "insurance")
    public WebElement insuranceName;

    @FindBy(xpath = "(//span[@class='border disabled-trailer date-wrapper'])[2]")
    public WebElement policyExpirationBtn;

    @FindBy(xpath = "//li[@class='calendar-day']")
    public List<WebElement> calenderDays;

    @FindBy(name = "policy_number")
    public WebElement policyNumber;

    @FindBy(name = "employer_id_num")
    public WebElement employeeIDNum;

    @FindBy(xpath = "//button[@class='confirm-save']")
    public WebElement addCompanyBtn;

    @FindBy(xpath = "(//span[@class='input-errors'])[1]")
    public WebElement errorMsg1;

    @FindBy(name = "mc_number")
    public WebElement mcInput;

    //html/body/div/div/main/div/div/div[3]/form/div/div/div[4]/p[2]/span/span/input
    @FindBy(xpath = "(//span[@class='border disabled-trailer date-wrapper'])[1]")
    public WebElement policyEffectiveDay;

    @FindBy(name = "type_of_insurance")
    public WebElement typeOfInsurance;

    @FindBy(name = "automobile_liability")
    public WebElement automobileLiability;

    @FindBy(name = "num_of_truck_insured")
    public WebElement numOfTrucksInsured;




}
