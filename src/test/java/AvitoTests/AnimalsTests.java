package AvitoTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.Animal.AnimalsPage;

import java.time.Duration;

public class AnimalsTests {
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    // добавляем в избранное первое объявление
    // переходим на страницу избранного
    // проверяем во вкладке "Все" что там значение 1
    public void testAdDetailsPage() {
        AnimalsPage page = new AnimalsPage(driver);
        page.goToAnimalsPage();
        page.addAdToFavorites();
        int count = page.getCountOfAds();
        Assert.assertEquals("Тест провален", 1, count);
    }

    @Test
    //переход на страницу с собаками
    //вывод в консоль имя первого питомца в объявлении
    public void testDogs() {
        AnimalsPage page = new AnimalsPage(driver);
        page.goToAnimalsPage();
        page.selectCategory("Собаки");
        String petName = page.getAdHeaderText();
        System.out.println(petName);
    }

    @Test
    //клик на фильтр с разделом "Кошки"
    // вывод в консоль кол-во объявлений
    public void testCats() {
        AnimalsPage page = new AnimalsPage(driver);
        page.goToAnimalsPage();
        page.selectCategory("Кошки");
        String countText = page.getCountAdElementsText();
        System.out.println("Количество объявлений с кошками: " + countText);
    }

    @Test
    //клик на раздел "Птицы"
    //выставить фильтр по стоимости как самые дорогие
    //вывести в консоль стоимость первого объявления
    public void testBirds() {
        AnimalsPage page = new AnimalsPage(driver);
        page.goToAnimalsPage();
        page.selectCategory("Птицы");
        page.selectItemCondition();
        int price = page.getPriceOfFirstAd();
        System.out.println("Стоимость первого объявления: " + price + " ₽");
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
// добавляем в избранное первое объявление
// переходим на страницу избранного
// проверяем во вкладке "Все" что там значение 1

//переход на страницу с собаками
//вывод в консоль имя первого питомца в объявлении

//клик на фильтр с разделом "Кошки"
// вывод в консоль кол-во объявлений

//клик на раздел "Птицы"
//выставить фильтр по стоимости как самые дорогие
//вывести в консоль стоимость первого объявления