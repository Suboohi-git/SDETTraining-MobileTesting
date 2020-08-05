package projectActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1GoogleTask {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
	
	 @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 3 API 28");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 5);

	    }
	 
	 @Test
	 public void createTasks() throws InterruptedException {
		 Thread.sleep(5000);
		 
		 // Click on new task
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
		 
		 //Add First task
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")).sendKeys("Complete Activity with Google Tasks");
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
		 
		//Add Second task
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")).sendKeys("Complete Activity with Google Keep");
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
		 
		//Add Third task
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/tasks_fab\")")).click();
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_title\")")).sendKeys("Complete the second Activity Google Keep");
		 driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/add_task_done\")")).click();
		 
		 
	
		// Count the number of tasks on screen and validate there text
        
        List<MobileElement> numOfTasks= driver.findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")"));
        System.out.println("Total Number of Created Tasks: " + numOfTasks.size());
        System.out.println("Total Number of Created Tasks: " + numOfTasks.get(0).getText());
        System.out.println("Total Number of Created Tasks: " + numOfTasks.get(1).getText());
        System.out.println("Total Number of Created Tasks: " + numOfTasks.get(2).getText());
        Assert.assertEquals(numOfTasks.size(), 3);
        Assert.assertEquals(numOfTasks.get(0).getText(), "Complete the second Activity Google Keep");
        Assert.assertEquals(numOfTasks.get(1).getText(), "Complete Activity with Google Keep");
        Assert.assertEquals(numOfTasks.get(2).getText(), "Complete Activity with Google Tasks");
        
        
	 }
	 
	 
	 @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
  
}
