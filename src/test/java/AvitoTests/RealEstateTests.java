package AvitoTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.RealEstatePage.RealEstatePage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RealEstateTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    //клик на иконку недвижимости и вывод в консоль результата
    public void testRealEstate() {
        driver.get("https://www.avito.ru/");
        RealEstatePage realEstatePage = new RealEstatePage(driver);
        realEstatePage.clickSearchIcon();
        String headerText = realEstatePage.getHeaderText();
        System.out.println(headerText);
        Assert.assertEquals("Недвижимость в Калининграде", headerText);
    }

    @Test
    //клик на элемент "показать 12тыс.объявлений"
    //и проверка что произошел переход на страницу, где указана "Продажа квартир в Калининграде"
    // вывод в консоль кол-ва объявлений
    public void testPageTitleCountRealEstate() {
        RealEstatePage realEstatePage = new RealEstatePage(driver);
        driver.get("https://www.avito.ru/kaliningrad/nedvizhimost");
        realEstatePage.clickSearchButton(); String actualPageTitle = realEstatePage.getPageTitle();
        String expectedPageTitle = "Продажа квартир в Калининграде"; assertEquals(expectedPageTitle, actualPageTitle);
        String actualAdsCount = realEstatePage.getAdsCount();

    }

    @Test
    //клик на иконку Выбрать ЖК в каталоге,
    // дальше подтверждение страницы элементом с названием "Новостройки (ЖК) в Калининграде"
    // и вывод кол-ва объявлений в консоль
    public void selectTestJK() {
        RealEstatePage realEstatePage = new RealEstatePage(driver);
        driver.get("https://www.avito.ru/kaliningrad/nedvizhimost");
        realEstatePage.clickJKButton();
        String actualJKTitle = realEstatePage.getJKPageTitle();
        Assert.assertTrue(actualJKTitle.contains("Новостройки (ЖК) в Калининграде"));
        String actualAdsCount = realEstatePage.getJKAdsCount();

    }

    @Test
    //клик на иконку "Снять жилье на долгий срок",
    // дальше подтверждение страницы элементом с названием "Аренда квартир на длительный срок в Калининграде"
    // и вывод кол-ва объявлений в консоль
    public void LongTermTest(){
        RealEstatePage realEstatePage = new RealEstatePage(driver);
        driver.get("https://www.avito.ru/kaliningrad/nedvizhimost");
        realEstatePage.clickLTButton();
        String actualLTTitle = realEstatePage.getLTPageTitle();
        Assert.assertEquals(actualLTTitle, "Аренда квартир на длительный срок в Калининграде");
        String actualAdsCount = realEstatePage.getLTAdsCount();


    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}