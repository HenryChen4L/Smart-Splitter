package application;

import java.util.ArrayList;

import user.User;
import user.UserDirectory;

public class Business {
	
	private UserDirectory userDirectory;
	private User currentUser;

	public Business() {
		this.userDirectory = new UserDirectory();
	}
	
	public void initialize() {
		User user1 = userDirectory.addNewUser("chen", "qwerqwer");
		User user2 = userDirectory.addNewUser("zhou", "rewqrewq");
		currentUser = user1;
	}
	
	//TODO
	public void login() {
	}

	public UserDirectory getUserDirectory() {
		return userDirectory;
	}

	public void setUserDirectory(UserDirectory userDirectory) {
		this.userDirectory = userDirectory;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
	
	
}
