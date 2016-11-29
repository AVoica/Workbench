import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by avoica on 11/24/2016.
 */
public class VerifyUser {

    private WebDriver webDriver;

    public VerifyUser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//ul[@id='toolbar-user']/li[2]/a")
    private WebElement logOutButton;

    public void verify() {
        logOutButton.click();
    }


    public void waitPageToLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
    }
}
