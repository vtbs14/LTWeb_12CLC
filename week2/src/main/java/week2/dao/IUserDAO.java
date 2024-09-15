package week2.dao;

import java.util.List;

import week2.model.UserModel;

public interface IUserDAO {
	List <UserModel> findAll();
	
	UserModel findById(int id);
	
	UserModel findbyUsername(String username);
	
	void insert(UserModel user);
	
	void register(UserModel user);
	
	UserModel login(String username, String password);
}
