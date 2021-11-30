package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Feed;

public interface FeedService {

	public List<Feed> findAll();

	public Feed findById(int id);

	public int save(Feed feed);

	public void update(int id, Feed feed);

	public void deleteById(int id);
}