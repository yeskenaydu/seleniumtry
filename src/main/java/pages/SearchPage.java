package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchPage {

    private WebDriver driver;
    private By urunler = By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div");
    private By urunFiyatlari;
    private By sepeteEkle;
    private By sepet = By.id("myBasketListItem");
    private int secilenUrun;
    public String aramaFiyati;


    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private void urunSec()
    {
        Random random = new Random();
        secilenUrun = random.nextInt(23)+1;
    }

    private void urunDondur()
    {
       String s =  "//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div" +
               "["+ String.valueOf(secilenUrun) +"]/div[1]/a/div[3]/div[2]/div/div/div";
       urunFiyatlari = By.xpath(s);
    }

    private void buttonDondur()
    {
        String s = "//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div["+
                String.valueOf(secilenUrun) +"]/div[1]/div[2]/button";
        sepeteEkle = By.xpath(s);
    }

    private void fiyatBul()
    {
        List<WebElement> fiyatlar = driver.findElements(urunFiyatlari);
        if(fiyatlar.size()==2)
            aramaFiyati=fiyatlar.get(1).getText();
        else
        {
            aramaFiyati = driver.findElement(urunFiyatlari).getText();
        }
    }

    private void sepeteEkleBas()
    {
        driver.findElement(sepeteEkle).click();
    }

    private void sepeteGit() throws InterruptedException {
        try
        {
            driver.findElement(sepet).click();
        }
        catch (ElementClickInterceptedException exception)
        {
            driver.get("https://www.trendyol.com/sepetim#/basket");
        }
    }

    public WebDriver aramaSayfasiIslemleri () throws InterruptedException {
        urunSec();
        Thread.sleep(500);
        urunDondur();
        Thread.sleep(500);
        buttonDondur();
        Thread.sleep(500);
        fiyatBul();
        Thread.sleep(500);
        sepeteEkleBas();
        Thread.sleep(500);
        sepeteGit();
        System.out.println("Secilen urun:"+ secilenUrun+"  Fiyat:"+aramaFiyati);
        return driver;

    }
}
