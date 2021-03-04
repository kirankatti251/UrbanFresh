package com.example.urbanfresh.network;

public class MainActivityModel {
	String bannerId,banner_name,banner_description,banner_alt,banner_image,url_type,url_id;

	public MainActivityModel(String bannerId, String banner_name, String banner_description, String banner_alt, String banner_image, String url_type, String url_id) {
		this.bannerId = bannerId;
		this.banner_name = banner_name;
		this.banner_description = banner_description;
		this.banner_alt = banner_alt;
		this.banner_image = banner_image;
		this.url_type = url_type;
		this.url_id = url_id;
	}

	public String getBannerId() {
		return bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}

	public String getBanner_description() {
		return banner_description;
	}

	public void setBanner_description(String banner_description) {
		this.banner_description = banner_description;
	}

	public String getBanner_alt() {
		return banner_alt;
	}

	public void setBanner_alt(String banner_alt) {
		this.banner_alt = banner_alt;
	}

	public String getBanner_image() {
		return banner_image;
	}

	public void setBanner_image(String banner_image) {
		this.banner_image = banner_image;
	}

	public String getUrl_type() {
		return url_type;
	}

	public void setUrl_type(String url_type) {
		this.url_type = url_type;
	}

	public String getUrl_id() {
		return url_id;
	}

	public void setUrl_id(String url_id) {
		this.url_id = url_id;
	}
}
