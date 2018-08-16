package Screens;

import java.util.Scanner;

import Beans.Users;
import Daos.UserDao;

public class RegisterUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	
	@Override
	public Screen start() {
		Users u = new Users();
		System.out.println("Enter new Soul Name");
		u.setUserName(scan.nextLine());
		System.out.println("Enter Soul Key");
		u.setPassword(scan.nextLine());
		System.out.println("Enter first name");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter last name");
		u.setLastName(scan.nextLine());

		ud.createUser(u);
		
		return new LoginScreen();
	}

}
