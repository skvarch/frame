import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchFieldTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testTextAreaPresence() {
        driver.get("https://www.google.com");

        // Проверяем наличие элемента на странице
        WebElement textArea = null;
        String testName = this.getClass().getSimpleName();
        try {
            textArea = driver.findElement(By.cssSelector("textarea.gLFyf"));
            System.out.println("Тест " + testName + " прошел успешно.");
        } catch (NoSuchElementException e) {
            System.err.println("Тест " + testName + " завершился с ошибкой: " + e.getMessage());
        }

        assertNotNull(textArea, "Текстовое поле не найдено.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}