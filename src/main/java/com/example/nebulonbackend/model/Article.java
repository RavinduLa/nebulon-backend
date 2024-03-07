/*
* @Author: Ravindu Wataketiya - MS23466944
* Description: This is the model for Articles
*
* */

package com.example.nebulonbackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("articles")
public class Article {
    private String id;
    private String title;
    private  String content;
    private String authorId;
    private Date createdDateTime;
    private  Date publishedDateTime;
    private  boolean isPublished;

    public Article() {
    }

    public Article(String id, String title, String content, String authorId, Date createdDateTime, Date publishedDateTime, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createdDateTime = createdDateTime;
        this.publishedDateTime = publishedDateTime;
        this.isPublished = isPublished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(Date publishedDateTime) {
        this.publishedDateTime = publishedDateTime;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }


    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId='" + authorId + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", publishedDateTime=" + publishedDateTime +
                ", isPublished=" + isPublished +
                '}';
    }
}
