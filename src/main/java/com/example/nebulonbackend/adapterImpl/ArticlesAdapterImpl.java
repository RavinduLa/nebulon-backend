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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticlesAdapterImpl implements ArticlesAdapter {
    private final ArticlesMongoRepository articlesMongoRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ArticlesAdapterImpl(ArticlesMongoRepository articlesMongoRepository, MongoTemplate mongoTemplate) {
        this.articlesMongoRepository = articlesMongoRepository;
        this.mongoTemplate = mongoTemplate;
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

    @Override
    public Article updateById(String id, Article article) {
        return articlesMongoRepository.save(article);
    }

    @Override
    public Article publishArticle(String id) {
        Article article = mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(id)),
                new Update().set("isPublished", true), Article.class );
        return article;
    }

    @Override
    public Article unPublishArticle(String id) {
        Article article = mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(id)),
                new Update().set("isPublished", false), Article.class );
        return article;
    }

    @Override
    public String deleteArticleById(String id) {
        articlesMongoRepository.deleteById(id);
        return id;
    }
}
