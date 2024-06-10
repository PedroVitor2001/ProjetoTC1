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
    }
}