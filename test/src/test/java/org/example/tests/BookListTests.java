package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.ListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class BookListTests extends BaseTest {

    @Test
    @DisplayName("Should update list with new book")
    void ShouldUpdateListWithNewBook() throws InterruptedException {

        ListPage listpage = new ListPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.getListLink().click();

        int initialListSize = listpage.getListSize();

        homePage.getHomeLink().click();

        homePage.getTitleElement();

        String bookTitle = faker.book().title();
        String bookGenre = faker.book().genre();

        homePage.getFirstInputElement().sendKeys(bookTitle);
        Thread.sleep(3000);

        homePage.getSecondInputElement().sendKeys(bookGenre);
        Thread.sleep(3000);

        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);

        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso";
        assertThat(alertText).isEqualTo(expectedText);

        alert.accept();
        Thread.sleep(3000);









        homePage.getListLink().click();

        int finalListSize = listpage.getListSize();

        Assertions.assertEquals(initialListSize + 1, finalListSize, "O tamanho final da lista não é 1 maior que o tamanho inicial.");

    }

}

