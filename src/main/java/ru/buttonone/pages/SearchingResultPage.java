package ru.buttonone.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchingResultPage extends BasePage {
    @FindBy(xpath = "//h3[text()='Школа программирования на Java ITsJava']" )
    private WebElement firstSearchingResult;

    public SearchingResultPage(WebDriver driver) {
        super(driver);
    }
}