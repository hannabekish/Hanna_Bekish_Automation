import googleCloud.GoogleCloudHomePage;
import googleCloud.GoogleCloudPlatformPricingCalculator;
import googleCloud.GoogleCloudSearchResultPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pastebin.PastebinHomePage;
import pastebin.SavedPaste;

public class GoogleCloudTests {
    private static final String text = "Google Cloud Platform Pricing Calculator";

    @Test
    public void checkGoogleCloud() {
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(new ChromeDriver());
        GoogleCloudPlatformPricingCalculator calculator = googleCloudHomePage.openPage()
                .enterSearchQuery(text)
                .redirectToGoogleCloudCalculator();
        calculator.closePage();

    }
}
