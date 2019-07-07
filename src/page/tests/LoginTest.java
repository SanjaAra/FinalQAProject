package page.tests;

//import java.sql.Driver;
import java.util.Scanner;
import java.util.Random;
import org.openqa.selenium.WebDriver;

import page.objects.Login;
//import page.objects.Registration;
import utility.*;

public class LoginTest {

	// automate getting data from excel file, entering to Login fields and
	// user login and logout
	public static void autoLoginData(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME_REG);
		String autoDataArr[] = new String[2];
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum()+1; i++) {

			// username
			autoDataArr[0] = ExcelUtils.getCellData(i, 2);

			// password
			autoDataArr[1] = ExcelUtils.getCellData(i, 4);

			// entering data to Login fields and user login/logout
			enteringLoginData(driver, autoDataArr);
			System.out.println(i);
		}

	}

	// entering data to Login fields and user login nd logout for autoLoginData
	public static void enteringLoginData(WebDriver driver, String dataArr[]) throws Exception {

		// username
		Login.clickUserField(driver);
		Login.insertUser(driver, dataArr[0]);

		// password
		Login.clickPasswordField(driver);
		Login.insertPassword(driver, dataArr[1]);

		// click on login button
		Login.clickLoginButton(driver);

		if (driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL))
			System.out.println("Successful login.");
		else if(driver.getCurrentUrl().startsWith(Constant.WRONG_LOGIN_URL))
			System.out.println("Login was not successful.Wrong login data.");
		else
			System.out.println("Login was not successful.Check what went wrong.");

		Thread.sleep(1500);

		// logout
		Login.getLogoutButton(driver).click();
	}
	
	// entering data to Login fields and user login nd logout for manual data
	public static void enteringManualLoginData(WebDriver driver, String dataArr[]) throws Exception {

		// username
		Login.clickUserField(driver);
		Login.insertUser(driver, dataArr[2]);

		// password
		Login.clickPasswordField(driver);
		Login.insertPassword(driver, dataArr[4]);

		// click on login button
		Login.clickLoginButton(driver);

		if (driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL))
			System.out.println("Successful login.");
		else if(driver.getCurrentUrl().startsWith(Constant.WRONG_LOGIN_URL))
			System.out.println("Login was not successful.Wrong login data.");
		else
			System.out.println("Login was not successful.Check what went wrong.");

		Thread.sleep(1500);

		// logout
		Login.getLogoutButton(driver).click();
	}

	// getting manual data forom Consola
	public static String[] manualLoginData() {
		Scanner sc = new Scanner(System.in);

		String[] scData = new String[2];

		System.out.println("Please enter the requested information:");

		// username
		System.out.println("Enter username:");
		scData[0] = sc.nextLine();

		// password
		System.out.println("Enter password:");
		scData[1] = sc.nextLine();

		return scData;

	}

	// entering data to Login fields and user login without logout
	public static void helperLogin(WebDriver driver, String dataArr[]) throws Exception {
		Thread.sleep(3000);
		// username
		Login.clickUserField(driver);
		Login.insertUser(driver, dataArr[2]);

		// password
		Login.clickPasswordField(driver);
		Login.insertPassword(driver, dataArr[4]);

		// click on login button
		Login.clickLoginButton(driver);
		// Thread.sleep(1500);
		if (driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL))
			System.out.println("Successful login.");
		else if(driver.getCurrentUrl().startsWith(Constant.WRONG_LOGIN_URL))
			System.out.println("Login was not successful.Wrong login data.");
		else
			System.out.println("Login was not successful.Check what went wrong.");
	}

	//random auto login
	public static void helperAutoLogin(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME_REG);
		Random rand = new Random();
		int rows = ExcelUtils.getWorkSheet().getLastRowNum() - 2;
		int n = rand.nextInt(rows);

		// username
		String dataUser = ExcelUtils.getCellData(n + 1, 2);
		Login.clickUserField(driver);
		Login.insertUser(driver, dataUser);

		// password
		String dataPass = ExcelUtils.getCellData(n + 1, 4);
		Login.clickPasswordField(driver);
		Login.insertPassword(driver, dataPass);

		// click on login button
		Login.clickLoginButton(driver);
		Thread.sleep(1500);
		if (driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL))
			System.out.println("Successful login.");
		else if(driver.getCurrentUrl().startsWith(Constant.WRONG_LOGIN_URL))
			System.out.println("Login was not successful.Wrong login data.");
		else
			System.out.println("Login was not successful.Check what went wrong.");
	}
}
