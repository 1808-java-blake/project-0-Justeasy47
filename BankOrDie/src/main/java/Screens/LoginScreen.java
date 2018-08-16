package Screens;

import java.util.Scanner;

import Beans.Users;
import Daos.UserDao;


public class LoginScreen implements Screen {
	private Scanner scan = new Scanner (System.in);
	private UserDao ud = UserDao.currentUserDao;
	//private Logger log = Logger.getRootLogger();
	
	@Override
	public Screen start() {
		
		System.out.println(" _______                       __    __         ______   _______         _______   __  ________ \r\n" + 
				"|       \\                     |  \\  /  \\       /      \\ |       \\       |       \\ |  \\|        \\\r\n" + 
				"| $$$$$$$\\  ______   _______  | $$ /  $$      |  $$$$$$\\| $$$$$$$\\      | $$$$$$$\\ \\$$| $$$$$$$$\r\n" + 
				"| $$__/ $$ |      \\ |       \\ | $$/  $$       | $$  | $$| $$__| $$      | $$  | $$|  \\| $$__    \r\n" + 
				"| $$    $$  \\$$$$$$\\| $$$$$$$\\| $$  $$        | $$  | $$| $$    $$      | $$  | $$| $$| $$  \\   \r\n" + 
				"| $$$$$$$\\ /      $$| $$  | $$| $$$$$\\        | $$  | $$| $$$$$$$\\      | $$  | $$| $$| $$$$$   \r\n" + 
				"| $$__/ $$|  $$$$$$$| $$  | $$| $$ \\$$\\       | $$__/ $$| $$  | $$      | $$__/ $$| $$| $$_____ \r\n" + 
				"| $$    $$ \\$$    $$| $$  | $$| $$  \\$$\\       \\$$    $$| $$  | $$      | $$    $$| $$| $$     \\\r\n" + 
				" \\$$$$$$$   \\$$$$$$$ \\$$   \\$$ \\$$   \\$$        \\$$$$$$  \\$$   \\$$       \\$$$$$$$  \\$$ \\$$$$$$$$\r\n" + 
				"                                                                                                \r\n" + 
				"                                                                                                \r\n" + 
				"                                                                                                \r\n" + 
				"");
		
		//log.debug("started login screen");
		System.out.println("Enter Soul Name or input NewbieShoes to sign up and join the cause");
		String userName = scan.nextLine();
		//log.trace("Username = " + userName);
		if ("NewbieShoes".equalsIgnoreCase(userName)) {
			return new RegisterUserScreen();
		}
		
		System.out.println("Enter Soul Key: ");
		String password = scan.nextLine();
		
		//log.debug("Recieved users credentials");
		Users currentUser = ud.findByUsernameAndPassword(userName, password);
		if (currentUser != null) {
			//log.info("User successfully logged in");
			return new HomeScreen();
		}
		
		System.out.println("Unable to login");
		return this;
		
	}

}
