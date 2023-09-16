package com.jobpost.jobpost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobpost.jobpost.model.Post;
import com.jobpost.jobpost.repo.PostRepo;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

}
