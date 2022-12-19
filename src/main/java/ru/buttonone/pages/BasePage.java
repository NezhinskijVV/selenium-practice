package ru.buttonone.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
     // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebElement findElement(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}