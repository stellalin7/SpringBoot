package com.techtalentsouth.TechTalentBlog.BlogPost;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BlogPostRepository extends CrudRepository<BlogPost, Long>{
	
	List<BlogPost> findAllById(Long id);

}
