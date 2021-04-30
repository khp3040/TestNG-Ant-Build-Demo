package com.myapp.demo;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myapp.model.User;

public class UserMangerTest {

	UserManager um;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	@BeforeMethod
	public void setUp() throws Exception {
		um = new UserManager();
	}

	
	@AfterMethod
	public void tearDown() throws Exception {
		um =null;
	}

	@Test
	public void testAddUser() {
		Assert.assertTrue(um.addUser(new User("user0","pass0")));
	}

	@Test
	public void testGetUser() {
		User user = new User("user2","pass2");
		um.addUser(user);
		User existingUser = um.getUser("user2");
		Assert.assertEquals("user2",existingUser.getUsername());
		
	}

	@Test
	public void testNonExistingUser() {
		User user = new User("user3","pass3");
		um.addUser(user);
		User existingUser = um.getUser("user1");
		Assert.assertEquals("nouser",existingUser.getUsername());
		
	}
	
	@Test
	public void testDeleteUser() {
		User user = new User("user3","pass3");
		um.addUser(user);
		boolean result = um.deleteUser("user3");
		Assert.assertTrue(result);
	}

	@Test
	public void testGetall() {
		
		User user1 = new User("user3","pass3");
		um.addUser(user1);
		
		User user2 = new User("user4","pass4");
		um.addUser(user2);
		
		List<User> list= Arrays.asList(user1,user2);
		
		Assert.assertEquals(list, um.getall());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((um == null) ? 0 : um.hashCode());
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
		UserMangerTest other = (UserMangerTest) obj;
		if (um == null) {
			if (other.um != null)
				return false;
		} else if (!um.equals(other.um))
			return false;
		return true;
	}

}
