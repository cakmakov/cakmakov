package com.cakmakov.jsf.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PostsController {

	private List<Posts> posts;
	private PostsDbUtil postsDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public PostsController() throws Exception {
		
		posts = new ArrayList<>();
		
		postsDbUtil = PostsDbUtil.getInstance();
	}
	
	public List<Posts> getPosts() {
		return posts;
	}
	
	public void loadPosts() {
		
		logger.info("Loading posts");
		
		posts.clear();
		
		try {
			
			// get all posts from database
			posts = postsDbUtil.getPosts();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading posts", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
	
	public String addPosts(Posts thePosts) {
		
		logger.info("Adding posts: " + thePosts);
		
		try {
			
			// add posts to the database
			postsDbUtil.addPosts(thePosts);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding posts", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "main?faces-redirect=true";
	}
		
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
