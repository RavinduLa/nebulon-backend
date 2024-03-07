/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Service class for Articles
 *
 * */

package com.example.nebulonbackend.service;

import com.example.nebulonbackend.adapter.ArticlesAdapter;
import com.example.nebulonbackend.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    private final ArticlesAdapter articlesAdapter;

    @Autowired
    public ArticlesService(ArticlesAdapter articlesAdapter) {
        this.articlesAdapter = articlesAdapter;
    }

    public List<Article> getAllArticles() {
        return articlesAdapter.getAll();
    }
}
