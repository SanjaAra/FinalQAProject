package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Constant;

public class NewPosts {

	private static final String MAKE_POST_BTN = "//a[contains(text(),'Make a post')]";
	private static final String POST_TITLE = "//input[@placeholder='Naziv']";
	private static final String LOCATION = "//input[@placeholder='Lokacija']";
	private static final String INSERT_IMG = "//input[@id='image']";
	private static final String TRANSPORT = "//div[@class='popupPost']//select[@name='transport']";
	private static final String POST_TXT = "//textarea[@placeholder='Opis']";
	private static final String POST_BTN = "//div[@class='popupPost']//input[@name='postSubmit']";

	// make a post button
	public static WebElement getMakePostBtn(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(MAKE_POST_BTN));
		return we;
	}

	public static void clickMakePostBtn(WebDriver driver) {
		getMakePostBtn(driver).click();
	}

	// post title
	public static WebElement getPostTitleField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(POST_TITLE));
		return we;
	}

	public static void clickPostTitleField(WebDriver driver) {
		getPostTitleField(driver).click();
	}

	public static void insertPostTitle(WebDriver driver, String s) {
		getPostTitleField(driver).sendKeys(s);
	}

	// post - location
	public static WebElement getLocationField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LOCATION));
		return we;
	}

	public static void clickLocationField(WebDriver driver) {
		getLocationField(driver).click();
	}

	public static void insertLocation(WebDriver driver, String s) {
		getLocationField(driver).sendKeys(s);
	}

	// browse image
	public static WebElement getBrowseImageField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(INSERT_IMG));
		return we;
	}

	public static void clickBrowseImageField(WebDriver driver) {
		getBrowseImageField(driver).click();
	}

	public static void insertImage(WebDriver driver, String s) {
		getBrowseImageField(driver).sendKeys(Constant.PATH_IMG + s);
	}

	// transport
	public static void getTransportField(WebDriver driver, String s) {
		Select transport = new Select(driver.findElement(By.xpath(TRANSPORT)));
		// transport.selectByVisibleText(s);
		transport.selectByValue(s);
	}

	// post text
	public static WebElement getPostTxtField(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(POST_TXT));
		return we;
	}

	public static void clickPostTxtField(WebDriver driver) {
		getPostTxtField(driver).click();
	}

	public static void insertPostTxt(WebDriver driver, String s) {
		getPostTxtField(driver).sendKeys(s);
	}

	// post button
	public static WebElement getPostButton(WebDriver driver)
	{
		WebElement we=driver.findElement(By.xpath(POST_BTN));
		return we;
	}
	
	public static void clickPostButton(WebDriver driver) {
		getPostButton(driver).click();
	}

}
