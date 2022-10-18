package dataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\basicdata.properties");
		Properties p=new Properties();
		p.load(file);
		
		String URL=p.getProperty("Url");
		String SEARCH=p.getProperty("Search");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(SEARCH);
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();
		driver.close();
		
	}
}
