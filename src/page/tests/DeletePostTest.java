package page.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.objects.Post;

public class DeletePostTest {

	// deleting first two posts or les, depending on how many are there
	public static void deleteFirstTwoPosts(WebDriver driver) {
		
		int postNo = Post.getEditablePosts(driver).size();
		int i = 0;
		int postNoRemain = 0;
		if (postNo >= 2) {
			for (; i < 2; i++) {
				Post.getEditablePosts(driver).get(0);
				Post.clickPostMenu(driver);
				Post.clickDeleteMenuBtn(driver);
			}
			postNoRemain = Post.getEditablePosts(driver).size();
			if (postNo - 2 == postNoRemain)
				System.out.println("Two posts are deleted successfully" + 
						"");

		} else if (postNo == 1) {
			for (; i < 2; i++) {
				Post.getEditablePosts(driver).get(0);
				Post.clickPostMenu(driver);
				Post.clickDeleteMenuBtn(driver);
			}
			postNoRemain = Post.getEditablePosts(driver).size();
			if (postNo - 1 == postNoRemain)
				System.out.println("One post is deleted successfully");
		} else
			System.out.println("You can only edit or delete your posts!");
	}

}