/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Service class for Articles
 *
 * */

package com.example.nebulonbackend.service;

import com.example.nebulonbackend.adapter.ArticlesAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {
    private final ArticlesAdapter articlesAdapter;

    @Autowired
    public ArticlesService(ArticlesAdapter articlesAdapter) {
        this.articlesAdapter = articlesAdapter;
    }
}
