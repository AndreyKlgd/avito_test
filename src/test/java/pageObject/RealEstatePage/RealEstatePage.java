package pageObject.RealEstatePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RealEstatePage {
    private WebDriver driver;
    private By searchIcon = By.xpath("//img[@alt='Недвижимость']");

    private By searchButton = By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/a[1]");
    private By pageTitle = By.xpath("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']");
    private By adsCount = By.xpath("//span[@class='page-title-count-wQ7pG']");

    private By jkButton = By.xpath("//div[@class='category-category-UsMXR']");
    private By jkPageTitle = By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[8]/div[1]/h1");
    private By jkAdsCount = By.xpath("//span[@class='desktop-67m6ni']");

    private By LTButton = By.xpath("//img[contains(@src, \"ltr.png\")]");
    private By LTPageTitle = By.xpath("//h1[@data-marker=\"page-title/text\"]");
    private By LTAdsCount = By.xpath("//span[@data-marker=\"page-title/count\"]");



    public RealEstatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchIcon() {
        WebElement searchIconElement = driver.findElement(searchIcon);
        searchIconElement.click();
    }

    public String getHeaderText() {
        WebElement h1Element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div/div[1]/div/div/h1"));
        return h1Element.getText();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getAdsCount() {
        String actualAdsCount = driver.findElement(adsCount).getText().replace("\u00a0", "");
        System.out.println("Количество объявлений: " + actualAdsCount);
        return actualAdsCount;
    }

    public void clickJKButton() {
        driver.findElement(jkButton).click();
    }

    public String getJKPageTitle() {
        Assert.assertTrue(driver.findElement(jkPageTitle).isDisplayed());
        return driver.findElement(jkPageTitle).getText();
    }

    public String getJKAdsCount() {
        String numberText = driver.findElement(jkAdsCount).getText();
        System.out.println("Количество объявлений " + numberText);
        return numberText;
    }

    public void clickLTButton() {
        driver.findElement(LTButton).click();
    }

    public String getLTPageTitle() {
        Assert.assertTrue(driver.findElement(LTPageTitle).isDisplayed());
        return driver.findElement(LTPageTitle).getText();
    }

    public String getLTAdsCount() {
        String numberText = driver.findElement(LTAdsCount).getText();
        System.out.println("Количество объявлений " + numberText);
        return numberText;
    }
}

