package com.jobpost.jobpost.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "job-post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private String profile;
    private String desc;
    private int exp;
    private String techs[];

}
