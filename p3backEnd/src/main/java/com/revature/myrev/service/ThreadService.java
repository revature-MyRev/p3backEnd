package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.model.Follower;
import com.revature.myrev.repository.ThreadRepository;

public interface ThreadService {
	
	public List<Thread> findAll();

	public Thread findById(int id);

	public void save(Thread thread);

	public void update(int id, Thread thread);

	public void deleteById(int id);
}
