package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends BaseTest {


    public BasePage() {
        wait = new WebDriverWait(driver, 5, 500);
        initMap(getFileList());
    }

    public By getElementInfoToBy(Elements elements) {
        By by = null;
        if (elements.getType().equals("css")) {
            by = By.cssSelector(elements.getValue());
        } else if (elements.getType().equals(("name"))) {
            by = By.name(elements.getValue());
        } else if (elements.getType().equals("id")) {
            by = By.id(elements.getValue());
        } else if (elements.getType().equals("xpath")) {
            by = By.xpath(elements.getValue());
        } else if (elements.getType().equals("linkText")) {
            by = By.linkText(elements.getValue());
        } else if (elements.getType().equals(("partialLinkText"))) {
            by = By.partialLinkText(elements.getValue());
        }
        return by;
    }

    public List<WebElement> findElementsList(String key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getElementInfoToBy(findElementInfoByKey(key))));
    }
    public WebElement findElement(String key){
        return wait.until(ExpectedConditions.presenceOfElementLocated(getElementInfoToBy(findElementInfoByKey(key))));
    }
    public void sendKeys(String key, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key))).sendKeys(text);
    }
    public void removeKeys(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key))).clear();
    }
    public void selectMetod(String key, String text) {
        Select select = new Select(findElement(key));
        select.selectByVisibleText(text);
    }

    public String getText(String key) {return findElement(key).getText();
    }
    public void clickElement(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key))).click();
    }



}