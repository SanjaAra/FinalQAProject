package page.tests;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import page.objects.NewPosts;
import page.objects.Post;
import utility.Constant;
import utility.ExcelUtils;

public class EditPostTest {

	// manual test editing
	public static void manualPostEdit(WebDriver driver) throws Exception {

		int postNo = Post.getEditablePosts(driver).size();
		String oldTxt = Post.getPostTxt(driver);

		if (postNo > 0) {

			Post.getEditablePosts(driver).get(0);
			Post.clickPostMenu(driver);
			Post.clickEditMenuBtn(driver);

			String[] postArr = NewPostTest.malualPostData(driver);
			//edit title
			Post.clickEditPostTitle(driver);
			Post.insertEditPostTitle(driver, postArr[0]);
			//edit location
			Post.clickEditPostLocation(driver);
			Post.insertEditPostLocation(driver, postArr[1]);
			//edit img
			Post.insertEditImage(driver, postArr[2]);
			//edit transport
			Post.getEditTransport(driver, postArr[3]);
			//edit txt
			Post.getEditPostTxt(driver);
			Post.insertEditPostTxt(driver, postArr[4]);
			//post edit
			Post.clickEditPostButton(driver);

			String newTxt = Post.getPostTxt(driver);
			// test just for testarea
			if (oldTxt != newTxt) {
				System.out.println("Editing was successful!");
			} else {
				System.out.println("Editing wasn't successful!");
			}

		} else
			System.out.println("There is no post to edit!");
	}
	
	// auto test editing
	public static void autoPostEdit(WebDriver driver, String [] postArr) throws Exception {
		//String dataArr1[] = LoginTest.manualLoginData();
		//LoginTest.helperLogin(driver, dataArr1);
		
		int postNo = Post.getEditablePosts(driver).size();
		String oldTxt = Post.getPostTxt(driver);

		if (postNo > 0) {

			Post.getEditablePosts(driver).get(0);
			Post.clickPostMenu(driver);
			Post.clickEditMenuBtn(driver);

			//edit title
			Post.clickEditPostTitle(driver);
			Post.insertEditPostTitle(driver, postArr[0]);
			//edit location
			Post.clickEditPostLocation(driver);
			Post.insertEditPostLocation(driver, postArr[1]);
			//edit img
			Post.insertEditImage(driver, postArr[2]);
			//edit transport
			Post.getEditTransport(driver, postArr[3]);
			//edit txt
			Post.getEditPostTxt(driver);
			Post.insertEditPostTxt(driver, postArr[4]);
			//post edit
			Post.clickEditPostButton(driver);

			String newTxt = Post.getPostTxt(driver);
			// test just for testarea
			if (oldTxt != newTxt) {
				System.out.println("Editing was successful!");
			} else {
				System.out.println("Editing wasn't successful!");
			}

		} else
			System.out.println("There is no post to edit!");
	}
	
	//auto editing post data
	public static void autoPostEditData (WebDriver driver) throws Exception {
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_NAME_TXT);
		String autoDataArr[] = new String[5];

		Random rand = new Random();
		int rows = ExcelUtils.getWorkSheet().getLastRowNum() - 2;
		int n = rand.nextInt(rows);

			// post title
			autoDataArr[0] = ExcelUtils.getCellData(n+1, 1);

			// post location
			autoDataArr[1] = ExcelUtils.getCellData(n+1, 2);

			// post image
			autoDataArr[2] = ExcelUtils.getCellData(n+1, 3);

			// post transport
			autoDataArr[3] = ExcelUtils.getCellData(n+1, 4);

			// post text
			autoDataArr[4] = ExcelUtils.getCellData(n+1, 0);

			// entering data to post
			autoPostEdit(driver, autoDataArr);
	}

}
