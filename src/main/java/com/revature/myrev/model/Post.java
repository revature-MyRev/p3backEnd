package com.revature.myrev.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.revature.myrev.model.Feed;

@Entity
@Table
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;
	@Column(name = "post_content")
	private String postContent;
	@Column(name = "users_id")
	private int usersId;
	@Column(name = "post_date")
	private Date postDate;
	@Column(name = "thread_id")
	private int threadId;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "type")
	private String type;


	public Post(int postId, String postContent, int usersId, Date postDate, int threadId, String imageUrl, String type) {
		super();
		this.type = type;
		if(this.type == "post")
		{
			Feed feed = new Feed();
			this.threadId = feed.getFeedId();
		}
		//this.threadId = threadId;
		this.postId = postId;
		this.postContent = postContent;
		this.usersId = usersId;
		this.postDate = postDate;
		this.imageUrl = imageUrl;
		
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("This is a string");
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String isType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", usersId=" + usersId + ", postDate="
				+ postDate + ", threadId=" + threadId + ", imageUrl=" + imageUrl + ", type=" + type + "]";
	}
	
	

}