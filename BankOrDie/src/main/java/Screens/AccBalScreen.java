package Screens;

import java.util.Scanner;

import Beans.Users;
import Daos.CurrentUser;
import Daos.UserDao;

public class AccBalScreen implements Screen {

	CurrentUser loggedInUser = new CurrentUser();
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() {
		Users currentUser = loggedInUser.getCurrent();
		System.out.println("Donation to the cause:" + currentUser.getBalance());

		return this;



	}



}