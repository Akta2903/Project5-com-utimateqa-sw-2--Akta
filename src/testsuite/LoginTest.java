package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before

    public void setBaseUrl()
    {
        openBrowser(baseUrl); // setting up the url
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully()
    {
        // finding the sign in element and clicking the same link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();

        //Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        WebElement actualMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessageText= actualMessage.getText(); // getting the text of above element


        Assert.assertEquals("User is not wel come Back page",expectedMessage,actualMessageText);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        // finding the sign in element and clicking the same link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();

        //finding and entering invalid username and password

        driver.findElement(By.id("user[email]")).sendKeys("Prime1234@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("Prime1234");

        //finding sign in button element and clicking the button
        driver.findElement(By.xpath("//button[contains(@class,'button button-primary g-recaptcha')]")).click();

        //verifying Invalid email or password is displayed or not
        String expectedMessage = "Invalid email or password.";
        WebElement actualMessage = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        //System.out.println(actualMessage);
        String actualMessageText= actualMessage.getText();

        Assert.assertEquals("Error message is not displayed",expectedMessage,actualMessageText);

    }

    @After

    public void tearDown()
    {
        closeBrowser(); // closing the browser
    }
}
