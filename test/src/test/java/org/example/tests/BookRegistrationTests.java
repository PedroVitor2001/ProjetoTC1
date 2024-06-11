package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class BookRegistrationTests extends BaseTest {

    @Test
    @DisplayName("Should open and register a book correctly and accept the alert")
    void ShouldOpenAndRegisterABookCorrectlyAndAcceptTheAlert() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

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

    }

    @Test
    @DisplayName("Should display error alert when trying to register without title and genre")
    void ShouldDisplayAlertWhenTryingToRegisterWithoutTitleAndGenre() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getTitleElement();

        homePage.getFirstInputElement().clear();
        homePage.getSecondInputElement().clear();

        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();


        String alertText = alert.getText();
        String expectedText = "All fields are required";
        assertThat(alertText).isEqualTo(expectedText);

        alert.accept();

    }

    @Test
    @DisplayName("Should not allow registration with empty spaces")
    void shouldNotAllowRegistrationWithEmptySpaces() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getTitleElement().sendKeys("     ");
        homePage.getSecondInputElement().sendKeys("     ");
        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "All fields are required";
        assertThat(alertText).isEqualTo(expectedText);


        alert.accept();
    }

    @Test
    @DisplayName("Should display error alert when trying to register without title")
    void shouldDisplayErrorAlertWhenTryingToRegisterWithoutTitle() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getTitleElement();

        String bookGenre = faker.book().genre();

        homePage.getFirstInputElement().clear();
        homePage.getSecondInputElement().sendKeys(bookGenre);

        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        String expectedText = "All fields are required";
        assertThat(alertText).isEqualTo(expectedText);


        alert.accept();
    }

    @Test
    @DisplayName("Should display error alert when trying to register without genre")
    void shouldDisplayErrorAlertWhenTryingToRegisterWithoutGenre() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getTitleElement();

        String bookTitle = faker.book().title();

        homePage.getFirstInputElement().sendKeys(bookTitle);
        homePage.getSecondInputElement().clear();


        homePage.getButtonElement().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        String expectedText = "All fields are required";
        assertThat(alertText).isEqualTo(expectedText);


        alert.accept();
    }
}