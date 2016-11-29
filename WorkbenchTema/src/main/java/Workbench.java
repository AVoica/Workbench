import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by avoica on 11/23/2016.
 */
public class Workbench {

    @FindBy(xpath = "//*[@id='edit-name']")
    private WebElement userInput;

    @FindBy(xpath = "//*[@id='edit-pass']")
    private WebElement passInput;

    @FindBy(xpath = "//*[@id='edit-submit']")
    private WebElement loginButton;

    @FindBy(xpath ="//*[@id='toolbar-link-admin-people']")
    private WebElement peopleButton;

    @FindBy(xpath = "//*[@id='squeeze']/div/div/ul/li/a")
    private WebElement addUserButton;

    @FindBy(xpath = "//iframe[@class='overlay-element overlay-active']")
    private WebElement iframePeople;

    @FindBy(xpath="//*[@id='edit-name']")
    private WebElement usernameField;

    @FindBy(css = "#edit-mail")
    private WebElement emailField;

    @FindBy(css = "#edit-pass-pass1")
    private WebElement passwordField;

    @FindBy(css = "#edit-pass-pass2")
    private WebElement confirmPasswordField;

    @FindBy(css = "#edit-roles-3")
    private WebElement administratorCheck;

    @FindBy(css = "#edit-submit")
    private WebElement createNewAccount;

    public Workbench (WebDriver driver){
        WebDriver driver1 = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://192.168.100.125/drupal-7.15/");


    }

    public void login(String user,String pass){
        userInput.sendKeys(user);
        passInput.sendKeys(pass);
        loginButton.click();


    }

   public String getCurrentUrl(WebDriver driver){
       return driver.getCurrentUrl();
    }

    public void redirectToPagePeople() {
        peopleButton.click();

    }

    public void redirectToUserPage(WebDriver driver){
        driver.switchTo().defaultContent();
        //peopleContent.click();
        driver.switchTo().frame(iframePeople);
        System.out.println(driver.getTitle());
       WebDriverWait wait = new WebDriverWait(driver, 5);
      //  wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Add user")));
       // driver.findElement().click();


       addUserButton.sendKeys(Keys.ENTER);
        addUserButton.click();
    }

    public void addUser(WebDriver driver,String user, String mail, String pass,boolean isAdmin ) {
     //   peopleButton.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframePeople);
        System.out.println(driver.getTitle());
        addUserButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframePeople);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        System.out.println(driver.getTitle());
        usernameField.click();
        usernameField.sendKeys(user);
        emailField.sendKeys(mail);
        passwordField.sendKeys(pass);
        confirmPasswordField.sendKeys(pass);

        if(isAdmin == true) {
            administratorCheck.click();
        }
        createNewAccount.click();




        //driver.switchTo().defaultContent();
        //driver.switchTo().frame(iframePeople);


    }

    public void verifyUserWorkbench(WebDriver driver,String username, String email, String password, Boolean checkbox)  {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframePeople);
        System.out.println(driver.getTitle());
        usernameField.click();
        usernameField.sendKeys(username);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);

        if(checkbox == true) {
            administratorCheck.click();
        }
        createNewAccount.click();
        VerifyUser verifyUser = PageFactory.initElements(driver, VerifyUser.class);
        verifyUser.waitPageToLoad();
      //  return VerifyUser;


    }
}
