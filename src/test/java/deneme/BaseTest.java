package deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private WebDriver driver;

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "kaynaklar/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
        System.out.println((driver.getTitle()));

        Thread.sleep(2000);
        WebElement carpi = driver.findElement(By.className("fancybox-close"));
        System.out.println(carpi.getTagName());
        carpi.click();

        Thread.sleep(2000);
    }

    public static void main(String args[]) throws InterruptedException {
        BaseTest test = new BaseTest();
        test.setup();
    }
}
