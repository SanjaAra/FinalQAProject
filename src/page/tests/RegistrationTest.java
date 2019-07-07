package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.Login;
import page.objects.Registration;
import utility.*;

public class RegistrationTest {

	// automate getting data from excel file, entering to Registration, and
	// registration of user
	public static void testAutoRegistationData(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME_REG);
		String autoDataArr[] = new String[5];
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {

			// first name
			autoDataArr[0] = ExcelUtils.getCellData(i, 0);

			// last name
			autoDataArr[1] = ExcelUtils.getCellData(i, 1);

			// username
			autoDataArr[2] = ExcelUtils.getCellData(i, 2);

			// email
			autoDataArr[3] = ExcelUtils.getCellData(i, 3);

			// password
			autoDataArr[4] = ExcelUtils.getCellData(i, 4);

			// entering data to Registration fields and registration of user
			enteringRegistrationData(driver, autoDataArr);

		}
		//TEST AUTO LOGIN
		LoginTest.autoLoginData(driver);

	}

	// entering data to Registration fields and registration of user
	//for manual and autamated testing
	public static void enteringRegistrationData(WebDriver driver, String dataArr[]) {

		// first name
		Registration.clickFirstNameField(driver);
		Registration.insertFirstName(driver, dataArr[0]);

		// last name
		Registration.clickLastNameField(driver);
		Registration.insertLastName(driver, dataArr[1]);

		// username
		Registration.clickUsernameField(driver);
		Registration.insertUsername(driver, dataArr[2]);

		// email
		Registration.clickEmailField(driver);
		Registration.insertEmail(driver, dataArr[3]);

		// password
		Registration.clickPasswordField(driver);
		Registration.insertPassword(driver, dataArr[4]);

		// click on registration button
		Registration.clickRegButton(driver);
	}

	// getting manual data forom Consola
	public static String[] manualRegistationData() {
		Scanner sc = new Scanner(System.in);

		String[] scData = new String[5];

		System.out.println("Please enter the requested information:");
		// first name
		System.out.println("Enter first name:");
		scData[0] = sc.nextLine();

		// last name
		System.out.println("Enter last name:");
		scData[1] = sc.nextLine();

		// username
		System.out.println("Enter username:");
		scData[2] = sc.nextLine();

		// email
		System.out.println("Enter email:");
		scData[3] = sc.nextLine();

		// password
		System.out.println("Enter password:");
		scData[4] = sc.nextLine();

		return scData;

	}

	// REGISTRATION TEST for manual testing
	//loggin in and out of registrated user
	//take data from - manualRegistationData()
	public static void testRegistrationManual(WebDriver driver, String dataArr[]) throws Exception {
		Thread.sleep(1500);
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
		else
			System.out.println("Login was not successful");
		
		Thread.sleep(1500);
		
		// logout
		Login.clickLogoutButton(driver);
	}

}
