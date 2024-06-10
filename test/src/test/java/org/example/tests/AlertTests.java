package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertTests extends BaseTest{

    @Test
    @DisplayName("Should display info alert when clicking on info button")
    void shouldDisplayInfoAlertWhenClickingOnInfoButton() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getButtonLearnMore().click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();


        String alertText = alert.getText();
        String expectedText = "Esta aplicação focada em mobile visa ser um fácil cadastro para leituras futuras. " +
                "Desenvolvida por: Lucas Sigoli, João Castro e Erick Gomes";
        assertThat(alertText).isEqualTo(expectedText);
        Thread.sleep(5000);

        alert.accept();

    }
}
