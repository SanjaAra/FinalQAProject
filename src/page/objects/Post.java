package page.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utility.Constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Post {
	private static String POST_DIV = "posts"; // class name
	private static String POST_MENU = "fa-ellipsis-v"; // class name Font Awesome
	private static String EDIT_POST_IN_MENU = "fa-edit"; // class name Font Awesome
	private static String DELETE_POST_IN_MENU = "fa-trash-alt"; // class name Font Awesome
	
	//edit post xPaths
	private static String EDIT_TITLE="//input[@id='title']";
	private static String EDIT_LOCATION ="//input[@id='location']";
	private static String EDIT_IMAGE = "//input[@id='editImage']";
	private static String EDIT_TRANSPORT = "//select[@id='transport']";
	private static String EDIT_TEXT="//textarea[@id='description']";
	private static String EDIT_POST_BTN="//div[@class='popupEdit']//input[@name='postSubmit']";
	

	// list of all posts
	public static List<WebElement> getPosts(WebDriver driver) {
		List<WebElement> allPostList = driver.findElements(By.className(POST_DIV));
		return allPostList;
	}
		
	// list of editable posts
	public static List<WebElement>  getEditablePosts(WebDriver driver) {
		List<WebElement> editablePosts = driver.findElements(By.className(POST_MENU));
		return editablePosts;
	}
	//post menu
	public static void clickPostMenu(WebDriver driver) {
		getEditablePosts(driver).get(0).click();
	}
	
	//edit post menu
	public static WebElement getEditMenuBtn(WebDriver driver) {
		WebElement we= driver.findElement(By.className(EDIT_POST_IN_MENU));
		return we;
	}

	public static void clickEditMenuBtn(WebDriver driver) {
		getEditMenuBtn(driver).click();
	}
	
	//delete post button
	public static WebElement getDeleteMenuBtn(WebDriver driver) {
		WebElement we = driver.findElement(By.className(DELETE_POST_IN_MENU));
		return we;
	}
	
	public static void clickDeleteMenuBtn (WebDriver driver) {
		getDeleteMenuBtn(driver).click();
	}
	
	//edit title
	public static WebElement getEditPostTitle(WebDriver driver) {
		WebElement we=driver.findElement(By.xpath(EDIT_TITLE));
		return we;
	}
	
	public static void clickEditPostTitle(WebDriver driver) {
		getEditPostTitle(driver).click();
	}
	
	public static void insertEditPostTitle(WebDriver driver, String s) {
		getEditPostTitle(driver).clear();
		getEditPostTitle(driver).sendKeys(s);
	}
	
	//edit location
	public static WebElement getEditPostLocation(WebDriver driver) {
		WebElement we=driver.findElement(By.xpath(EDIT_LOCATION));
		return we;
	}
	
	public static void clickEditPostLocation(WebDriver driver) {
		getEditPostLocation(driver).click();
	}
	
	public static void insertEditPostLocation(WebDriver driver, String s) {
		getEditPostLocation(driver).clear();
		getEditPostLocation(driver).sendKeys(s);
	}
	//edit image
	public static WebElement getEditImage(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(EDIT_IMAGE));
		return we;
	}

	public static void clickChangeImage(WebDriver driver) {
		getEditImage(driver).click();
	}

	public static void insertEditImage(WebDriver driver, String s) {
		getEditImage(driver).sendKeys(Constant.PATH_IMG + s);
	}
	
	// edit transport
	public static void getEditTransport(WebDriver driver, String s) {
		Select transport = new Select(driver.findElement(By.xpath(EDIT_TRANSPORT)));
		transport.selectByValue(s);

	}

	// edit post text
	public static WebElement getEditPostTxt(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(EDIT_TEXT));
		return we;
	}

	public static void clickEditPostTxt(WebDriver driver) {
		getEditPostTxt(driver).click();
	}

	public static void insertEditPostTxt(WebDriver driver, String s) {
		getEditPostTxt(driver).clear();
		getEditPostTxt(driver).sendKeys(s);
	}

	public static String getPostTxt(WebDriver driver) {
		String txt=getEditPostTxt(driver).getAttribute("value");
		return txt;
	}
	
	// edit post button
	public static WebElement getEditPostButton(WebDriver driver)
	{
		WebElement we=driver.findElement(By.xpath(EDIT_POST_BTN));
		return we;
	}
	
	public static void clickEditPostButton(WebDriver driver) {
		getEditPostButton(driver).click();
	}
	
}
