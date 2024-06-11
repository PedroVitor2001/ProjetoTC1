package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.ListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


        homePage.getSecondInputElement().sendKeys(bookGenre);


        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();


        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso";
        assertThat(alertText).isEqualTo(expectedText);

        alert.accept();



        homePage.getListLink().click();

        int finalListSize = listpage.getListSize();

        Assertions.assertEquals(initialListSize + 1, finalListSize, "O tamanho final da lista não é 1 maior que o tamanho inicial.");

    }

    @Test
    @DisplayName("Should update book name after editing")
    void ShouldUpdateBookNameAfterEditing() throws InterruptedException {

        ListPage listpage = new ListPage(driver);
        HomePage homePage = new HomePage(driver);

        String originalBookTitle = faker.book().title();
        String bookGenre = faker.book().genre();

        homePage.getFirstInputElement().sendKeys(originalBookTitle);

        homePage.getSecondInputElement().sendKeys(bookGenre);

        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        String expectedText = "Cadastrado com sucesso";

        alert.accept();

        homePage.getListLink().click();

        String newBookTitle = faker.book().title();

        listpage.getEditButton().click();


        listpage.getEditTitle().clear();


        listpage.getEditTitle().sendKeys(newBookTitle);


        listpage.getSaveEdit().click();


        WebElement extractedBookName = listpage.getBookName();

        boolean nameChanged;

        if (extractedBookName.equals(originalBookTitle)) {
            nameChanged = false;
        } else {
            nameChanged = true;
        }

        Assertions.assertTrue(nameChanged, "Edição não realizada");
    }

    @Test
    @DisplayName("Should delete book")
    void ShouldDeleteBook() throws InterruptedException {

        ListPage listpage = new ListPage(driver);
        HomePage homePage = new HomePage(driver);

        String originalBookTitle = faker.book().title();
        String bookGenre = faker.book().genre();

        homePage.getFirstInputElement().sendKeys(originalBookTitle);

        homePage.getSecondInputElement().sendKeys(bookGenre);

        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        alert.accept();

        homePage.getListLink().click();

        listpage.getDeleteButton().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();

        String alertText = alert2.getText();
        String expectedText = "Removed with success";
        assertThat(alertText).isEqualTo(expectedText);



    }
}

