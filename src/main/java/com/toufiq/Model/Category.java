package com.toufiq.Model;

public class Category {
	private int categoryId;
	private String categoryName;
	private String shortDescription;
	private int publicationStatus;
	
	
	public Category(String categoryName, String shortDescription, int publicationStatus) {
		
		this.categoryName = categoryName;
		this.shortDescription = shortDescription;
		this.publicationStatus = publicationStatus;
	}


	public Category() {
		
	}


	public Category(int categoryId, String categoryName, String shortDescription, int publicationStatus) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.shortDescription = shortDescription;
		this.publicationStatus = publicationStatus;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public int getPublicationStatus() {
		return publicationStatus;
	}


	public void setPublicationStatus(int publicationStatus) {
		this.publicationStatus = publicationStatus;
	}


	
	
	
	
	
}
