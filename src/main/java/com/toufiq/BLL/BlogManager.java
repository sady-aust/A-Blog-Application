package com.toufiq.BLL;

import java.util.List;

import com.toufiq.DAL.BlogGetway;
import com.toufiq.DAL.CategoryGetway;
import com.toufiq.Model.Blog;

public class BlogManager{
	public BlogGetway aBlogGetway = new BlogGetway();
	
	public boolean isInserted(Blog myBlog) {
		if(aBlogGetway.insertBlog(myBlog)>0) {
			return true;
		}
		return false;
	}
	
	public List<Blog> getAllBlog(){
		return aBlogGetway.getAllBlog();
	}

	public Blog getABlog(int editId) {
		// TODO Auto-generated method stub
		return aBlogGetway.getABLog(editId);
	}

	public boolean isUpdated(Blog aUpdateBlog) {
		// TODO Auto-generated method stub
		if (aBlogGetway.updateBlog(aUpdateBlog)>0) {
			return true;
		}
		return false;
	}

	public boolean isBLogDeleted(int deleteId) {
		// TODO Auto-generated method stub
		if(aBlogGetway.deleteBlog(deleteId)>0) {
			return true;
		}
		return false;
	}
	
	public List<Blog> getAllPublishedBlog(){
		return aBlogGetway.getAllPublishedBlog();
	}
	
	public List<Blog> getAllPublishedBlogOfACategory(int categoryId){
		return aBlogGetway.getAllPublishedBlogOfACategory(categoryId);
	}
	

	

}
