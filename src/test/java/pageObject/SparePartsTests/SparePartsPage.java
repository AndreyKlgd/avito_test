package pageObject.SparePartsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SparePartsPage {
    private WebDriver driver;

    @FindBy(xpath = "//img[@class='' and @alt='Запчасти']")
    private WebElement sparePartsButton;

    @FindBy(xpath = "//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']")
    private WebElement title;

    public SparePartsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnSparePartsButton() {
        sparePartsButton.click();
    }

    public String getTitleText() {
        return title.getText();
    }
}
