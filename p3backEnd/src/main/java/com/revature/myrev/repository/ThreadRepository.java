package com.revature.myrev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Thread;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Integer> {

}
