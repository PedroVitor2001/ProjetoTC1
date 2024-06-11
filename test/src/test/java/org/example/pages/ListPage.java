package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By listLinkLocator = By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/nav/a[2]");
    private final By listElementLocator = By.xpath("/html/body/div[1]/div/div[2]/div/table/tbody/tr");
    private final By buttonLearnMoreLocator = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/button");
    private final By responsiveElementLocator = By.xpath("/html/body/div[1]/div/div[1]/div/button");

    public ListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement getListLink() {
        return driver.findElement(listLinkLocator);
    }


    public WebElement getButtonElement() {
        return driver.findElement(buttonLearnMoreLocator);
    }

    public WebElement getResponsiveElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(responsiveElementLocator));
    }

    public int getListSize() {
        int listSize = 0;
        int i = 1;
        boolean found = true;

        while (found) {
            try {
                WebElement listElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/table/tbody/tr[" + i + "]"));
                i++;
                listSize++;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                found = false;
            }
        }

        return listSize;
    }
}