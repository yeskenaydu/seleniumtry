package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage {
    private WebDriver driver;
    private By urunFiyatElement = By.className("pb-basket-item-price");
    private By urunArttirElement = By.className("ty-numeric-counter-button");
    public String urunFiyat;
    public String urunFiyat2;

    public BasketPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private void urunFiyatBul()
    {
        String[] liste = driver.findElement(urunFiyatElement).getText().split("\\r?\\n");
        System.out.println(liste.length);
        int k= 0;
        for(String li : liste)
        {
            k++;
        }
        System.out.println("1 ürün fiyatı:"+liste[k-1]);
        urunFiyat = liste[k-1];
    }

    private void urunArttir()
    {
        driver.findElements(urunArttirElement).get(1).click();
    }

    private void urunFiyatBul2()
    {
        String[] liste = driver.findElement(urunFiyatElement).getText().split("\\r?\\n");
        System.out.println(liste.length);
        int k= 0;
        for(String li : liste)
        {
            k++;
        }
        System.out.println("2 ürün fiyatı:"+liste[k-1]);
        urunFiyat2 = liste[k-1];
    }

    public WebDriver sepetİslemleri() throws InterruptedException {
        Thread.sleep(1500);
        urunFiyatBul();
        Thread.sleep(1000);
        urunArttir();
        Thread.sleep(1000);
        urunFiyatBul2();
        return driver;
    }



}
