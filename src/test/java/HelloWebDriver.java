import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HelloWebDriver {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        
        WebElement inputArea = driver.findElement(By.id("paste_code"));
        inputArea.sendKeys("Hello from WebDriver");
        
        WebElement pasteExpirationList = driver.findElement(By.xpath("//select[@name=\"paste_expire_date\"]"));
        Select select = new Select(pasteExpirationList);
        select.selectByVisibleText("10 Minutes");
        
        WebElement pasteNameArea = driver.findElement(By.name("paste_name"));
        pasteNameArea.sendKeys("helloweb");
        
        WebElement createNewPaste = driver.findElement(By.id("submit"));
        createNewPaste.click();
        driver.quit();

    }
}
