package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.NewPosts;
import page.objects.Post;
import page.tests.LoginTest;
import utility.Constant;
import utility.ExcelUtils;

public class NewPostTest {

	private static Scanner sc;

	// auto insert post data
	public static void autoEnterPost(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME_TXT);
		String autoDataArr[] = new String[5];
		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			// post title
			autoDataArr[0] = ExcelUtils.getCellData(i, 1);

			// post location
			autoDataArr[1] = ExcelUtils.getCellData(i, 2);

			// post image
			autoDataArr[2] = ExcelUtils.getCellData(i, 3);

			// post transport
			autoDataArr[3] = ExcelUtils.getCellData(i, 4);

			// post text
			autoDataArr[4] = ExcelUtils.getCellData(i, 0);

			// entering data to post
			enteringPostData(driver, autoDataArr);

		}
	}

	// treba da bude ulogovan user

	public static void enteringPostData(WebDriver driver, String dataArr[]) {
		if (driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL)) {
			int oldPostNo = Post.getPosts(driver).size();
			NewPosts.clickMakePostBtn(driver);
			NewPosts.clickPostTitleField(driver);
			NewPosts.insertPostTitle(driver, dataArr[0]);
			NewPosts.clickLocationField(driver);
			NewPosts.insertLocation(driver, dataArr[1]);
			NewPosts.insertImage(driver, dataArr[2]);
			NewPosts.getTransportField(driver, dataArr[3]);
			NewPosts.getPostTxtField(driver);
			NewPosts.insertPostTxt(driver, dataArr[4]);
			NewPosts.clickPostButton(driver);
			int newPostNo = Post.getPosts(driver).size();

			if (oldPostNo == newPostNo - 1)
				System.out.println("New post was successfully entered.");
			else
				System.out.println("Post was not enterd!");

		} else {
			System.out.println("You have to be logged in");
		}

	}

	// manual post insert data
	public static String[] malualPostData(WebDriver driver) {

		String[] scData = new String[5];
		sc = new Scanner(System.in);

		if (driver.getCurrentUrl().startsWith(Constant.HOME_URL))
			System.out.println("You have to be logged in to create post.");
		if (driver.getCurrentUrl().startsWith(Constant.WRONG_LOGIN_URL))
			System.out.println("Login was not successful.Wrong login data.");
		if (driver.getCurrentUrl().startsWith(Constant.DASHBOARD_URL)) {
			System.out.println("Please enter the requested information for new post:");
			// title
			System.out.println("Post title");
			scData[0] = sc.nextLine();
			// location
			System.out.println("Location");
			scData[1] = sc.nextLine();
			// image with extension
			System.out.println("Name of picture with extension, from Images folder");
			scData[2] = sc.nextLine();
			// transport
			System.out.println("Type of transport, car, motorbike,bicycle,bus,walk");
			scData[3] = sc.nextLine();
			// text
			System.out.println("Post text");
			scData[4] = sc.nextLine();
		}
		return scData;
	}
}
