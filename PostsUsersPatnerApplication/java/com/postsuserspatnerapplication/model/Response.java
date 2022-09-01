package com.postsuserspatnerapplication.model;

public class Response {

	private String lat;
	private String lng;
	private String companyName;
	private String title;
	private String body;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Response(String lat, String lng, String companyName, String title, String body) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.companyName = companyName;
		this.title = title;
		this.body = body;
	}
	public Response() {
		super();
	}
	@Override
	public String toString() {
		return "Response [lat=" + lat + ", lng=" + lng + ", companyName=" + companyName + ", title=" + title + ", body="
				+ body + "]";
	}
	
}
