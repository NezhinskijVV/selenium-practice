package ru.buttonone.pages;

import org.openqa.selenium.chrome.ChromeDriver;


public abstract class BasePage {
    protected static ChromeDriver driver = new ChromeDriver();

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    public void quit(){
        driver.quit();
    }
}