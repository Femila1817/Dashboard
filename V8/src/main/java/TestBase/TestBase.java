package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	try {
	prop = new Properties();
		FileInputStream fip = new FileInputStream("C:\\Users\\Femila\\eclipse-workspace\\V8\\src\\main\\java\\com\\test\\util\\config.properties");
		prop.load(fip);
	}
	catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	
	}
}

public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox")){
		driver = new FirefoxDriver();
	}else {
		System.out.println("No other browser is configured");
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}


}