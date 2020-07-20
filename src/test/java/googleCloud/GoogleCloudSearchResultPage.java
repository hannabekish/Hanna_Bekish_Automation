package googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultPage extends GoogleCloudHomePage {

    @FindBy (xpath = "//div[@class=\"gs-title\"]/a/b[text()=\"Google Cloud Platform Pricing Calculator\"]")
    private WebElement googleCloudCalculatorLink;

    public GoogleCloudSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculator redirectToGoogleCloudCalculator(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .xpath("//div[@class=\"gs-title\"]/a/b[text()=\"Google Cloud Platform Pricing Calculator\"]")));
        googleCloudCalculatorLink.click();
        return new GoogleCloudPlatformPricingCalculator(driver);
    }


}
