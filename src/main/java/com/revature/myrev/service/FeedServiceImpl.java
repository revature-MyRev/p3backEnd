package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.repository.FeedRepository;
import com.revature.myrev.model.Feed;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	public FeedRepository feedRepository;

	@Override
	public List<Feed> findAll() {
		// TODO Auto-generated method stub
		return feedRepository.findAll();
	}

	@Override
	public Feed findById(int id) {
		// TODO Auto-generated method stub
		return feedRepository.findById(id);
	}

	@Override
	public int save(Feed feed) {
		// TODO Auto-generated method stub
		feedRepository.save(feed);
		return feed.getFeedId();
	}

	@Override
	public void update(int id, Feed feed) {
		// TODO Auto-generated method stub
		feedRepository.save(feed);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		feedRepository.deleteById(id);
	}

}