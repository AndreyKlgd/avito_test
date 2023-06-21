package AvitoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.SparePartsTests.SparePartsPage;
import pageObject.SparePartsTests.DiscsPage;
import pageObject.SparePartsTests.MercedesBenzPage;

import java.time.Duration;

public class SparePartsTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    //Тест открывает главную страницу по заданной ссылке
    // кликает на кнопку "Запчасти и аксессуары".
    // После этого происходит проверка, что заголовок страницы содержит текст "Запчасти и аксессуары для машин и мотоциклов"
    public void sparePartsTest() {
        SparePartsPage sparePartsPage = new SparePartsPage(driver);
        driver.get("https://www.avito.ru/");
        sparePartsPage.clickOnSparePartsButton();
        String titleText = sparePartsPage.getTitleText();

        assertTrue(titleText.contains("Запчасти и аксессуары для машин и мотоциклов"));
        System.out.println("Заголовок страницы: " + titleText);
    }

    @Test
    //клик на "показать объявления"
    //выводит название страницы и кол-во объявлений в консоль
    public void mercedesBenzTest() {
        MercedesBenzPage mercedesBenzPage = new MercedesBenzPage(driver);
        driver.get("https://www.avito.ru/kaliningrad/zapchasti_i_aksessuary");
        mercedesBenzPage.clickOnSearchButton();
        String titleText = mercedesBenzPage.getTitleText();
        int count = mercedesBenzPage.getCount();

        assertNotNull(titleText);
        System.out.println(titleText);
        System.out.println("Количество объявлений: " + count);
    }

    @Test
    //открывает страницу по заданной ссылке,
    // кликает на кнопку фильтра для выбора дисков,
    // после чего кликает на объявление о продаже дисков и собирает наименование объявления и цену
    //выводит в консоль
    public void discsTest () {
        DiscsPage discsPage = new DiscsPage(driver);
        driver.get("https://www.avito.ru/kaliningrad/zapchasti_i_aksessuary");

        discsPage.clickOnFilterDiscButton();
        discsPage.clickOnDiscButton();
        String title = discsPage.getTitleText();
        String price = discsPage.getPriceText();

        assertNotNull(title);
        System.out.println("Наименование объявления: " + title.trim());
        System.out.println("Цена: " + price.trim());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

