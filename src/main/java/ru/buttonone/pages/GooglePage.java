package ru.buttonone.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {
    private final WebElement searchField;

    public GooglePage() {
        driver.navigate().to("http://www.google.com/");
        searchField = driver.findElement(By.name("q"));
    }

    public SearchingResultPage searchByPhraseAndClickEnter(String phrase){
        searchField.click();
        searchField.sendKeys(phrase);
        searchField.sendKeys(Keys.RETURN);
        return new SearchingResultPage();
    }
}