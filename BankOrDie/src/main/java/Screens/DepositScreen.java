package Screens;

import java.util.Scanner;

import Daos.CurrentUser;
import Daos.UserDao;

public class DepositScreen implements Screen {



	CurrentUser loggedInUser = new CurrentUser();
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;

	@Override

	public Screen start() {
		User currentUser = loggedInUser.getCurrent();
		double balance;

		System.out.println("Enter your donation!");
		System.out.println("Current Holdings: " + currentUser.getBalance());
		
		String depositAmount = scan.nextLine();
		currentUser.setTransactionHistory(depositAmount);

		System.out.println(balance = Double.valueOf(depositAmount) + currentUser.getBalance());

		currentUser.setBalance(balance);

		ud.updateUser(currentUser);

		return this;
		
	}
	
}