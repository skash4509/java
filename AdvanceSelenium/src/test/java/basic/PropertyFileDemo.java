package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileDemo 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\basicdata.properties");
		Properties  p=new Properties();
		p.load(file);
		
		String Ele = p.getProperty("browser");
		System.out.println(Ele);
	}
}
