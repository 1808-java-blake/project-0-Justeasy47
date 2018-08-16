package Daos;

import Beans.Users;

public class CurrentUser {

	private static Users current;

	public void current(Users ud) {

		CurrentUser.current = ud;

	}

	public Users getCurrent() {

		return CurrentUser.current;

	}

}
