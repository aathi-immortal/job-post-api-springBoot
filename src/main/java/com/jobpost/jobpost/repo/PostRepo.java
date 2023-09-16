package com.jobpost.jobpost.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobpost.jobpost.model.Post;


public interface PostRepo extends MongoRepository<Post,String>{

    
}
