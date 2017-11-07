package org.elsys.ip.servlet.service;

import java.util.ArrayList;
import java.util.List;

import org.elsys.ip.servlet.model.User;

public class UserService {
	private static List<User> users = new ArrayList<>();
	private static User loggedIn = null;
	public UserService() {

	}

	public List<User> getUsers() {
		return users;
	}

	public User getByName(String name) {
		if (name != null) {
			return users.stream().filter(u -> name.equals(u.getName())).findFirst().orElse(null);
		} else {
			return null;
		}
	}
	public void removeUser(User user){
		users.remove(user);
	}

	public static void addUser(int ID, String Name, String Email, String Password){
		users.add(new User(ID, Name, Email, Password));
	}
	public static User getLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(User loggedIn) {
		UserService.loggedIn = loggedIn;
	}
}
