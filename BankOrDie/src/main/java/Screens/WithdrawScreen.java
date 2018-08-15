package Screens;

import java.util.Scanner;

import Daos.CurrentUser;
import Daos.UserDao;

public class WithdrawScreen implements Screen {

	CurrentUser loggedInUser = new CurrentUser();
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;

	@Override
	public Screen start() {
		User currentUser = loggedInUser.getCurrent();
		double balance;
		
		System.out.println("Withdraw At Your Own Discretion");
		System.out.println("Current Holdings: " + currentUser.getBalance());
		String withdrawAmount = scan.nextLine();

		if (Double.valueOf(withdrawAmount) > currentUser.getBalance()) {
			System.out.println("You don't bank? You Die!");
			Screen die = new DieScreen();
			die.start();

		} else {

			currentUser.setTransactionHistory("-" + withdrawAmount);
			System.out.println(withdrawAmount + currentUser.getBalance());
			System.out.println(balance = (-Double.valueOf(withdrawAmount)) + currentUser.getBalance());

			currentUser.setBalance(balance);

			ud.updateUser(currentUser);

		}

		return this;

	}



}