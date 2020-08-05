package projectActivity;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2GoogleKeep {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);

    }
    
    @Test
    public void addANote() throws InterruptedException {
    	//Thread.sleep(5000);
    	// Click on new Note
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/new_note_button\")")).click();
    	
    	String strTitle="This is a Test Note title!";    	
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/editable_title\")")).sendKeys(strTitle);
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/edit_note_text\")")).sendKeys("This is a Test Notes Desc!!");
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("description(\"Navigate up\")")).click();
    	
    	//Assert        
        List<MobileElement> numOfNotes= driver.findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/index_note_title\")"));
        System.out.println("Total Number of Created Tasks: " + numOfNotes.size());
        System.out.println("Total Number of Created Tasks: " + numOfNotes.get(0).getText());
        
        Assert.assertEquals(numOfNotes.get(0).getText(), strTitle);
        
    	   	
    			 
    }
    
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
  
  
  

}
