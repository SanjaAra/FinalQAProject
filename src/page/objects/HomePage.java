package page.objects;

import org.openqa.selenium.WebDriver;

import utility.Constant;

public class HomePage {
	
	public static void openHomePage(WebDriver driver) {
		driver.get(Constant.HOME_URL);
	}

}
