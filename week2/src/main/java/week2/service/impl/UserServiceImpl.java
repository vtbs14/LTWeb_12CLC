package week2.service.impl;

import week2.dao.IUserDAO;
import week2.dao.impl.UserDaoImpl;
import week2.model.UserModel;
import week2.service.IUserService;

public class UserServiceImpl implements IUserService {
	// lấy toàn bộ hàm của tầng Dao của user
	IUserDAO userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserNam(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserNam(String username) {
		return userDao.findbyUsername(username);
	}
}
