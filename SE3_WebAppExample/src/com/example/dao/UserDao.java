package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.User;
import com.example.exceptions.DaoException;


public class UserDao extends Dao {

    public User findUserByUsernamePassword(String uname, String pword) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM user WHERE USERNAME = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int userId = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                u = new User(userId, firstname, lastname, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return u;     // u may be null 
    }
    
    
    public List<User> getAllUsers() throws DaoException {
    	
    	//LIST TO BE RETURNED WITH USERS
    	List<User> userList = new ArrayList<User>();
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	User u = null;
    	try {
    		conn = this.getConnection();
    		
    		String query = "SELECT * FROM user";
    		ps = conn.prepareStatement(query);
    		
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			int userId = rs.getInt("ID");
    			String username = rs.getString("USERNAME");
    			String password = rs.getString("PASSWORD");
    			String lastname = rs.getString("LAST_NAME");
    			String firstname = rs.getString("FIRST_NAME");
    			
    			u = new User(userId, firstname, lastname, username, password);
    			
    			//add user to list to return
    			userList.add(u);
    		}
    	} catch (SQLException e) {
            throw new DaoException("getAllUsers " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                throw new DaoException("getAllUsers" + e.getMessage());
            }
        }
        return userList;     // u may be null 
    }
   
}
