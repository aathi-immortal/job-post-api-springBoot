package com.jobpost.jobpost.repo;

import java.util.List;

import com.jobpost.jobpost.model.Post;

interface SearchRepo {
    public List<Post> findByText(String text);
}
