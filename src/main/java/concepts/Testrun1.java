package concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Testrun1 {
		WebDriver driver;
		@Before
		public void init() {
			System.setProperty("webdriver.edge.driver","/Users/khushbuchaudhary/Downloads/edgedriver_mac64/msedgedriver")
			;
			driver= new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/test/106/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void testrun() {
			//Validating when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON.
			driver.findElement(By.xpath("/html/body/div[3]/input[3]"));
			By ToggleAll =By.xpath("/html/body/div[3]/input[3]");
		    driver.findElement(ToggleAll).click();
		    Assert.assertTrue("All box isnot checked!!",driver.findElement(ToggleAll).isDisplayed());
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
			//using css selector Validating that a single list item could be removed using the remove button when a single checkbox is selected.
			driver.findElement(By.cssSelector("[name='data']")).sendKeys("jpg1");
			driver.findElement(By.cssSelector("[value='Add']")).click();
			driver.findElement(By.cssSelector("[name='data']")).sendKeys("jpg2");
			driver.findElement(By.cssSelector("[value='Add']")).click();
			
			//driver.findElement(By.cssSelector("[name='todo[6]']")).click();
			//removing one chceked box by remove button
			driver.findElement(By.xpath("/html/body/div[3]/input[1]")).click();
			By removebutton = By.xpath("/html/body/div[3]/input[1]");
			Assert.assertTrue("Button is clicked!!",driver.findElement(removebutton).isDisplayed());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			
		    
		    //Validating that all list item could be removed using the remove button and when "Toggle All" functionality is on.
		    driver.findElement(By.cssSelector("[name='allbox']"));
			By ToggleAll1 =By.cssSelector("[name='allbox']");
		    driver.findElement(ToggleAll1).click();
		    
		    driver.findElement(By.xpath("/html/body/div[3]/input[1]")).click();
		    By removebuttonforall = By.xpath("/html/body/div[3]/input[1]");
			Assert.assertTrue("All Button is clicked!!",driver.findElement(removebuttonforall).isDisplayed());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		@After
		public void teardown() {
			// driver.close();
			driver.quit();
			
			
			
			
		}
}
