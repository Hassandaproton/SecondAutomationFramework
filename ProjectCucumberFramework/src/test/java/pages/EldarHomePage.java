package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EldarHomePage {
    WebDriver driver;

    public EldarHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='side-link-yards']")
    public WebElement yardPanelLinkBtn;

    @FindBy(xpath = "//a[@class='side-link-company']")
    public WebElement companyPanelBtn;


    @FindBy(xpath = "//a[@class='link-btm-menu']")
    public WebElement addCompanyBtn;
}