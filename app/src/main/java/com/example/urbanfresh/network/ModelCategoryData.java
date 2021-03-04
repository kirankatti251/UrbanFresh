package com.example.urbanfresh.network;

public class ModelCategoryData {
	String category_id,category_name,category_description,category_picture;

	public ModelCategoryData(String category_id, String category_name, String category_description, String category_picture) {
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_description = category_description;
		this.category_picture = category_picture;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public String getCategory_picture() {
		return category_picture;
	}

	public void setCategory_picture(String category_picture) {
		this.category_picture = category_picture;
	}
}
