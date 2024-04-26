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
//@CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
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

    @GetMapping("getById/{id}")
    public ArticleDto getArticleById(@PathVariable String id) {
        System.out.println("Received ID " + id);
        return articlesService.getArticleById(id);
    }

    @GetMapping("getByAuthorId/{id}")
    public List<ArticleDto> getArticlesByAuthorId(@PathVariable String id) {
        return articlesService.getArticlesByAuthorId(id);
    }

    @PostMapping("create")
    public ArticleDto createArticle(@RequestBody ArticleDto articleDto) {
        return articlesService.saveArticle(articleDto);
    }

    @PutMapping("updateArticle")
    public ArticleDto updateArticle(@RequestBody ArticleDto articleDto) {
        return articlesService.updateArticleById(articleDto);
    }

    @PutMapping("publish/{id}")
    public ArticleDto publishArticle(@PathVariable String id){
        return articlesService.publishArticle(id);
    }

    @PutMapping("unpublish/{id}")
    public ArticleDto unPublishArticle(@PathVariable String id){
        return articlesService.unPublishArticle(id);
    }


    @GetMapping("open")
    public String articlesOpen() {
        return "Open Article endpoint";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        return articlesService.deleteArticleById(id);
    }
}
