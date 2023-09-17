package com.jobpost.jobpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobpost.jobpost.model.Post;
import com.jobpost.jobpost.repo.PostRepo;
import com.jobpost.jobpost.repo.SearchImplementation;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    SearchImplementation searchImplementation;

    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    public Post postJob(Post post) {
        return postRepo.save(post);
    }

    public List<Post> findByText(String text) {
        return searchImplementation.findByText(text);
    }

}
