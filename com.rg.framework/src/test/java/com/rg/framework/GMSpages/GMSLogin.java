package com.rg.framework.GMSpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GMSLogin {
	
	By loginId = By.id("email");
	By loginPassword = By.id("passwd");
	By signIn = By.id("login");
	
	WebDriver driver;
	
	public GMSLogin(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	
	public void enterLoginID (String loginid) {
		
		driver.findElement(loginId).sendKeys(loginid);
		
	}
	
	public void enterPassword (String password) {
		
		driver.findElement(loginPassword).sendKeys(password);
		
	}
	
	public void clickSignIn () {
		
		driver.findElement(signIn).click();
	}
	
	
	public void signIn (String loginid, String password ) {
		
		this.enterLoginID(loginid);
		this.enterPassword(password);
		this.clickSignIn();
		
	}
	
	/*
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahul\\Desktop\\java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		driver.get("http://myadmin.veeretail.com/");
		
		GMSLogin login = new GMSLogin(driver);
		login.signIn("admin@admin.com","admin123");
		
	}
	
	*/

}
