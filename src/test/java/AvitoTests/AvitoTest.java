package AvitoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Avito.AvitoPage;
import java.time.Duration;

import static org.junit.Assert.fail;

public class AvitoTest {

    private WebDriver driver;
    private AvitoPage avitoPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        avitoPage = new AvitoPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    //статус код 200 проверка
    public void testStatusCode() {
        int statusCode = avitoPage.getStatusCode();
        if (statusCode == 200) {
            System.out.println("Успешно! Статус код 200");
        } else {
            fail("Провал! Статус код не 200!");
        }
    }

    @Test
    //время загрузки страницы
    public void testPageLoadTime() {
        long pageLoadTimeInMilliseconds = avitoPage.getPageLoadTime();
        System.out.println("Page load time: " + pageLoadTimeInMilliseconds + " ms");
    }

    @Test
    //вывод в консоль города по геолокации
    public void testGeoLocation(){
        String cityName = avitoPage.getCityName();
        System.out.println("City name: " + cityName);
    }

    @Test
    //максимальная длина символов в поиске
    public void testSearchMaxLength() {
        int maxLength = avitoPage.getSearchMaxLength();
        System.out.println("Максимальная длина поискового запроса: " + maxLength);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}


