package week2.service;

import week2.model.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel FindByUserNam(String username);
	boolean register(String username, String password, String fullname, String email, String phone);
	
	boolean checkExistUsername(String username);
	boolean checkExistEmail(String email);
	boolean checkExistPhone(String phone);	
}
