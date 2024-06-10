package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResponsiveElementTests extends BaseTest {

    @Test
    @DisplayName("Should display responsive element at 767px width at home page")
    void shouldDisplayResponsiveElementAt767pxWidthAtHomePage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        driver.manage().window().setSize(new org.openqa.selenium.Dimension(767, 800));

        Thread.sleep(5000);

        assertThat(homePage.getResponsiveElement().isDisplayed()).isTrue();
    }

    @Test
    void shouldShowMenuItemsAfterButtonClickAt767Width() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        driver.manage().window().setSize(new org.openqa.selenium.Dimension(767, 800));

        assertThat(homePage.getResponsiveElement().isDisplayed()).isTrue();

        WebElement button = driver.findElement
                (By.xpath("/html/body/div[1]/div/div[1]/div/button"));
        button.click();

        Thread.sleep(5000);

        WebElement homeLink = driver.findElement
                (By.xpath("/html/body/div[1]/div/div[1]/div[2]/nav/a[1]"));
        WebElement listLink = driver.findElement
                (By.xpath("/html/body/div[1]/div/div[1]/div[2]/nav/a[2]"));

        assertTrue(homeLink.isDisplayed());
        assertTrue(listLink.isDisplayed());
    }
}
