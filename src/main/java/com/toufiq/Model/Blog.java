package com.toufiq.Model;

public class Blog {
	private int blogId;
	private String blogTitle;
	private int categoryId;
	private String shortDescription;
	private String longDescription;
	private String imagePath;
	private int publicationStatus;
	private String categoryName;
	
	public Blog(String blogTitle, int categoryId, String shortDescription, String longDescription, String imagePath,
			int publicationStatus) {
		
		this.blogTitle = blogTitle;
		this.categoryId = categoryId;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.imagePath = imagePath;
		this.publicationStatus = publicationStatus;
	}

	public Blog(int blogId, String blogTitle, int categoryId, String shortDescription, String longDescription,
			String imagePath, int publicationStatus) {
		
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.categoryId = categoryId;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.imagePath = imagePath;
		this.publicationStatus = publicationStatus;
	}
	

	public Blog() {
		
	}
	

	public Blog(int blogId, String blogTitle, int categoryId, String shortDescription, String longDescription,
			String imagePath, int publicationStatus, String categoryName) {
		
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.categoryId = categoryId;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.imagePath = imagePath;
		this.publicationStatus = publicationStatus;
		this.categoryName = categoryName;
	}

	
	public Blog(int id,String blogTitle, String shortDescription, String longDescription, int publicationStatus) {
		this.blogId = id;
		this.blogTitle = blogTitle;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.publicationStatus = publicationStatus;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPublicationStatus() {
		return publicationStatus;
	}

	public void setPublicationStatus(int publicationStatus) {
		this.publicationStatus = publicationStatus;
	}
	
	
	
	
	

}
