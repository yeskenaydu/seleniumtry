package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class HomePage {

    private WebDriver driver;
    private By hesapButton = By.id("accountBtn");
    private By mailField = By.id("email");
    private By passwordField = By.id("password");
    private By girisButton = By.id("loginSubmit");
    private By onPopUp = By.className("fancybox-close");
    private By ikinciPopUp = By.className("modal-close");
    private By aramaKutusu = By.className("search-box");



    public  HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private void mailGir (String mail)
    {
        driver.findElement(mailField).sendKeys(mail);
    }

    private void sifreGir (String sifre)
    {
        driver.findElement(passwordField).sendKeys(sifre);
    }

    private void girisButonaBas ()
    {
        driver.findElement(girisButton).click();
    }
    private void hesapButonaBas ()
    {
        driver.findElement(hesapButton).click();
    }

    private void onPopUpKapa ()
    {
        try {
            driver.findElement(onPopUp).click();
        }
        catch (NoSuchElementException exception)
        {

        }
    }

    private void ikinciPopUpKapa()
    {
        try{
            driver.findElement(ikinciPopUp).click();
        }
        catch(NoSuchElementException exception)
        {

        }
    }

    private void aramaYap()
    {
        driver.findElement(aramaKutusu).sendKeys("Bilgisayar"+ Keys.ENTER);
    }

    public WebDriver anasayfaIslemleri(String mail,String password) throws InterruptedException {
        onPopUpKapa();
        Thread.sleep(500);
        hesapButonaBas();
        Thread.sleep(500);
        mailGir(mail);
        Thread.sleep(500);
        sifreGir(password);
        Thread.sleep(500);
        girisButonaBas();
        Thread.sleep(1000);
        ikinciPopUpKapa();
        Thread.sleep(500);
        aramaYap();
        return driver;
    }


}
