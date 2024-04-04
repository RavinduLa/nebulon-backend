/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Converter class for DTO related conversions.
 * Converts between DTOs and Models of Articles
 * */

package com.example.nebulonbackend.converters;

import com.example.nebulonbackend.dto.ArticleDto;
import com.example.nebulonbackend.model.Article;

public class ArticleDtoConverter {
    //Convert an article model with an ID to an article DTO
    public static ArticleDto convertModelToDTOWithID(Article article){
        //Instantiate and populate the DTO with attributes from model
        ArticleDto articleDto = new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthorId(),
                article.getCreatedDateTime(),
                article.getPublishedDateTime(),
                article.isPublished()
        );
        return articleDto;
    }

    //Convert Article Model to an Article DTO without an ID
    public static ArticleDto convertModelToDTOWithNoId(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle(article.getTitle());
        articleDto.setContent(article.getContent());
        articleDto.setAuthorId(article.getAuthorId());
        articleDto.setCreatedDateTime(article.getCreatedDateTime());
        articleDto.setPublishedDateTime(article.getPublishedDateTime());
        articleDto.setPublished(article.isPublished());
        return articleDto;
    }

    //Convert Article DTO an Article model with an ID
    public static Article convertDTOToModelWithId(ArticleDto articleDto) {
        Article article = new Article(
                articleDto.getId(),
                articleDto.getTitle(),
                articleDto.getContent(),
                articleDto.getAuthorId(),
                articleDto.getCreatedDateTime(),
                articleDto.getPublishedDateTime(),
                articleDto.isPublished()
        );
        return article;
    }


    //Convert Article DTO an Article model without an ID
    public static Article convertDTOToModelWithNoId(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setAuthorId(articleDto.getAuthorId());
        article.setCreatedDateTime(articleDto.getCreatedDateTime());
        article.setPublishedDateTime(articleDto.getPublishedDateTime());
        article.setPublished(articleDto.isPublished());
        return article;
    }
}
