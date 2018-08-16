package Screens;

import java.util.Scanner;

import Beans.Users;
import Daos.CurrentUser;
import Daos.UserDao;

public class TransHistScreen implements Screen {

	CurrentUser loggedInUser = new CurrentUser();
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() {
		Users currentUser = loggedInUser.getCurrent();
		System.out.println("View transaction history");
		System.out.println("Deposit and Withdrawals: " + currentUser.getTransactionHistory().replaceAll("null,", ""));

		return this;

	}

}