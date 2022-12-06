package ru.buttonone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    @Test
    public void shouldHaveCorrectToOpenGoogle(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com/");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.click();
        searchField.sendKeys("ITsJAVA");
        searchField.sendKeys(Keys.RETURN);

        WebElement firstSearchingResult
                = driver.findElement(By.xpath("//h3[text()='Школа программирования на Java ITsJava']"));
        firstSearchingResult.click();

        WebElement graduateHeader = driver.findElement(By.xpath("//div[contains(text(),'Выпускники')]"));
        Assertions.assertEquals("Выпускники прошлого курса", graduateHeader.getText());

        driver.quit();
    }
}
