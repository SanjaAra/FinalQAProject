package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;

public class Login {

	private static final String LOGIN_USER = "//input[@placeholder='username']";
	private static final String LOGIN_PASS = "//input[@placeholder='password']";
	private static final String LOGIN_BTN = "//input[@name='login']";
	private static final String LOGOUT_BTN = "//a[@id='logoutBtn']";

	// username
	public static WebElement getUserField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LOGIN_USER));
		return we;
	}

	public static void clickUserField(WebDriver driver) {
		getUserField(driver).click();
	}

	public static void insertUser(WebDriver driver, String s) {
		getUserField(driver).sendKeys(s);
	}

	// password
	public static WebElement getPasswordField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LOGIN_PASS));
		return we;
	}

	public static void clickPasswordField(WebDriver driver) {
		getPasswordField(driver).click();
	}

	public static void insertPassword(WebDriver driver, String s) {
		getPasswordField(driver).sendKeys(s);
	}

	// login button
	public static WebElement getLoginButton(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LOGIN_BTN));
		return we;
	}

	public static void clickLoginButton(WebDriver driver) {
		getLoginButton(driver).click();
	}

	//logout button
	public static WebElement getLogoutButton(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LOGOUT_BTN));
		return we;
	}
	
	public static void clickLogoutButton(WebDriver driver) {
		getLogoutButton(driver).click();
	}
	
	
}
