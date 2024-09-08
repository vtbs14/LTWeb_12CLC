package week2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import week2.configs.DBConnectMySQL;
import week2.dao.IUserDAO;
import week2.model.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getString("email"), rs.getString("images")));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		UserModel user = null;

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setImages("images");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources (ResultSet, PreparedStatement, Connection) in a finally block
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user; // Return the populated user model or null if not found
	}

	@Override
	public void insert(UserModel user) {
		String sql = "insert into users(id, username, password, fullname, email, images) values (?, ?, ?, ?, ?, ?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getImages());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void register(UserModel user) {
		String sql = "insert into users (username, password, fullname, email, images) values (?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getImages());

			int kq = ps.executeUpdate();
			if (kq > 0) {
				System.out.println("Dang ki thanh cong");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserModel login(String username, String password) {
		String sql = "select * from users where username = ? and password = ?";
		UserModel user = null;
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setImages(rs.getString("images"));

				System.out.println("Dang nhap thanh cong");
			} else {
				System.out.println("Sai username hoac password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Chon 1 hoac 2!");
		System.out.println("1. Register");
		System.out.println("2. Login");

		int lc = scanner.nextInt();
		scanner.nextLine();
		if (lc == 1) {
			System.out.println("Bat dau dang ki:");
			System.out.print("Username: ");
			String username = scanner.nextLine();

			System.out.print("Password: ");
			String password = scanner.nextLine();

			System.out.print("Fullname: ");
			String fullname = scanner.nextLine();

			System.out.print("Email: ");
			String email = scanner.nextLine();

			UserModel newUser = new UserModel(0, username, password, fullname, email, "");
			userDao.register(newUser);
		} else if (lc == 2) {
			System.out.print("username: ");
			String username = scanner.nextLine();

			System.out.print("password: ");
			String password = scanner.nextLine();

//dang nhap thu
			UserModel loggedInUser = userDao.login(username, password);

			if (loggedInUser != null) {
				System.out.println("Hello, " + loggedInUser.getFullname() + "!");
			}
		} else {
			System.out.println("Khong dung. Hay chon 1 hoac 2.");
		}

		//userDao.insert(new UserModel(100, "hanni", "abc", "hanni pham", "thaomepp@gmail.com", ""));

		System.out.print("\nEnter user ID to search: ");
		int id = scanner.nextInt();

		UserModel users = userDao.findById(id);
		if (users != null) {
			System.out.println("\nUser found: " + users);
		} else {
			System.out.println("\nUser with ID " + id + " not found.");
		}

		scanner.close();
		List<UserModel> list = userDao.findAll();
		for (UserModel user : list) {
			System.out.println(user);
		}
	}

}
