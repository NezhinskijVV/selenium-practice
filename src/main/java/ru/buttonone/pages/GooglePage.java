package ru.buttonone.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.buttonone.utils.Props;

import java.time.Duration;

public class GooglePage extends BasePage {
    private final WebElement searchField;

    @SneakyThrows
    public GooglePage(WebDriver driver) {
        super(driver);
        driver.navigate().to(Props.getProperty("url"));
        //Thread.sleep(3000); <- !! плохо, так писать нельзя!!

        // 1. Используя driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //на все элементы приложения

        //2.  Используя WebDriverWait (специфические условия остановки и задержка на каждый элемент)
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.
//                elementToBeClickable(searchField));

        //3. FluentWait контроль с какой периодичностью кидать запросы
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(1)) //количество времени
                .pollingEvery(Duration.ofMillis(300)); // частота кидания запроса

        // wait.until(ExpectedConditions.elementToBeClickable(searchField));
        //searchField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        //4. Кастомный метод (иногда все-таки нужен)
        if (searchFieldIsDisplayed(By.name("q"))) {
            searchField = driver.findElement(By.name("q"));
        } else {
            throw new NoSuchElementException("не нашли элемент searchField");
        }
        //searchField = driver.findElement(By.name("q"));
    }

    public SearchingResultPage searchByPhraseAndClickEnter(String phrase) {
        searchField.click();
        searchField.sendKeys(phrase);
        searchField.sendKeys(Keys.RETURN);
        return new SearchingResultPage(driver);
    }

    @SneakyThrows
    public boolean searchFieldIsDisplayed(By by) {
        for (int i = 0; i < 10; i++) {
            if (driver.findElement(by).isDisplayed()) return true;
            Thread.sleep(1000);
        }
        return false;
    }
}