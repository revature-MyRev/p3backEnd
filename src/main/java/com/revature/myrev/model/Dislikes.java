package com.revature.myrev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Dislikes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dislike_id")
	private int dislikeId;
	
	@Column(name = "User_id")
	private int usersId;
	
	@Column(name = "post_id")
	private int postId;

	public Dislikes(int dislikeId, int usersId, int postId) {
		super();
		this.dislikeId = dislikeId;
		this.usersId = usersId;
		this.postId = postId;
	}

	public Dislikes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDislikeId() {
		return dislikeId;
	}

	public void setDislikeId(int dislikeId) {
		this.dislikeId = dislikeId;
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
		return "Disdislikes [dislikeId=" + dislikeId + ", usersId=" + usersId + ", postId=" + postId + "]";
	}
	
}
