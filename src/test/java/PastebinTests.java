import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pastebin.PastebinHomePage;
import pastebin.SavedPaste;

import java.util.concurrent.TimeUnit;

public class PastebinTests {
    private static String code = "git config --global user.name  \"New Sheriff in Town\"" + "\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" + "\n"
            + "git push origin master --force";
    private static String syntaxHighlight = "Bash";
    private static String pasteExpiration = "10 Minutes";
    private static String pasteName = "how to gain dominance among developers";
    private static String codeRedColor ="rgba(255, 0, 0, 1)";

@Test
    public void checkTitle() {
        PastebinHomePage pastebinPage = new PastebinHomePage(new ChromeDriver());
    SavedPaste savedPaste =
        pastebinPage.openPage()
                .writeCode(code)
                .selectBashFromList(syntaxHighlight)
                .selectPasteExpiration(pasteExpiration)
                .fillInPasteName(pasteName)
                .savePaste();
    Assert.assertEquals(savedPaste.getTitle(),pasteName);
        savedPaste.quitPage();

    }

    @Test
    public void checkBash() {
        PastebinHomePage pastebinPage = new PastebinHomePage(new ChromeDriver());
        SavedPaste savedPaste =
                pastebinPage.openPage()
                        .writeCode(code)
                        .selectBashFromList(syntaxHighlight)
                        .selectPasteExpiration(pasteExpiration)
                        .fillInPasteName(pasteName)
                        .savePaste();
        Assert.assertEquals(savedPaste.getCodeColor(),codeRedColor);
        savedPaste.quitPage();

    }

    @Test
    public void checkEnteredCode() {
        PastebinHomePage pastebinPage = new PastebinHomePage(new ChromeDriver());
        SavedPaste savedPaste =
                pastebinPage.openPage()
                        .writeCode(code)
                        .selectBashFromList(syntaxHighlight)
                        .selectPasteExpiration(pasteExpiration)
                        .fillInPasteName(pasteName)
                        .savePaste();
        Assert.assertEquals(savedPaste.getEnteredCode(),code);
        savedPaste.quitPage();

    }
}
