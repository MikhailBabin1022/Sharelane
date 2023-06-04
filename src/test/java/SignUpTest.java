import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.PropertyUtils;


public class SignUpTest {

@Test
 public void zipCodeShouldAccept5Digits(){

    PropertyUtils System;
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get ("https://www.sharelane.com/cgi-bin/register.py");

    WebElement zipCodeInput =  driver.findElement(By.name("zip_code"));
    zipCodeInput.sendKeys("12345");

   WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
   continueButton.click();

    WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
    boolean isDisplayed = registerButton.isDisplayed();
   Assert.assertTrue(isDisplayed);


   driver.quit();


    }



    @Test
    public void zipCodeShouldAccept4Digits(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput =  driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[class=error_message]"));
        errorMessage.getText();
        String text = errorMessage.getText();
        Assert.assertEquals(text,"Oops, error on page. ZIP code should have 5 digits","Сообщение не отображается");

        driver.quit();

    }
}








