/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description:
 *
 * */


/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: The Mongo Repository for articles
 * Specific find methods are defined here
 *
 * */
package com.example.nebulonbackend.repository;

import com.example.nebulonbackend.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesMongoRepository extends MongoRepository<Article, String> {
    List<Article> findByAuthorId(String authorId);
}
