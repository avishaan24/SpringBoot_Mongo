package com.avinash.practice.mongoRepos;

import com.avinash.practice.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepo extends MongoRepository<Entry, String> {

    List<Entry> findByTitle(String title);
    List<Entry> findByAuthor(String author);

    @Query(value = "{$or : [{'author' : ?0}, {'pages' : ?1}]}")
    List<Entry> search(String author, int pages);
}
