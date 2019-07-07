package start;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.*;
import page.tests.*;
import utility.*;

public class FinalTouch {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Choose which test case you want to use:");
		int testNo = sc.nextInt();

		try {

			switch (testNo) {
			case 1:
				Methods.manualTest(driver);
				break;
			case 2:
				Methods.autoTest(driver);
				break;
			case 3:
				Methods.brainTest();
				break;
			default:
				Methods.defaultCase(driver);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Thread.sleep(2000);
			driver.quit();
		}

	}

}
