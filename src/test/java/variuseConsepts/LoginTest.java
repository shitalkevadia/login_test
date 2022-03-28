package variuseConsepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginTest {
	
	WebDriver driver;
	
	@Before
	public void init() { //Initialization
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		
		@Test
	public void loginTest() throws InterruptedException {
		
		//type variable = Value
		
		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement signinbuttonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		//WebElement dashboardHeaderElemet = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
		
		
		By userNameLocater = By.xpath("//input[@id='username']");
		By passwordLocator = By.xpath("//input[@id='password']"); 
		By signinbuttonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By dashboardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard')]");
		//By passwordElement
		//By dashboardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard')]");
		
		userNameElement.clear();//it will clear whatever the element contains
		userNameElement.sendKeys("demo@techfios.com");
		passwordElement.sendKeys("abs123");
		//signinbuttonElement.click();
		driver.findElement(signinbuttonLocator).click();
	     // dashboardHeaderLocator.click();
		Thread.sleep(2000);
		//driver.findElement(signinbuttonLocator).click();
		
		//WebElement dashboardHeaderElement = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
		boolean pagetitleDisplayStatus;
		try {
			WebElement dashboardHeaderElement = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
			
	        pagetitleDisplayStatus = true;
	        
		}catch(Exception e){
			pagetitleDisplayStatus  = false;
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderLocator));
		
		//WebElement dashboardHeaderElement = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
		
		Assert.assertTrue("Dashbord page not found", pagetitleDisplayStatus);
		
		//xpath is calle identifing element and send key is called operation
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		
		//driver.findElement(userNameLocater).sendKeys("demo@techfios.com");
	
		
	}	@After
		public void teardown() {
			driver.close();
			driver.quit();
		}
		
	}
	
	
	


