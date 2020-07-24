package deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasketPage;
import pages.HomePage;
import pages.SearchPage;

import java.sql.Driver;

public class BaseTest {
    private WebDriver driver;

    public WebDriver setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "kaynaklar/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
        driver.manage().window().maximize();
        Thread.sleep(500);
        WebElement carpi = driver.findElement(By.className("fancybox-close"));
        carpi.click();
        return driver;
    }
    public int stringtoInt(String old)
    {
        return Integer.parseInt(old.split(" ")[0].replace(".","").split(",")[0]);
    }

    public static void main(String args[]) throws InterruptedException {
        BaseTest test = new BaseTest();
        HomePage anaSayfa = new HomePage(test.setup());
        SearchPage aramaSayfa =
                new SearchPage(anaSayfa.anasayfaIslemleri("EMAİL GİRİN","cokgizli"));
        WebDriver driver = aramaSayfa.aramaSayfasiIslemleri();
        String aramaFiyati = aramaSayfa.aramaFiyati;
        BasketPage sepet = new BasketPage(driver);
        sepet.sepetİslemleri();

        int valueAtSearch = test.stringtoInt(aramaSayfa.aramaFiyati);
        int doubleValueAtSearch = 2*valueAtSearch;
        int valueAtBasket = test.stringtoInt(sepet.urunFiyat);
        int doubleValueAtBasket = test.stringtoInt(sepet.urunFiyat2);

        if(valueAtSearch== valueAtBasket &&
        doubleValueAtSearch == doubleValueAtBasket)
        {
            System.out.println("BAŞARILI!");
        }
        else
        {
            System.out.println("****HATA VAR!****");
            System.out.println("Sepet.urunfiyat:  "+valueAtBasket);
            System.out.println("aramaSayfa.aramaFiyati:  "+valueAtSearch);
            System.out.println("Integer.valueOf(sepet.urunFiyat2):  "+doubleValueAtBasket);
            System.out.println("Integer.valueOf(aramaSayfa.aramaFiyati)*2:  "+doubleValueAtSearch);
        }
        sepet.sepetTemizle();


    }
}
