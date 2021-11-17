package com.revature.myrev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Follower {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="followerscol")
	private int id;	
	@Column(name="follower_id")
    private int followerId;
	@Column(name="followed_id")
	private int followedId;
	
	public Follower(int id, int followerId, int followedId) {
		super();
		this.id = id;
		this.followerId = followerId;
		this.followedId = followedId;
	}
	
	public Follower() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFollowerId() {
		return followerId;
	}
	
	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}
	
	public int getFollowedId() {
		return followedId;
	}
	
	public void setFollowedId(int followedId) {
		this.followedId = followedId;
	}
	
	@Override
	public String toString() {
		return "Follower [id=" + id + ", followerId=" + followerId + ", followedId=" + followedId + "]";
	}
	
	
}
