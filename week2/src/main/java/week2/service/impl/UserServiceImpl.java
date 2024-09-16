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

	@Override
	public boolean register(String username, String password, String fullname, String email, String phone) {
	    if (userDao.checkExistUsername(username)) {
	        return false;
	    }

	    long millis = System.currentTimeMillis();
	    java.sql.Date date = new java.sql.Date(millis);

	    // Khởi tạo đối tượng UserModel và gán giá trị
	    UserModel user = new UserModel();
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setFullname(fullname);
	    user.setEmail(email);
	    user.setPhone(phone);
	    user.setCreateDate(date); // Nếu bạn có cột createDate trong cơ sở dữ liệu

	    userDao.insert(user);
	    return true;
	}


	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
	
}
