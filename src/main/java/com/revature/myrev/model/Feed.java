package com.revature.myrev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feed_id")
	private int feedId;

	public Feed(int feedId) {
		super();
		this.feedId = feedId;
	}

	public Feed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + "]";
	}

}