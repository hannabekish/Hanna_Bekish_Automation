package pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedPaste extends PastebinHomePage {

    @FindBy (xpath = "//div[@class=\"paste_box_line1\"]")
    private WebElement title;

    @FindBy (xpath = "//span[@class=\"st0\"]")
    private WebElement searchMarkedCode;

    @FindBy (xpath = "//ol[@class=\"bash\"]")
    private WebElement searchForEnteredCode;


    public SavedPaste(WebDriver driver) {
        super(driver);
    }
    public SavedPaste quitPage(){
        driver.quit();
        return this;
    }
    public String getCodeColor(){
        return searchMarkedCode.getCssValue("color");
    }
    public String getEnteredCode(){
        return searchForEnteredCode.getText();
    }

    public String getTitle(){
        return title.getText();
    }
}
