package com.rg.framework.GMSpages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddUser {
	
	By AdduserLabel = By.xpath("//h3[text()='Add user']");
	By userName = By.id("UserName");
	By userID = By.id("UserID");
	By userEmail = By.id("UserEmail");
	By userPhone = By.id("UserPhone");
	By userBirthday = By.id("UserBday");
	By userCity = By.id("UserCity");
	By userAdress = By.id("UserAddr");
	By userRole = By.id("UserRole");
	By activeRadio = By.id("Active");
	By blockedRadio = By.id("Blocked");
	By submitBtn = By.id("ID_Sub");
	By clearBtn = By.xpath("//button[text()='Clear']");
	
	WebDriver driver;
	
	
	
	public AddUser(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public boolean verifyAddUser() {
		
		try {
			driver.findElement(AdduserLabel).isDisplayed();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public void enterUserName(String name) {
		
		driver.findElement(userName).sendKeys(name);
		
	}
	
	public void enterUserID(String ID) {
		
		driver.findElement(userID).sendKeys(ID);
		
	}
	
	public void enterEmail(String Email) {
		
		driver.findElement(userEmail).sendKeys(Email);
		
	}
	
	public void enterPhone(String Phone) {
		
		driver.findElement(userPhone).sendKeys(Phone);
		
	}
	//2017-03-08
	public void userBirthday(String DOB_YYYY_MM_DD) {
		
		driver.findElement(userBirthday).sendKeys(DOB_YYYY_MM_DD);
		
	}
	
	
	public boolean verifyCity(String cityName) {
			
		Select cities = new Select(driver.findElement(userCity));
		
		List<WebElement> actualCities = cities.getOptions();
		
		for (WebElement city :actualCities ) {
			
			if(city.getText().equals(cityName)) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public void selectUserCity(String city) {
		
		if(this.verifyCity(city)) {
			Select cities = new Select(driver.findElement(userCity));
			cities.selectByVisibleText(city);
		}
		
		else {
			
			System.out.println("invalid city");
			
		}
		
	}
	
	public void enterAdress(String Address) {
		
		driver.findElement(userAdress).sendKeys(Address);
		
	}
	
	public boolean verifyRole(String roleName) {
		
		Select roles = new Select(driver.findElement(userRole));
		
		List<WebElement> actualRoles = roles.getOptions();
		
		for (WebElement role :actualRoles ) {
			
			if(role.getText().equals(roleName)) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public void selectRole(String Role) {
		
		if(this.verifyRole(Role)) {
			Select roles = new Select(driver.findElement(userRole));
			roles.selectByVisibleText(Role);	
		}
		
		else {
			
			System.out.println("invalid role");
			
		}
	}
	
	
	public void selectActive() {
		
		WebElement active = driver.findElement(activeRadio);
		
		if(!active.isSelected()) {
			
			active.click();
		}
	}
	
	public void selectBlocked() {
		
		WebElement blocked = driver.findElement(blockedRadio);
		
		if(!blocked.isSelected()) {
			
			blocked.click();
		}
	}
	
	public void clickSubmit() {
		
		driver.findElement(submitBtn).submit();
	}
	
	public void clickClear() {
		
		driver.findElement(clearBtn).submit();
	}
	
	public void createUser(String name,String ID,String Email,String Phone,String DOB, String city, String Address, String Role) {
		
		this.enterUserName(name);
		this.enterUserID(ID);
		this.enterEmail(Email);
		this.enterPhone(Phone);
		this.userBirthday(DOB);
		this.selectUserCity(city);
		this.enterAdress(Address);
		this.selectRole(Role);
		this.selectActive();
		this.clickSubmit();
	}
	
	
	
}
