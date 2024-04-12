/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Data Transfer Object (DTO) for articles
 *
 * */

package com.example.nebulonbackend.dto;

import java.time.LocalDateTime;

public class ArticleDto {
    private String id;
    private String title;
    private  String content;
    private  String summary;
    private String authorId;
    private LocalDateTime createdDateTime;
    private  LocalDateTime publishedDateTime;
    private  boolean isPublished;

    public ArticleDto() {
    }

    public ArticleDto(String id, String title, String content, String summary, String authorId, LocalDateTime createdDateTime, LocalDateTime publishedDateTime, boolean isPublished) {
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

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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

    @Override
    public String toString() {
        return "ArticleDto{" +
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
