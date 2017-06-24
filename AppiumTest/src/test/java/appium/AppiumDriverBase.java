package appium;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumDriverBase {
	public int tempVar = 4723;
	public AndroidDriver driver;
    public WebDriverWait wait;
 
    //before Test Annotation makes a java function to run every time before a TestNG test case
    @BeforeTest
    protected void createAppiumDriver() throws MalformedURLException, InterruptedException {
 
    //relative path to apk file
    final File classpathRoot = new File(System.getProperty("user.dir"));
    final File appDir = new File(classpathRoot, "src/test/resources/apps/");
    final File app = new File(appDir, "customerapp-live-debug-431.apk");
 
    //setting up desired capability
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "SAMPLEUDID");
    caps.setCapability(CapabilityType.BROWSER_NAME, "Android");
    caps.setCapability(CapabilityType.VERSION, "5.0.2");
    caps.setCapability("platformName", "Android");
    caps.setCapability("appPackage", "com.anggadroid");
    caps.setCapability("appActivity", "com.anggadroid.SplashScreen");
    caps.setCapability("platformVersion", "5.0.2");
    caps.setCapability("app", app.getAbsolutePath());
 
    //initializing driver object
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
 
    //initializing explicit wait object
    wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void A(){
    	//here comes your code for element click, input, etc
    }
    
    //After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest(){
 
    //quit the driver
    driver.quit();
    }
}
