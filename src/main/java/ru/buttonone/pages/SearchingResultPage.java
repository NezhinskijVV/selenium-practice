package ru.buttonone.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class SearchingResultPage extends BasePage {
    private final WebElement firstSearchingResult
            = driver.findElement(By.xpath("//h3[text()='Школа программирования на Java ITsJava']"));

    public SearchingResultPage(WebDriver driver) {
        super(driver);
    }
}