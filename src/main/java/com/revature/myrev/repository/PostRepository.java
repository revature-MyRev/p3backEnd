package com.revature.myrev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.myrev.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findByUsersId(int uid);

//	public String getPostContent(int id);

//	public boolean likePost(Post post);
//	
//	public boolean dislikePost(Post post);

}
