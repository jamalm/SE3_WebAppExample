package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.Input;
import com.example.exceptions.DaoException;

public class InputDao extends Dao {
	
	public boolean createPost(String title, String text, String category) throws DaoException {
		
		
		boolean rs = false;
        Connection con = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO forum VALUES(null, ?, ?, ?)";
        
        try {
        	con = this.getConnection();
        	
        	//prepare statement for insert
        	ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, text);
            ps.setString(3, category);
            
            //store result (inserted or not bool)
            int result = ps.executeUpdate();
            if (result == 1)
            {
            	//if inserted correctly, return true
            	rs = true;
            }
        }  catch (SQLException e) {
            throw new DaoException("createPost " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("createPost " + e.getMessage());
            }
        }
        return rs;
    }
	
	public List<Input> viewPosts() throws DaoException {
		
		// create list of posts
		List<Input> postList = new ArrayList<Input>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Input i = null;
		
		try {
			con = this.getConnection();
			
			String query = "SELECT * FROM forum";
			ps = con.prepareStatement(query);
			
			// select all posts from forum
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String body = rs.getString("BODY");
				String category = rs.getString("CATEGORY");
				
				//insert into list
				i = new Input(id, title, body, category);
				postList.add(i);
			}
			
		}catch (SQLException e) {
            throw new DaoException("viewPosts " + e.getMessage());
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
                throw new DaoException("viewPosts" + e.getMessage());
            }
        }
        return postList;     // u may be null 
    }
}

