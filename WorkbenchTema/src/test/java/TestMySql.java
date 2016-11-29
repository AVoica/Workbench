import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by avoica on 11/23/2016.
 */
public class TestMySql {

      Workbench page;
      WebDriver driver;

    @Before
    public void before(){
        driver = new FirefoxDriver();
        page = PageFactory.initElements(driver, Workbench.class);
    }

    @Test
    public void openpage() {


    }
    @Test
    public void login()
    {
        //1.	Create a test with 2 parameters ( user and password ) that will be used for login . Assert from UI that the login was successful .

         page.login("admin","admin_pass");
         Assert.assertEquals("http://192.168.100.125/drupal-7.15/?q=node",page.getCurrentUrl(driver));


    }

    @Test
    public void createUser()

    {
        //2.	Create a test with 4 parameters (user , password,email, roles ) that will be used to create a new user.
        // After the user is created login and assert that the user it’s created with the right role and user info.
        // The test will be used to create two users : one with normal role , other with admin role
        page.login("admin","admin_pass");
        page.redirectToPagePeople();
        page.redirectToUserPage(driver);

        //Workbench workbench = PageFactory.initElements(driver, Workbench.class);

        page.addUser(driver,"AndraAdmin", "andra_admin@test.com", "test", true);
        page.addUser(driver,"AndraUser", "andra_user@test.com", "test", false);



    }
//test ver user

}
