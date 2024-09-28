package example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOrderFlow {
    private WebDriver driver;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String metro;
    private String date;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Иван", "иванов", "ул. Пушкина, д. 1", "Октябрьская", "88008088080", "12.11.24"},
                {"Петр", "петров", "Невский пр., д. 2", "Калужская", "88008080808", "24.11.24"}
        });
    }

    public TestOrderFlow(String name, String surname, String address, String metro, String phone, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testOrderFlow() {
        driver.findElement(By.className("Button_Button__ra12g")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(name);  //name
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input")).sendKeys(surname);  //surname
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input")).sendKeys(address);  //address
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input")).sendKeys(metro); //metro
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input")).sendKeys(phone); //phone
        driver.findElement(By.className("Button_Button__ra12g Button_Middle__1CSJM")).click(); // нажимаем кнопку далее
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input")).sendKeys(date); // date
        driver.findElement(By.className("Dropdown-placeholder")).click(); // открываем срок
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).click(); // выбираем срок
        driver.findElement(By.className("Button_Button__ra12g Button_Middle__1CSJM")).click(); // заказать
        driver.findElement(By.xpath(".//button[text()='Да']")).click(); // да
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}