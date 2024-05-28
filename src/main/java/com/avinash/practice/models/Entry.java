package com.avinash.practice.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Document(collection = "books")
public class Entry {
    private String title;
    private String author;
    private String[] genres;
    private int rating;
    private int pages;
    @Id
    private ObjectId _id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", rating=" + rating +
                ", pages=" + pages +
                ", _id=" + _id +
                '}';
    }
}
