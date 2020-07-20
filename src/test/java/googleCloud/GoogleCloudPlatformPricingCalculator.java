package googleCloud;

import org.openqa.selenium.WebDriver;

public class GoogleCloudPlatformPricingCalculator extends GoogleCloudHomePage {


    public GoogleCloudPlatformPricingCalculator(WebDriver driver) {
        super(driver);
    }
    public GoogleCloudPlatformPricingCalculator closePage(){
        driver.quit();
        return this;
    }
}
