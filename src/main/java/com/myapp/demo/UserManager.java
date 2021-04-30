package com.myapp.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.myapp.model.User;

public class UserManager {
	private Map<String, User> userStorage;

	public UserManager() {
		
		userStorage = new HashMap<>();
	}
	
	public boolean addUser(User user) {
        
		userStorage.putIfAbsent(user.getUsername(), user);
        
		return user != null;
    }
	
	public User getUser(String username) {
		return userStorage.getOrDefault(username, new User("nouser","nopass"));
	}
	
	public boolean deleteUser(String username) {
		User user = userStorage.remove(username);
		
		if(user != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Collection<User> getall(){
		return userStorage.values();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userStorage == null) ? 0 : userStorage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserManager other = (UserManager) obj;
		if (userStorage == null) {
			if (other.userStorage != null)
				return false;
		} else if (!userStorage.equals(other.userStorage))
			return false;
		return true;
	}
	
	
}
