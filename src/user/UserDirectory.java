package user;

import java.util.ArrayList;

public class UserDirectory {
	
	ArrayList<User> userDirectory;
	
	public UserDirectory() {
		this.userDirectory = new ArrayList<User>();
	}
	
	public User addNewUser(String userName, String passwd) {
		User user = new User(userName, passwd);
		userDirectory.add(user);
		return user;
	}
}
