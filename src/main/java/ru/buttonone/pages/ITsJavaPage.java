package ru.buttonone.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ITsJavaPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(),'Выпускники')]")
    private WebElement graduateHeader;

    public ITsJavaPage(WebDriver driver) {
        super(driver);
    }
}
