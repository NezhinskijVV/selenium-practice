package ru.buttonone;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.buttonone.pages.GooglePage;
import ru.buttonone.pages.ITsJavaPage;
import ru.buttonone.pages.SearchingResultPage;

public class GoogleSearchTest {

    //1. Зайти на страницу гугл
    //2. В поиске найти ITsJAVA
    //3. Кликнуть по ссылке официального сайта
    //4. Проверить, что есть блок в названием "Выпускники прошлого курса"

    @Test
    public void shouldHaveCorrectToOpenGoogle(){
        System.out.println("1. Зайти на страницу гугл");
        GooglePage googlePage = new GooglePage();

        System.out.println("2. В поиске найти ITsJAVA");
        SearchingResultPage searchingResultPage = googlePage.searchByPhraseAndClickEnter("ITsJAVA");

        System.out.println("3. Кликнуть по ссылке официального сайта");
        searchingResultPage.getFirstSearchingResult().click();

        System.out.println("4. Проверить, что есть блок в названием \"Выпускники прошлого курса\"\n");
        ITsJavaPage iTsJavaPage = new ITsJavaPage();
        WebElement graduateHeader = iTsJavaPage.getGraduateHeader();
        Assertions.assertEquals("Выпускники прошлого курса", graduateHeader.getText());

        iTsJavaPage.quit();
    }
}
