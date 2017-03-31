package com.rg.framework.GMSpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GMSHome {
	
	By GMShomelabel = By.className("logo-lg");
	By manageLabel = By.xpath("//span[text()='Manage']");
	By usersLabel = By.xpath("//span[text()='Users']");
	By locationLabel = By.xpath("//span[text()='Location']");
	
	WebDriver driver;
	
	public GMSHome(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean verifyHome() {
		
		try {
			driver.findElement(GMShomelabel).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void clickManage() {
		
		driver.findElement(manageLabel).click();
		
	}
	
	public void clickUsers() {
		
		driver.findElement(usersLabel).click();
		
	}
	
	
	public void clickLocation() {
		
		driver.findElement(usersLabel).click();
		
	}
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahul\\Desktop\\java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		driver.get("http://myadmin.veeretail.com/");
		
		GMSLogin login = new GMSLogin(driver);
		login.signIn("admin@admin.com","admin123");
		
		GMSHome home = new GMSHome(driver);
		//home.driver.findElement(home.GMShomelabel).isDisplayed();
		
		home.clickManage();
		home.clickUsers();
		AddUser adduser = new AddUser(driver);
		adduser.createUser("test","84314844121","test.test223@live.com","8431484412","1990-09-23","Adavvna","2/109","Advmin");
		
		
		
	}
	

}
