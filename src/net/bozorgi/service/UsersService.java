package net.bozorgi.service;

import java.util.List;

import net.bozorgi.dao.User;
import net.bozorgi.dao.UsersDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService {
	
	private UsersDAO usersDao;
	
	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
		System.out.println("UsersService set method is run.");
	}
	
	public void createUser(User user){
		usersDao.createUser(user);
		System.out.println("createUser method in usersService is run.");
	}

	public boolean exists(String username) {
		
		return usersDao.exists(username);
	}
	
	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}
	
	
	
	
}
