package ru.buttonone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

//    @BeforeAll  будет выполняться перед каждым тест классом
//
//    public static void setUpForAll() {
////threadsafe??
//        if (!("src/main/resources/chromedriver")
//                .equals(System.getProperty("webdriver.chrome.driver"))) {
//            System.out.println("aaa");
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        }
//    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}