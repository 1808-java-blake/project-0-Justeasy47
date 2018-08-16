package Screens;

import java.util.Scanner;

import Beans.Users;
import Daos.CurrentUser;
import Daos.UserDao;

public class DepositScreen implements Screen {



	CurrentUser loggedInUser = new CurrentUser();
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() {
		Users currentUser = loggedInUser.getCurrent();
		int balance;

		System.out.println("Enter your donation!");
		System.out.println("Current Holdings: " + currentUser.getBalance());
		
		String depositAmount = scan.nextLine();
		currentUser.setTransactionHistory(depositAmount);

		System.out.println(balance = Integer.valueOf(depositAmount) + currentUser.getBalance());

		currentUser.setBalance(balance);

		ud.updateUser(currentUser);

		return this;
		
	}
	
}