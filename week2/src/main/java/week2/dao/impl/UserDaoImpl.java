package week2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import week2.configs.DBConnectMySQL;
import week2.configs.DBConnectSQL;
import week2.dao.IUserDAO;
import week2.model.UserModel;

public class UserDaoImpl implements IUserDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = new DBConnectSQL().getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getString("email"), rs.getString("images"), rs.getString("phone"),
						rs.getInt("roleid"), rs.getDate("createDate")));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findbyUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			conn = new DBConnectSQL().getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		try {
			conn = new DBConnectSQL().getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setImages(rs.getString("images"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // Return the populated user model or null if not found
	}

	@Override
	public void insert(UserModel user) {
		String sql = "insert into users(id, username, password, fullname, email, images, phone, roleid, createDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBConnectSQL().getConnectionW();
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


	public static void main(String[] args) {
		try {
			IUserDAO userDao = new UserDaoImpl();
			List<UserModel> users = userDao.findAll();
			
			for (UserModel user : users) {
				System.out.println(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
