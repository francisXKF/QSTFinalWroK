package com.qst.francis.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.util.ConcurrentCache;

import com.qst.francis.dao.UserDao;
import com.qst.francis.pojo.User;
import com.qst.francis.util.*;

public class UserDaoImpl implements UserDao{
	private JDBCConnection jdbcconnection = new JDBCConnection();
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	private String tb_name = "sd_user";
	
	@Override
	public boolean login(String user_name, String user_password) {
		boolean flag = false;
		String sqlString = String.format("select * from %s where user_name=? and user_password=? and user_state=0", 
						tb_name);
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, user_name);
			preparedStatement.setString(2, user_password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user login failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(resultSet, preparedStatement);
		}
		
		return flag;
	}

	@Override
	public boolean register(User user) {
		boolean flag = false;
		String sqlString = String.format("insert into %s(USER_NAME, USER_PASSWORD, USER_TYPE_ID) values(?, ?, ?)",
							tb_name);
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, user.getUser_name());
			preparedStatement.setString(2, user.getUser_password());
			preparedStatement.setInt(3, user.getUser_type_id());
			if(preparedStatement.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user register failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(null, preparedStatement);
		}
		return flag;
	}

	@Override
	public List<User> queryByName(String user_name) {
		List<User> list = new ArrayList<User>();
		User user;
		String sqlString = String.format("select * from %s where USER_NAME=? and USER_STATE=0",
							tb_name);
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, user_name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				user = new User();
				user.setUser_id(resultSet.getInt("USER_ID"));
				user.setUser_name(resultSet.getString("USER_NAME"));
				user.setUser_password(resultSet.getString("USER_PASSWORD"));
				user.setUser_state(resultSet.getInt("USER_STATE"));
				user.setUser_type_id(resultSet.getInt("USER_TYPE_ID"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user query failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(resultSet, preparedStatement);
		}
		return list;
	}

	//得到现有总共用户数
	@Override
	public int queryCnt(int userId) {
		int all_cnt = 1;
		String sqlString = String.format("select count(*) from %s where USER_STATE=0",
							tb_name);
		if(userId != -1){
			sqlString += " and USER_ID=" + userId;
		}
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				all_cnt = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user query cnt failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(resultSet, preparedStatement);
		}
		
		return all_cnt;
	}

	@Override
	public List<User> queryById(int userId, int start, int step) {
		User user = null;
		List<User> list = new ArrayList<User>();
		String sqlString = String.format("select * from %s where USER_STATE=0", 
						tb_name);
		//是否进行模糊查询
		if(userId >= 0){
			sqlString += " and USER_ID=" + userId;
		}
		sqlString += " limit " + start + "," + step;
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				user = new User();
				user.setUser_id(resultSet.getInt("USER_ID"));
				user.setUser_name(resultSet.getString("USER_NAME"));
				user.setUser_type_id(resultSet.getInt("USER_TYPE_ID"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("User query id failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(resultSet, preparedStatement);
		}
		return list;
	}

	@Override
	public boolean deleteById(int userId) {
		boolean flag = false;
		String sqlString = String.format("update %s set USER_STATE=1 where USER_ID=?", 
						tb_name);
		
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			preparedStatement.setInt(1, userId);
			if(preparedStatement.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user delete by id failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(null, preparedStatement);
		}
		return flag;
	}

	@Override
	public boolean updatePassword(int userId, String password) {
		boolean flag = false;
		String sqlString = String.format("update %s set USER_PASSWORD=? where USER_ID=? and USER_STATE=0",
						tb_name);
		
		try {
			preparedStatement = jdbcconnection.createConnection().prepareStatement(sqlString);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, userId);
			if(preparedStatement.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user update password failed");
			e.printStackTrace();
		}
		finally{
			jdbcconnection.closeConnection(null, preparedStatement);
		}
		return flag;
	}
	
}
