package projectActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1ChromeTodoList {
	
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
    public void toDoList() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	// wait for page to load    	
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button[@text='Get Started!']")));
        
        // clicking on Get Started button   // Commented below line as scroll forward itself does the job   
        //driver.findElementByXPath("//android.widget.Button[@text='Get Started!']").click();
        
        //Scroll and click on Todo List        
        String getText= driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollForward(2).scrollIntoView(textStartsWith(\"To-Do List\"))")).getText();
        System.out.println(getText); 
        
        driver.findElementByXPath("//android.view.View[starts-with(@text,'To-Do List')]").click();
        
        //Adding 1st task in todo list
        
    	Thread.sleep(5000);
    	
    	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Add tasks to list");
   	 	driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
   	 	
        //Adding 2nd task in todo list
        
   	 	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Get number of tasks");
   	 	driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
   	 	
        //Adding 3rd task in todo list
        
   	 	driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Clear the list");
   	 	driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
   	 	
        
        //Clicking on each task to strike out
   		     
        List<MobileElement> numofTasks= driver.findElements(MobileBy.xpath("//android.view.View[@resource-id=\"tasksList\"]"));
        System.out.println(numofTasks.size());
        for (int i = 0;i<numofTasks.size();i++) {
        	System.out.println(numofTasks.get(i).getText());
        	numofTasks.get(i).click();
        } 
        
        // Click on clear task
             
   	 	driver.findElement(MobileBy.xpath("//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]")).click();
   	 	driver.findElement(MobileBy.xpath("//android.view.View[@text,'Clear List']")).click();
        
        
    }
    
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
  
}
