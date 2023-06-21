package pageObject.SparePartsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscsPage {
    private WebDriver driver;

    @FindBy(xpath = "//i[contains(@class, 'expander') and contains(@data-marker, 'category[1000210]/expander')]")
    private WebElement filterDiscButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/ul/li/ul/li[8]/ul/li[2]/ul/li[4]/div/a")
    private WebElement discButton;

    @FindBy(xpath = "//div[@data-marker='item'][1]")
    private WebElement firstAdElement;

    @FindBy(xpath = "//*[@id=\"i2908943030\"]/div/div/div[2]/div[2]/div/a/h3")
    private WebElement titleElement;

    @FindBy(xpath = "//*[@id=\"i2908943030\"]/div/div/div[2]/div[3]/span/div/p/strong/span")
    private WebElement priceElement;

    public DiscsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnFilterDiscButton() {
        filterDiscButton.click();
    }

    public void clickOnDiscButton() {
        discButton.click();
    }

    public String getTitleText() {
        return titleElement.getText();
    }

    public String getPriceText() {
        return priceElement.getText().trim();
    }
}
