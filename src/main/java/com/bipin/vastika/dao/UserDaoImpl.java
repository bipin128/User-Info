package com.bipin.vastika.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bipin.vastika.util.DBUtil;
import com.bipin.vastika.model.User;

public class UserDaoImpl implements UserDao {

	public static final String INSERT_SQl="insert into user_db(userName, password, email, mobileNo, dob)values(?,?,?,?,?)";
	public static final String UPDATE_SQl="update user_db set userName=?, password=?, email=?, mobileNo=?, dob=? where id=?";
	public static final String DELETE_SQl="delete from user_db where id=?";
	public static final String LIST_SQl="select * from user_db";
	public static final String GET_BY_ID_SQl="select * from user_db where id=?";

	@Override
	public int saveUserInfo(User user) {
		int saved = 0;
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_SQl);){

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setLong(4, user.getMobileNo());
			ps.setDate(5, new Date(user.getDob().getTime()));
			saved = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return saved;
	}

	@Override
	public int updateUserInfo(User user) {
		int updated = 0;
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_SQl);){

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setLong(4, user.getMobileNo());
			ps.setDate(5, new Date(user.getDob().getTime()));
			ps.setInt(6, user.getId());
			updated = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return updated;
	}

	@Override
	public int deleteUserInfo(int id) {
		int deleted = 0;
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQl);){

			ps.setInt(1, id);
			deleted = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return deleted;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_BY_ID_SQl);){

			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobileNo(rs.getLong("mobileNo"));
				user.setDob(rs.getDate("dob"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {

		List<User> userList = new ArrayList<>();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(LIST_SQl);){

			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobileNo(rs.getLong("mobileNo"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}