package org.wecancodeit.reviewsite;

public class Review {

	private long id;
	private String title; //name
	private String imageUrl;
	private String category; //description
	private String content; 
	private String date;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}

	public Review(long id, String title, String imageUrl, String category, String content, String date) {
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.category = category;
		this.content = content;
		this.date = date;
	}

}
