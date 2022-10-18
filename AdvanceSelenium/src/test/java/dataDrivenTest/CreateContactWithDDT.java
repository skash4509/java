package dataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithDDT 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\basicdata.properties");
		Properties pros=new Properties();
		pros.load(file);
		String BROWSER = pros.getProperty("browser");
		String URL=pros.getProperty("url");
		String USERNAME=pros.getProperty("username");
		String PASSWORD=pros.getProperty("password");
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("=== "+BROWSER+" is launched ===");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("=== "+BROWSER+" is launched ===");
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.close();
		
		
	}
}
