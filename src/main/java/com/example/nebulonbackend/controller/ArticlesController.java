/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Controller class for Articles
 *
 * */

package com.example.nebulonbackend.controller;

import com.example.nebulonbackend.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {
    private ArticlesService articlesService;

    @Autowired
    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }
}
