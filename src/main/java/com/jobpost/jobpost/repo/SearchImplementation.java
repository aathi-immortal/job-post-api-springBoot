package com.jobpost.jobpost.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.jobpost.jobpost.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchImplementation implements SearchRepo {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        ArrayList<Post> post = new ArrayList<>();

        // implementation of search mechanism
        // pipeline from the mongoDb
        MongoDatabase database = mongoClient.getDatabase("job-post-database");
        MongoCollection<Document> collection = database.getCollection("job-post");

        // result will contain the list of post in Document pattern
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        // convertor will convert the document object into the
        // read method in convertor get 2 parameter 1 parameter is the object we need to
        // convert it second parameter is the data
        result.forEach(doc -> post.add(converter.read(Post.class, doc)));

        return post;
    }

}
