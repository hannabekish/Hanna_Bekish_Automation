package pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PastebinHomePage {
    private static final String PASTEBIN_LINK ="https://pastebin.com/";
    protected WebDriver driver;

    @FindBy (xpath = "//textarea[@class=\"paste_textarea\"]")
    private WebElement textArea;

    @FindBy (xpath = "//select[@name=\"paste_format\"]")
    private WebElement syntaxHighlightingList;

    @FindBy (xpath = "//select[@name=\"paste_expire_date\"]")
    private WebElement pasteExpirationList;

    @FindBy (xpath = "//input[@name=\"paste_name\"]")
    private WebElement pastNameInput;

    @FindBy (xpath = "//input[@name=\"submit\"]")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public PastebinHomePage openPage(){
        driver.get(PASTEBIN_LINK);
        return this;
    }
    public PastebinHomePage writeCode(String code){
        textArea.sendKeys(code);
        return this;
    }
    public PastebinHomePage selectBashFromList(String bash){
        Select select = new Select(syntaxHighlightingList);
        select.selectByVisibleText(bash);
        return this;
    }
    public PastebinHomePage selectPasteExpiration(String time){
        Select select = new Select(pasteExpirationList);
        select.selectByVisibleText(time);
        return this;
    }
    public PastebinHomePage fillInPasteName(String text){
        pastNameInput.sendKeys(text);
        return this;
    }
    public SavedPaste savePaste(){
        createNewPasteButton.click();
        return new SavedPaste(driver);
    }

}
