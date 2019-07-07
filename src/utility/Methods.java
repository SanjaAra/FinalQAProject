package utility;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.tests.DeletePostTest;
import page.tests.EditPostTest;
import page.tests.HomePageTest;
import page.tests.LoginTest;
import page.tests.NewPostTest;
import page.tests.RegistrationTest;

public class Methods {
	public static void manualTest(WebDriver driver) throws Exception {
		// TEST HOME PAGE
		HomePageTest.testHomePageUrl(driver);
		HomePageTest.testNoLogginDashboard(driver);
		// TEST MANUAL REGISTRTION AND LOGIN
		String dataArr[] = RegistrationTest.manualRegistationData();
		RegistrationTest.enteringRegistrationData(driver, dataArr);
		RegistrationTest.testRegistrationManual(driver, dataArr);
		// TEST MANUAL LOGIN
		LoginTest.enteringManualLoginData(driver, dataArr); // using data from manual registration test
		// LOGIN HELPER TO STAY LOGED
		LoginTest.helperLogin(driver, dataArr); // to stay logged in. using data from manual registration test
		// ENTERING MANUAL POST
		String postArr[] = NewPostTest.malualPostData(driver);
		NewPostTest.enteringPostData(driver, postArr);
		Thread.sleep(2000);
		// MANUAL POST EDIT
		EditPostTest.manualPostEdit(driver);
		System.out.println("Manual testing is over.");
		System.out.println("Have a nice day!\nMay the Java be with you :)");
	}

	public static void autoTest(WebDriver driver) throws Exception {
		// TEST HOME PAGE
		 HomePageTest.testHomePageUrl(driver);
		 HomePageTest.testNoLogginDashboard(driver);
		// TEST AUTO REGISTRATION AND LOGIN - ok
		 RegistrationTest.testAutoRegistationData(driver);
		// LOGIN HELPER TO STAY LOGED
		 LoginTest.helperAutoLogin(driver);
		// AUTO ENTERING POST -- ok
		 NewPostTest.autoEnterPost(driver);
		// AUTO DELETE POST
		 Thread.sleep(5000);
		 DeletePostTest.deleteFirstTwoPosts(driver);
		// AUTO POST EDIT
		 EditPostTest.autoPostEditData(driver);
		 System.out.println("Auto testing is over.");
			System.out.println("Have a nice day!\nMay the Java be with you :)");
	}
	
	public static void brainTest() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Brain test is very good choice.\nPlease follow next steps.");
		System.out.println("Enter your name and surname.");
		String name=sc.nextLine();
		System.out.println("Enter your credit card number.");
		String cardNo=sc.nextLine();
		System.out.println("Enter your CVV number.");
		String cvv=sc.nextLine();
		System.out.println("Now copy your data and paste it on Facebook.\nYour life will become very interesting :)");
		System.out.println("Data to copy:\nName: "+name+"\nCard number: "+cardNo+"\nCVV: "+cvv);
	}
	
	public static void defaultCase(WebDriver driver) throws Exception {
		System.out.println("Your computer will destroy in 3 seconds!");
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		Thread.sleep(1000);
		System.out.println("Auto testing ......");
		autoTest(driver);
	}
	
}
