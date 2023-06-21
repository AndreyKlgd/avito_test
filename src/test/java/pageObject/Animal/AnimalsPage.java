package pageObject.Animal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnimalsPage {

    private WebDriver driver;

    private By favoritesButton = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div[1]/a[1]/div");
    private By fv = By.xpath("(//div[@class='favorites-root-zxBe3' and @data-state='empty' and @data-marker='favorites-add'])[1]");
    private By countElement = By.xpath("//span[text()='Все']/following-sibling::span[@class='category-content-count-SHk4K']");

    private By category(String categoryName) {
        return By.xpath("//a[@class='rubricator-list-item-link-uPiO2'][@title='" + categoryName + "']");
    }

    private By adHeader = By.xpath("//h3");
    private By countAdElements = By.xpath("//span[@data-marker='page-title/count']");

    private By itemCondition = By.xpath("//*[@class='desktop-1i1owsb']");
    private By minPrice = By.xpath("//option[@value='2']");
    private By firstAdPrice = By.xpath("(//span[contains(@class, 'price')])[1]");

    public AnimalsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAnimalsPage() {
        driver.get("https://www.avito.ru/kaliningrad/zhivotnye");
    }

    public void addAdToFavorites() {
        driver.findElement(fv).click();
        driver.findElement(favoritesButton).click();
    }

    public int getCountOfAds() {
        String countText = driver.findElement(countElement).getText();
        return Integer.parseInt(countText);
    }

    public void selectCategory(String categoryName) {
        driver.findElement(category(categoryName)).click();
    }

    public String getAdHeaderText() {
        return driver.findElement(adHeader).getText();
    }

    public String getCountAdElementsText() {
        return driver.findElement(countAdElements).getText();
    }

    public void selectItemCondition() {
        driver.findElement(itemCondition).click();
        driver.findElement(minPrice).click();
    }

    public int getPriceOfFirstAd() {
        String priceText = driver.findElement(firstAdPrice).getText().replaceAll("\\D+","");
        return Integer.parseInt(priceText);
    }
}