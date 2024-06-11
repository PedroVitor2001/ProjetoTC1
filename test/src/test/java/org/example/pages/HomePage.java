package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By listLinkLocator = By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/nav/a[2]");
    private final By titleLocator = By.xpath("/html/body/div[1]/div/div[2]/div[1]/h2");
    private final By firstInputLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/input");
    private final By secondInputLocator = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/input");
    private final By buttonLocator = By.xpath("/html/body/div[1]/div/div[2]/div[3]/button");
    private final By homeLinkLocator = By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/nav/a[1]");
    private final By buttonLearnMoreLocator = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/button");
    private final By responsiveElementLocator = By.xpath("/html/body/div[1]/div/div[1]/div/button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement getTitleElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
    }

    public WebElement getFirstInputElement() {
        return driver.findElement(firstInputLocator);
    }

    public WebElement getSecondInputElement() {
        return driver.findElement(secondInputLocator);
    }

    public WebElement getButtonElement() {
        return driver.findElement(buttonLocator);
    }

    public WebElement getHomeLink() {
        return driver.findElement(homeLinkLocator);
    }

    public WebElement getListLink() {
        return driver.findElement(listLinkLocator);
    }

    public WebElement getResponsiveElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(responsiveElementLocator));
    }

    public void registerNewBook(String title, String genre) {
        driver.findElement(firstInputLocator).sendKeys(title);
        driver.findElement(secondInputLocator).sendKeys(genre);
        driver.findElement(buttonLocator).click();
    }

    public WebElement getButtonLearnMore() {
        return driver.findElement(buttonLearnMoreLocator);
    }

}