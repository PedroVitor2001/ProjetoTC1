package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponsiveElementTests extends BaseTest {

    @Test
    @DisplayName("Should display responsive element at 767px width at home page")
    void shouldDisplayResponsiveElementAt767pxWidthAtHomePage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        driver.manage().window().setSize(new org.openqa.selenium.Dimension(767, 800));

        Thread.sleep(5000);

        assertThat(homePage.getResponsiveElement().isDisplayed()).isTrue();
    }
}
