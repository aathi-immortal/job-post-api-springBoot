package com.jobpost.jobpost.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.jobpost.jobpost.model.Post;
import com.jobpost.jobpost.repo.PostRepo;
import com.jobpost.jobpost.service.PostService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }
}
