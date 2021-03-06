package Daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Beans.Users;

public class UserSerializer implements UserDao {
	//private Logger log = Logger.getRootLogger();
	public static final UserSerializer us = new UserSerializer();
	
	private UserSerializer() {
		super();
	}
	
	@Override
	public void createUser(Users u) {
		if (u == null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUserName() + ".txt");
		System.out.println(f.getName());
		if (f.exists()) {
			return;
		}
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUserName() + ".txt"))){
		
			oos.writeObject(u);
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

}

	@Override
	public Users findByUsernameAndPassword(String userName, String password) {
		// Passed should not be null
		if (userName == null || password == null) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + userName + ".txt"))) {
			
			Users u = (Users) ois.readObject(); // retrieve the user if it can
			// Password = password verification
			if (password.equals(u.getPassword())) {
				return u;
			} else {
				return null;
			}
			
		} catch (FileNotFoundException e) {
			// e.printstackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateUser(Users u) {
		
		if (u == null) {

			return;

		}

		File f = new File("src/main/resources/user/" + u.getUserName() + ".txt");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
	}
	
	@Override
	public void deleteUser(Users u) {
		
		if (u == null) {
			
			return;

		}

		File f = new File("src/main/resources/user/" + u.getUserName() + ".txt");

		if (!f.exists()) {

			return;

		}

		f.delete();
		
	}

	@Override
	public Users findByUsername(String username) {

		if (username == null) {

			return null;

		}

		try (ObjectInputStream ois = new ObjectInputStream(
				// Find User
				new FileInputStream("src/main/resources/user/" + username + ".txt"))) {
			Users u = (Users) ois.readObject(); 
			return u;

		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");

		} catch (IOException e) {

			System.out.println("Input/Output Exception");

		} catch (ClassNotFoundException e) {

			System.out.println("Class Not Found");

		}

		return null;

	}
	
	
}