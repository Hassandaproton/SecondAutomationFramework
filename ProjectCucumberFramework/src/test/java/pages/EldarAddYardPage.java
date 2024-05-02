package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EldarAddYardPage {
    WebDriver driver;

    public EldarAddYardPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "yard_location")
    public WebElement name;

    @FindBy(className = "select-form border disabled-user active")
    public WebElement statusDropDown;

    @FindBy(id = "id_address")
    public WebElement street;

    @FindBy(id = "id_apt_suite_company_co")
    public WebElement apt_suit;

    @FindBy(id = "id_city")
    public WebElement city;

    @FindBy(xpath = "(//optgroup[@class='choises'])[2]")
    public WebElement stateDropdown;

    @FindBy(id = "8924")
    public WebElement zip;

    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement errorMsg2;

    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement errorMsg1;

    @FindBy(name = "state" )
    public WebElement state;
}