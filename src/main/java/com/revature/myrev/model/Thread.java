package com.revature.myrev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Thread {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="thread_id")
	private int threadId;

	public Thread(int threadId) {
		super();
		this.threadId = threadId;
	}

	public Thread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	@Override
	public String toString() {
		return "Thread [threadId=" + threadId + "]";
	}
	

}
