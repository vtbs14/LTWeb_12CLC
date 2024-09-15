package week2.service;

import week2.model.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel FindByUserNam(String username);
}
