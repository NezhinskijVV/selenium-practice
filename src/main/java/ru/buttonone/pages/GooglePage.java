package ru.buttonone.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.buttonone.utils.Props;

public class GooglePage extends BasePage {
    private final WebElement searchField;

    @SneakyThrows
    public GooglePage(WebDriver driver) {
        super(driver);
        driver.navigate().to(Props.getProperty("url"));
        Thread.sleep(3000);
        searchField = driver.findElement(By.name("q"));
        ///
    }

    public SearchingResultPage searchByPhraseAndClickEnter(String phrase){
        searchField.click();
        searchField.sendKeys(phrase);
        searchField.sendKeys(Keys.RETURN);
        return new SearchingResultPage(driver);
    }
}