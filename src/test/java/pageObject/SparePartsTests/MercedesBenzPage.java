package pageObject.SparePartsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercedesBenzPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='search-action-button-kt_sE desktop-xgpl9y']")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[@class='page-title-text-tSffu page-title-inline-zBPFx' and @data-marker='page-title/text']")
    private WebElement titleElement;

    @FindBy(xpath = "//span[@class='page-title-count-wQ7pG' and @data-marker='page-title/count']")
    private WebElement countElement;

    public MercedesBenzPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public String getTitleText() {
        return titleElement.getText();
    }

    public int getCount() {
        String countText = countElement.getText().replaceAll("\\s+","");
        return Integer.parseInt(countText);
    }
}
