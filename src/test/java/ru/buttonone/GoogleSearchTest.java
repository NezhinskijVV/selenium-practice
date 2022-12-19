package ru.buttonone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ru.buttonone.pages.GooglePage;
import ru.buttonone.pages.ITsJavaPage;
import ru.buttonone.pages.SearchingResultPage;

public class GoogleSearchTest extends BaseTest {

    //1. Зайти на страницу гугл
    //2. В поиске найти ITsJAVA
    //3. Кликнуть по ссылке официального сайта
    //4. Проверить, что есть блок в названием "Выпускники прошлого курса"

    @Test
    public void shouldHaveCorrectGraduateHeader(){
        System.out.println("1. Зайти на страницу гугл");
        GooglePage googlePage = new GooglePage(driver);

        System.out.println("2. В поиске найти ITsJAVA");
        SearchingResultPage searchingResultPage = googlePage.searchByPhraseAndClickEnter("ITsJAVA");

        System.out.println("3. Кликнуть по ссылке официального сайта");
        searchingResultPage.getFirstSearchingResult().click();

        System.out.println("4. Проверить, что есть блок в названием \"Выпускники прошлого курса\"\n");
        ITsJavaPage iTsJavaPage = new ITsJavaPage(driver);
        WebElement graduateHeader = iTsJavaPage.getGraduateHeader();
        Assertions.assertEquals("Выпускники прошлого курса", graduateHeader.getText());
    }

    @Test
    public void shouldHaveCorrectGraduateHeader2(){
        System.out.println("1. Зайти на страницу гугл");
        GooglePage googlePage = new GooglePage(driver);

        System.out.println("2. В поиске найти ITsJAVA");
        SearchingResultPage searchingResultPage = googlePage.searchByPhraseAndClickEnter("ITsJAVA");

        System.out.println("3. Кликнуть по ссылке официального сайта");
        searchingResultPage.getFirstSearchingResult().click();

        System.out.println("4. Проверить, что есть блок в названием \"Выпускники прошлого курса\"\n");
        ITsJavaPage iTsJavaPage = new ITsJavaPage(driver);
        WebElement graduateHeader = iTsJavaPage.getGraduateHeader();
        Assertions.assertEquals("Выпускники прошлого курса", graduateHeader.getText());
    }
}
