package pageObject.CarTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarPage {

    public WebDriver driver;

    private final By pageTitle = By.xpath("//h1[@class ='page-title-text-tSffu page-title-inline-zBPFx']");
    private final By pageCounter = By.xpath("//span[@class='page-title-count-wQ7pG']");
    private final By searchIcon = By.xpath("//img[@alt='Авто']");
    private final By allButton = By.xpath("//button[@data-marker='popular-rubricator/controls/all']");
    private final By autoCategory = By.xpath("//div[@class='popular-rubricator-root-Mo5uC']/div[2]//a[@data-category-id='9']");
    private final By searchInput = By.xpath("//input[@data-marker='search-form/suggest']");
    private final By resultTitle = By.xpath("//h1[contains(@data-marker, 'page-title/text')]");
    private final By sortSelect = By.xpath("//select[@data-marker='sort-select/input']");
    private final By maxPriceOption = By.xpath("//option[@value='2']");
    private final By carModel = By.xpath("//h3[@itemprop='name']");
    private final By priceResult = By.xpath("//strong[contains(@class,'styles-module-root')]/span");

    public CarPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public int getPageCounter() {
        String counter = driver.findElement(pageCounter).getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(counter);
    }

    public void clickSearchIcon() {
        driver.findElement(searchIcon).click();
    }

    public void clickAllButton() {
        driver.findElement(allButton).click();
    }

    public int getAutoCategoryCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autoCategory));
        return driver.findElements(autoCategory).size();
    }

    public void setSearchText(String searchText) {
        driver.findElement(searchInput).sendKeys(searchText);
    }

    public void clickSearchButton() {
        driver.findElement(searchInput).sendKeys(Keys.RETURN);
    }

    public String getResultTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultTitle));
        return resultTitleElement.getText();
    }

    public void clickSortSelect() {
        driver.findElement(sortSelect).click();
    }

    public void clickMaxPriceOption() {
        driver.findElement(maxPriceOption).click();
    }

    public String getCarModel() {
        return driver.findElement(carModel).getText().trim();
    }

    public String getPriceResult() {
        return driver.findElement(priceResult).getText().trim();
    }
}
