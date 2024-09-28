package example;

import example.pages.FAQPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestFAQ {
    private WebDriver driver;
    private FAQPage faqPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/"); // Замените на URL вашего приложения
        faqPage = new FAQPage(driver);
    }

    @Test
    public void testFAQDropdown() {
        faqPage.clickQuestionArrow(); // Нажимаем на стрелочку
        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualAnswer = faqPage.getAnswerText(); // Получаем текст ответа
        assertEquals("Ответ не соответствует ожидаемому.", expectedAnswer, actualAnswer); // Проверка текста
    }

    @After
    public void tearDown() {
            driver.quit();

    }
}
