package googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pastebin.PastebinHomePage;

public class GoogleCloudHomePage {
        private static final String GOOGLECLOUD_URL ="https://cloud.google.com/";
        protected WebDriver driver;

        @FindBy (xpath = "//input[@name=\"q\"]")
        private WebElement searchBox;

        @FindBy (xpath = "//devsite-search[@style=\"transform: translate3d(0px, 0px, 0px);\"]")
        private WebElement searchInputField;

        public GoogleCloudHomePage(WebDriver driver){
                this.driver=driver;
                PageFactory.initElements(driver,this);
        }

        public GoogleCloudHomePage openPage(){
                driver.get(GOOGLECLOUD_URL);
                return this;
        }
        public GoogleCloudSearchResultPage enterSearchQuery(String text){
                new WebDriverWait(driver, 10)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By
                                        .xpath("//input[@name=\"q\"]")));
                searchBox.click();
                searchBox.sendKeys(text);
                searchBox.submit();
                return new GoogleCloudSearchResultPage(driver);
        }


}
