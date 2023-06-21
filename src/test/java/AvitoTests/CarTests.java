package AvitoTests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.CarTests.CarPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CarTests {

    private static WebDriver driver;
    private CarPage carPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver","C:/Program Files/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Before
    public void init() {
        carPage = new CarPage(driver);
    }

    @Test
    //Ищет элемент "Транспорт и запчасти"
    public void testPageTitle() {
        driver.get("https://www.avito.ru/all/transport");
        String expectedTitle = "Транспорт и запчасти";
        Assert.assertEquals(expectedTitle, carPage.getPageTitle());
    }

    @Test
    //проверяем количество всех моделей авто в категории "Автомобили"
    public void testPageTitleCountAuto() {
        driver.get("https://www.avito.ru/all/transport");
        assertTrue(carPage.getPageCounter() > 0);
        System.out.println("Количество всех объявлений в категории 'Автомобили': " + carPage.getPageCounter());
    }

    @Test
    //Проверяем кол-во элементов на вкладке "Все" в категории авто
    public void testAll() {
        driver.get("https://www.avito.ru/");
        carPage.clickSearchIcon();
        carPage.clickAllButton();
        assertTrue(carPage.getAutoCategoryCount() > 120);
        System.out.println("Количество элементов на вкладке 'Все' в категории авто: " + carPage.getAutoCategoryCount());
    }

    @Test
    //проверка ввода в поиск текста "BMW" и проверка результата по ключевому слому "BMW"
    public void testSearch() {
        driver.get("https://www.avito.ru/");
        carPage.setSearchText("BMW");
        carPage.clickSearchButton();
        assertTrue(carPage.getResultTitle().contains("BMW"));
    }

    @Test
    //сортирует список авто на "Дорогие" и выводит в консоль название и цену из первого объявления
    public void testSortByPrice() {
        driver.get("https://www.avito.ru/all/avtomobili?cd=1");
        carPage.clickSortSelect();
        carPage.clickMaxPriceOption();
        String carModel = carPage.getCarModel();
        String priceResult = carPage.getPriceResult();
        System.out.println("Модель авто: " + carModel);
        System.out.println("Цена: " + priceResult);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}