/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Controller class for Articles
 *
 * */

package com.example.nebulonbackend.controller;

import com.example.nebulonbackend.dto.ArticleDto;
import com.example.nebulonbackend.model.Article;
import com.example.nebulonbackend.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles/")
@CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
public class ArticlesController {
    private ArticlesService articlesService;

    @Autowired
    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping("getAll")
    public List<Article> getAllArticles() {
        return articlesService.getAllArticles();
    }

    @PostMapping("create")
    public ArticleDto createArticle(@RequestBody ArticleDto articleDto) {
        return articlesService.saveArticle(articleDto);
    }

    @GetMapping("open")
    public String articlesOpen() {
        return "Open Article endpoint";
    }
}
