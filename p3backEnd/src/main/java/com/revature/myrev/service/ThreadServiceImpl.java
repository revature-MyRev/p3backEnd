package com.revature.myrev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.myrev.repository.ThreadRepository;

@Service
public class ThreadServiceImpl implements ThreadService {
	
	@Autowired
	public ThreadRepository threadRepository;

	@Override
	public List<Thread> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Thread findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Thread thread) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id, Thread thread) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
