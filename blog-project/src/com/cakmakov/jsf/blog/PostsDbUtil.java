package com.cakmakov.jsf.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PostsDbUtil {

	private static PostsDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/elitkoseadmin";
	
	public static PostsDbUtil getInstance() throws Exception {	
		if (instance == null) {
			instance = new PostsDbUtil();
		}
		
		return instance;
	}
	
	private PostsDbUtil() throws Exception{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
	
	public List<Posts> getPosts() throws Exception {
		
		List<Posts> posts = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from posts";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String date = myRs.getString("date");
				String title = myRs.getString("title");
				String content = myRs.getString("content");
				
				// create new posts object
				Posts tempPosts = new Posts(id, date, title, content);
				
				// add it to the list of posts
				posts.add(tempPosts);
			}
			
			return posts;
			
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	public void addPosts(Posts thePosts) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "insert into posts (date, title, content) values (?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, thePosts.getDate());
			myStmt.setString(2, thePosts.getTitle());
			myStmt.setString(3, thePosts.getContent());
			
			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
		}
	}
	
	public Posts getContent(int postsId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from posts where id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, postsId);
			
			myRs = myStmt.executeQuery();

			Posts thePosts = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String date = myRs.getString("date");
				String title = myRs.getString("title");
				String content = myRs.getString("content");
				
				thePosts = new Posts(id, date, title, content);
			}
			else {
				throw new Exception("Could not find posts id: " + postsId);
			}

			return thePosts;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	public void updatePosts(Posts thePosts) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "update posts "
					+ " set date=?, title=?, content=?"
					+ " where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, thePosts.getDate());
			myStmt.setString(2, thePosts.getTitle());
			myStmt.setString(3, thePosts.getContent());
			myStmt.setInt(4, thePosts.getId());
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public void deletePosts(int postsId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from posts where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, postsId);
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}		
	}	
	
	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private void close(Connection theConn, Statement theStmt) {
		close(theConn, theStmt, null);
	}
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}	
}
