package com.actitime.generic;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.Pom.EnterTimeTrackPage;
import com.actitime.Pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static	WebDriver driver;
	public Filelib f=new Filelib();
		@BeforeTest
		public void openBrowser() {
		Reporter.log("openBrowser",true);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		WebDriverCommonLib w=new WebDriverCommonLib();
		w.waitForPageLoadImplicit(driver);
		}
		@AfterTest
		public void closeBrowser() {
			Reporter.log("closeBrowser",true);	
			driver.close();
		}
		@BeforeMethod
		public void login() throws IOException {
		Reporter.log("login",true);	
		 Filelib f=new Filelib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");	
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
			
		}
		@AfterMethod
		public void logout() {
		Reporter.log("logout",true);	
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setLogout();
		}


}
