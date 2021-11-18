package com.revature.myrev.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;
	@Column(name = "post_content")
	private String postContent;
    @Column(name = "user_id")
	private int userId;
	@Column(name = "post_date")
	private Date postDate;
    @Column(name = "thread_id")
	private int threadId;
    @Column(name = "image_url")
    private String imageUrl;

	public Post(int postId, String postContent, int userId, Date postDate) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.userId = userId;
		this.postDate = postDate;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", userId=" + userId + ", postDate="
				+ postDate + "]";
	}

}
