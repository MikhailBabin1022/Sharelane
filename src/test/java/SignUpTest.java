import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTest {

@Test
 public void zipCodeShouldAccept5Digits(){
    // 1. Перейти на https://www.sharelane.com/cgi-bin/register.py
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get ("https://www.sharelane.com/cgi-bin/register.py");
    // 2. Ввести - 12345
    WebElement zipCodeInput =  driver.findElement(By.name("zip_code"));
    zipCodeInput.sendKeys("12345");
    // 3. Нажать на кнопку Continue
   WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
   continueButton.click();
    // 4. Убедится что мы перешли на страницу ввода данных пользователя
    WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
    boolean isDisplayed = registerButton.isDisplayed();
   Assert.assertTrue(isDisplayed);

    // 5. Закрыть браузер
   driver.quit();


    }



    @Test
    public void zipCodeShouldAccept4Digits(){
        //1. перейти на https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.sharelane.com/cgi-bin/register.py");
        // 2. Ввести - 1234
        WebElement zipCodeInput =  driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");
        // 3. Нажать на кнопку Continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        //4. убедиться что выводится ошибка на экране
        WebElement errorMessage = driver.findElement(By.cssSelector("[class=error_message]"));
        errorMessage.getText();
        String text = errorMessage.getText();
        Assert.assertEquals(text,"Oops, error on page. ZIP code should have 5 digits","Сообщение не отображается");
        //5. закрыть браузер
        driver.quit();

    }
}








