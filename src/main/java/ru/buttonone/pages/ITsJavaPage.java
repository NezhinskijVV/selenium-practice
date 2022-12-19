package ru.buttonone.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class ITsJavaPage extends BasePage {
    private final WebElement graduateHeader
            = driver.findElement(By.xpath("//div[contains(text(),'Выпускники')]"));

    public ITsJavaPage(WebDriver driver) {
        super(driver);
    }
}
