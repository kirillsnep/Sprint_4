package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FAQPage {
    private WebDriver driver;

    // Локаторы
    private By questionArrow = By.xpath("//*[@id=\"accordion__heading-0\"]");
    private By answerText = By.xpath("//*[@id=\"accordion__panel-0\"]/p");

    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQuestionArrow() {
        driver.findElement(questionArrow).click();
    }

    public String getAnswerText() {
        return driver.findElement(answerText).getText();
    }
}
