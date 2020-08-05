package projectActivity;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3GoogleActivity3 {
	
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
	
	@BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.training-support.net/selenium");
    }
	
	@Test
	public void popValidLogin(){
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='Get Started!']")));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"Popups\"))")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Sign In']")));

    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']")).click();

    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");

    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password");

    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();

    	String getvalue = driver.findElement(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")).getText();

    	Assert.assertEquals(getvalue, "Welcome Back, admin");
	}
	
	@Test
	public void popinValidLogin(){
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='Get Started!']")));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"Popups\"))")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Sign In']")));

    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']")).click();

    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");

    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("pass");

    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Log in']")).click();

    	String getvalue = driver.findElement(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")).getText();

    	Assert.assertEquals(getvalue, "Invalid Credentials");
		
	}
	
	@AfterTest
    public void tearDown() {
        driver.quit();
    }
  
}
