package pageObject.Avito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;

public class AvitoPage {

    private final WebDriver driver;

    public AvitoPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getStatusCode() {
        try {
            driver.navigate().to("https://www.avito.ru/");
            String currentUrl = driver.getCurrentUrl();
            URL url = new URL(currentUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long getPageLoadTime() {
        driver.navigate().to("https://www.avito.ru/");
        long startTime = System.currentTimeMillis();
        driver.navigate().refresh();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public String getCityName() {
        driver.get("https://www.avito.ru/");
        WebElement element = driver.findElement(By.xpath("//span[@class='desktop-nev1ty']"));
        return element.getText();
    }

    public int getSearchMaxLength() {
        driver.get("https://www.avito.ru/");
        WebElement searchField = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        return Integer.parseInt(searchField.getAttribute("maxlength"));
    }

}