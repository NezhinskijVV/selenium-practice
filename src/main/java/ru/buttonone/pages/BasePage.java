package ru.buttonone.pages;


import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }
}