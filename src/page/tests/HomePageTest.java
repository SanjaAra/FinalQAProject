package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import utility.Constant;

public class HomePageTest {

	//test for opening correct home page
	public static void testHomePageUrl(WebDriver driver){
		HomePage.openHomePage(driver);
		if (driver.getCurrentUrl().startsWith(Constant.HOME_URL))
			System.out.println("Successful opening of home page " + Constant.HOME_URL);
		else
			System.out.println("Current page - " + driver.getCurrentUrl() + " required page - " + Constant.HOME_URL);
	}
	
	//go to the dashboard page, directly, without logging in
	public static void testNoLogginDashboard(WebDriver driver) {
		System.out.println("Navigate to Dashboard without loggin.");
		driver.navigate().to(Constant.DASHBOARD_URL);
		if(driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL))
			System.out.println("Bug - user must be logged in to go to dashboard.");
		else if(driver.getCurrentUrl().startsWith(Constant.HOME_URL))
			System.out.println("Correct - user is not logged in, and should remain at home page. ");
		else
			System.out.println("Check what is wrong.");
	}
}
