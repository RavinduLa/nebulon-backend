/*
* @Author: Ravindu Wataketiya - MS23466944
* Description: This is the model for Articles
*
* */

package com.example.nebulonbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("articles")
public class Article {
    @Id
    private String id;
    private String title;
    private  String content;
    private String summary;
    private String authorId;
    private LocalDateTime createdDateTime;
    private  LocalDateTime publishedDateTime;
    private  boolean isPublished;

    public Article() {
    }

    public Article(String id, String title, String content, String summary, String authorId, LocalDateTime createdDateTime, LocalDateTime publishedDateTime, boolean isPublished) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(LocalDateTime publishedDateTime) {
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
                ", summary='" + summary + '\'' +
                ", authorId='" + authorId + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", publishedDateTime=" + publishedDateTime +
                ", isPublished=" + isPublished +
                '}';
    }
}
