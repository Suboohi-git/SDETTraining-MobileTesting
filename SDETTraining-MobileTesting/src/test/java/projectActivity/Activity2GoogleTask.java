package projectActivity;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity2GoogleTask {
	
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
	public void loginPassTest() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));

    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
    	
    	//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"Login Form Please sign in.\"))")).click();
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(1).scrollIntoView(textStartsWith(\"Login Form\"))")).click();
    	//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"To-Do List\"))")).getText();
    	Thread.sleep(5000);
    	
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button")).click();
    	System.out.println("Invalid");
    	String getvalue = driver.findElement(MobileBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();

        Assert.assertEquals(getvalue, "Welcome Back, admin");
	}
	
	@Test
	public void loginFailTest() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));

    	driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
    	
    	//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"Login Form Please sign in.\"))")).click();
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(1).scrollIntoView(textStartsWith(\"Login Form\"))")).click();
    	//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"To-Do List\"))")).getText();
    	Thread.sleep(5000);
    	
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin1");
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("pasword1");
    	driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button")).click();
    	System.out.println("Invalid");
    	String getvalue = driver.findElement(MobileBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();

        Assert.assertEquals(getvalue, "Invalid Credentials");
        
		
	}
	
	@AfterTest
    public void tearDown() {
        driver.quit();
    }
  
}
