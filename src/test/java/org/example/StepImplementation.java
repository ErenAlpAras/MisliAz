package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BasePage {
    //  String csv_file_path = "src/test/resources/N11CSV.csv";
    //  BufferedWriter writer = Files.newBufferedWriter(Paths.get(csv_file_path));

    public StepImplementation() throws IOException {
    }

    @Step("Go to <text> url")
    public void goToUrl(String text) {
        driver.get(text);
    }

    @Step("Click on <key> elements")
    public void clickElements(String key) {
        List<WebElement> elements = findElementsList(key);

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            element.click();
        }

    }

    /*@Step("link yazdırma <text>")
    public void linkDeneme(String text) throws IOException {

            List<WebElement> url = findElementsList(text);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (WebElement el : url) {
            csvPrinter.printRecord(text + el.getAttribute("href"));
            csvPrinter.flush();

            }



            }*/
    @Step("Wait <wait> seconds")
    public void waitSeconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        logger.info("Wait " + wait + " seconds");
    }

    @Step("Click on <key> element")
    public void click(String key) {
        clickElement((key));
        logger.info("Clicked on " + key + " element");
    }

    @Step("Check the <text> is displayed in the <key> element")
    public void displayedAssert(String text, String key) {
        Assert.assertEquals(text + "is not displayed", text, getText(key));
        logger.info(text + " is displayed on " + key + " element");
    }

    @Step("Type <text> in the <key> element")
    public void type(String text, String key) {
        sendKeys((key), text);
        logger.info("Typed " + text + " in " + key + " element");
    }

    @Step("<key> elementinde <i> ürünü")
    public void urun(String key, int i) {
        List<WebElement> urun = findElementsList(key);
        urun.get(i).click();
        logger.info("Select " + i + ". product");
    }
    @Step("Select from <key> element by <text>")
    public void select(String key, String text) {
        selectMetod(key, text);
        logger.info("Select " + text);
    }

}