package Daos;

import Beans.Users;

public interface UserDao {
	public static final UserDao currentUserDao = UserSerializer.us;
	
	/**
	 * Takes in a user object and will persist that user
	 * 
	 * @param u
	 */
	void createUser(Users u);
	Users findByUsernameAndPassword(String username, String password);
	void updateUser(Users u);
	void deleteUser(Users u);

}
