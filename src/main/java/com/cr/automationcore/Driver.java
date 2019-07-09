package com.cr.automationcore;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver extends TestCase {
	
	public static WebDriver driver;
	
	protected Datasheet data;
	protected Configuration conf;
	protected static WebDriverWait wait;
	
	public void setup(String strLocation,String strSheetName,String strBrowsers) throws Exception{
		String strBrowser = strBrowsers;
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	//	String AplicationEnvironment = System.getProperty("environment");
		
		data = Datasheet.getInstance();
		data.getDataSheet();
		data.setActiveSheet(strSheetName);
		try{
			conf = Configuration.getConfiguration();
			conf.getpropValues();
		}catch (IOException e) {
			System.out.println("Issues in properties file for Configuration");
		}
		
		try{
			if(strBrowser.equalsIgnoreCase("FF")){
				System.setProperty("webdriver.gecko.driver","./src/main/resources/Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
			}else if(strBrowser.equalsIgnoreCase("IE")){
				System.out.println("Setting up IE browser");
				cap=DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplorer");
				cap.setPlatform(Platform.WINDOWS);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			}else if(strBrowser.equalsIgnoreCase("Chrome")){
				cap=DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("disable-extensions");
				options.addArguments("--start-maximized");
				cap.setCapability(ChromeOptions.CAPABILITY,options);
				System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver.exe");
				driver=new ChromeDriver(options);
			}
			
			//driver=new RemoteWebDriver(new URL("http:/localhost:4444/wd/hub"),cap);
			//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,60);
			driver.get("https://msupplier.criticalriver.com/");
			
			
			
			
			/*switch (AplicationEnvironment){
			case "Dev":
				driver.get(Configuration.DevUrl);
				reportEvent.Status("Application opened with",Configuration.DevUrl,"pass");
				break;
			case "Test":
				driver.get(Configuration.TestUrl);
				reportEvent.Status("Application opened with",Configuration.TestUrl,"pass");
				break;
			case "Stage":
				driver.get(Configuration.StageUrl);
				reportEvent.Status("Application opened with",Configuration.StageUrl,"pass");
				break;
			default:
				reportEvent.Status("Aplication Issue","Environment Selection Problem usingSystem Variable","FAIL");
				break;
			}
			Thread.sleep(6000);*/
			driver.manage().window().maximize();
		}catch(Exception e){
			System.out.println("Issue in Browser Startup Review Driver or Start Grid and Nodes");
			System.out.println(e.toString());
		}
		
//		try{
//			or = ObjectRepository.getConfiguration();
//			or.getPropValues();
//		}catch (IOException e) {
//			System.out.println("Issues in Properties File for object Repository");
//		}
	
		}
}


