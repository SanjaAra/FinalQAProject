package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USERNAME = "//div[@class='register_form']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//div[@class='register_form']//input[@name='password']";
	private static final String REG_BTN = "//input[@id='blue_btn']";


	// first name
	public static WebElement getFirstNameField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(FIRST_NAME));
		return we;
	}
	public static void clickFirstNameField(WebDriver driver) {
		getFirstNameField(driver).click();
	}
	public static void insertFirstName(WebDriver driver, String s) {
		getFirstNameField(driver).sendKeys(s);
	}

	// last name
	public static WebElement getLastNameField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LAST_NAME));
		return we;
	}
	public static void clickLastNameField(WebDriver driver) {
		getLastNameField(driver).click();
	}
	public static void insertLastName(WebDriver driver, String s) {
		getLastNameField(driver).sendKeys(s);
	}
	
	// username
	public static WebElement getUsernameField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(USERNAME));
		return we;
	}
	public static void clickUsernameField(WebDriver driver) {
		getUsernameField(driver).click();
	}
	public static void insertUsername(WebDriver driver, String s) {
		getUsernameField(driver).sendKeys(s);
	}
	
	// email
	public static WebElement getEmailField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(EMAIL));
		return we;
	}
	public static void clickEmailField(WebDriver driver) {
		getEmailField(driver).click();
	}
	public static void insertEmail(WebDriver driver, String s) {
		getEmailField(driver).sendKeys(s);
	}
	
	// password
	public static WebElement getPasswordField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(PASSWORD));
		return we;
	}
	public static void clickPasswordField(WebDriver driver) {
		getPasswordField(driver).click();
	}
	public static void insertPassword(WebDriver driver, String s) {
		getPasswordField(driver).sendKeys(s);
	}
	
	// registration button
		public static WebElement getRegButton(WebDriver driver) {
			WebElement we = driver.findElement(By.xpath(REG_BTN));
			return we;
		}
		public static void clickRegButton(WebDriver driver) {
			getRegButton(driver).click();
		}

}
