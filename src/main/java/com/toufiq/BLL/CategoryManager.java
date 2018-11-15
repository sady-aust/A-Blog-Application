package com.toufiq.BLL;

import java.util.List;

import com.toufiq.DAL.CategoryGetway;
import com.toufiq.Model.Category;

public class CategoryManager {
	
	CategoryGetway aCategoryGetway = new CategoryGetway();
	
	public boolean insertCategory(Category aCategory) {
		
		if(aCategoryGetway.insertCategoey(aCategory)>0) {
			return true;
		}
		return false;
	}
	
	public List<Category> getAllCategories() {
		return aCategoryGetway.getAllCategories();
	}
	
	public Category getCategoryByCategoryId(int id) {
		return aCategoryGetway.getCategoryByCategoryId(id);
	}

	public boolean updateCategory(Category aCategory) {
		// TODO Auto-generated method stub
		if(aCategoryGetway.updateCategory(aCategory)>0) {
			return true;
		}
		return false;
	}

	public boolean deleteCategory(int deleteId) {
		// TODO Auto-generated method stub
		if(aCategoryGetway.deleteCategory(deleteId)>0) {
			return true;
		}
		return false;
	}

	public List<Category> getAllPublishedCategories() {
		// TODO Auto-generated method stub
		
		return aCategoryGetway.getAllPublishedCategories();
	}

}
