/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Service class for Articles
 *
 * */

package com.example.nebulonbackend.service;

import com.example.nebulonbackend.adapter.ArticlesAdapter;
import com.example.nebulonbackend.converters.ArticleDtoConverter;
import com.example.nebulonbackend.dto.ArticleDto;
import com.example.nebulonbackend.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesService {
    private final ArticlesAdapter articlesAdapter;

    @Autowired
    public ArticlesService(ArticlesAdapter articlesAdapter) {
        this.articlesAdapter = articlesAdapter;
    }

    //Returns all the articles in ths system
    public List<Article> getAllArticles() {
        return articlesAdapter.getAll();
    }

    public ArticleDto getArticleById(String id) {
        Article article = articlesAdapter.getById(id);
        if (article == null) {
            System.out.println("Retrieved article is null");
        }
        return ArticleDtoConverter.convertModelToDTOWithID(article);
    }

    //Saves a given Article DTO
    public ArticleDto saveArticle(ArticleDto articleDto) {
        Article article = ArticleDtoConverter.convertDTOToModelWithNoId(articleDto);
        article.setCreatedDateTime(LocalDateTime.now());
        article.setPublishedDateTime(LocalDateTime.now());
        article.setPublished(false);
        Article returnArticle = articlesAdapter.save(article);
        return ArticleDtoConverter.convertModelToDTOWithID(returnArticle);
    }

    //Gets a list of article DTOs for a given author id
    public List<ArticleDto> getArticlesByAuthorId(String id) {
        List<Article> articles = articlesAdapter.getByAuthorId(id);
        List<ArticleDto> articleDTOs = new ArrayList<ArticleDto>();
        for(Article article : articles) {
            articleDTOs.add(ArticleDtoConverter.convertModelToDTOWithID(article))
;        }
        return  articleDTOs;
    }
}
