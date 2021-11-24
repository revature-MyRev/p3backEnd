package com.revature.myrev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Likes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "like_id")
	private int likeId;
	
	@Column(name = "User_id")
	private int usersId;
	
	@Column(name = "post_id")
	private int postId;

	public Likes(int likeId, int usersId, int postId) {
		super();
		this.likeId = likeId;
		this.usersId = usersId;
		this.postId = postId;
	}

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", usersId=" + usersId + ", postId=" + postId + "]";
	}
	
	

}
