import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumHW {
    private WebDriver driver;
    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }
//        System.setProperty( "webdriver.chrome.driver", "./Driver/Mac/chromedriver 3");
    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    @AfterEach
    public void TearDown () {
        driver.quit();
    }
    @Test
    public void ShouldSendForm () {
        driver.get("http://0.0.0.0:7777");
        List<WebElement> TextFields = driver.findElements(By.className("input__control"));
        TextFields.get(0).sendKeys("Александра");
        TextFields.get(1).sendKeys("+71111111111");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String actualText = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        Assertions.assertEquals(expected,actualText);
    }
}

//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.List;
//
//public class SeleniumHW {
//    private WebDriver driver;
//    @BeforeAll
//    public  static void SetupAll () {
//        System.setProperty( "webdriver.chrome.driver", "./Driver/Mac/chromedriver 3");
//    }
//    @BeforeEach
//    public void SetUp () {
//        driver = new ChromeDriver();
//    }
//    @AfterEach
//    public void TearDown () {
//        driver.quit();
//        driver = null;
//    }
//    @Test
//    public void ShouldSendForm () {
//        driver.get("http://0.0.0.0:7777");
//        List<WebElement> TextFields = driver.findElements(By.className("input__control"));
//        TextFields.get(0).sendKeys("Александра");
//        TextFields.get(1).sendKeys("+71111111111");
//        driver.findElement(By.className("checkbox__control")).click();
//        driver.findElement(By.tagName("button")).click();
//        String actualText = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
//        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//        Assertions.assertEquals(expected,actualText);
//    }
//}
