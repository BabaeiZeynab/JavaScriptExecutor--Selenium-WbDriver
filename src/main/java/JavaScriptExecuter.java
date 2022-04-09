import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class JavaScriptExecuter {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "/Users/zeynabbabaei/Desktop/Selenium-WebDriver/BrowserDrivers/chromedriver100");
        

		driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
		driver.get("https://ui.freecrm.com/");
		
		
		
		
		
		//logIn icon

//		driver.findElement(By.linkText("Login")).click();

		//username
		driver.findElement(By.cssSelector("#ui > div > div > form > div > div:nth-child(1) > div > input[type=text]")).sendKeys("Your Email address");
        //password
      
       
       driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("Your Password");
		
 
		//logInbtn
		
		WebElement loginBTN = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
//		loginBTN.click();
		
	
			flash(loginBTN, driver);
		

	}
	
	
	
	public static void flash(WebElement element, WebDriver driver)  {
		JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
		String backgroundColor = element.getCssValue("background");
		for(int i=0; i<200; i++) {
			changeColor("rgb(0,100,0)", element, driver);
			changeColor(backgroundColor, element, driver);
		}
		
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
		//executeScript will execute javaScript code
		jsExecutor.executeScript("arguments[0].style.background = '"+ color+"'" , element);
		try {
			Thread.sleep(10);
			
		} catch (InterruptedException e) {
			 
			 e.printStackTrace();
			 
		}
	}
	
	
	
	
	

}
