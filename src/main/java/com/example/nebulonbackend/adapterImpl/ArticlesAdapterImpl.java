/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Implementation file for articles adapter
 *
 * */

package com.example.nebulonbackend.adapterImpl;

import com.example.nebulonbackend.adapter.ArticlesAdapter;
import com.example.nebulonbackend.model.Article;
import com.example.nebulonbackend.repository.ArticlesMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticlesAdapterImpl implements ArticlesAdapter {
    private final ArticlesMongoRepository articlesMongoRepository;


    @Autowired
    public ArticlesAdapterImpl(ArticlesMongoRepository articlesMongoRepository) {
        this.articlesMongoRepository = articlesMongoRepository;
    }

    @Override
    public Article save(Article article) {
        return articlesMongoRepository.save(article);
    }

    @Override
    public Article getById(String id) {
        return articlesMongoRepository.findById(id).get();
    }

    @Override
    public List<Article> getAll() {
        return articlesMongoRepository.findAll();
    }

    @Override
    public List<Article> getByAuthorId(String id) {
        return articlesMongoRepository.findByAuthorId(id);
    }
}
