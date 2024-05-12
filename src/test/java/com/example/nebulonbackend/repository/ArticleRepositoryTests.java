package com.example.nebulonbackend.repository;

import com.example.nebulonbackend.model.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@DataMongoTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ArticleRepositoryTests {
    @Autowired
    private ArticlesMongoRepository articlesMongoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public static final String TEST_ARTICLE_TITLE = "Test Article";
    public static final String TEST_ARTICLE_CONTENT = "Test Content. Content is this.";
    public static final String TEST_ARTICLE_SUMMARY = "Test Summary";
    public static final String TEST_ARTICLE_AUTHOR_ID = "samAuth001";

    @Test
    public void ArticlesMongoRepository_Save_ReturnSavedArticle_Delete() {

        //Arrange
        Article article  = generateTestArticle();

        //Act
        Article savedArticle = articlesMongoRepository.save(article);

        //Assert
        Assertions.assertThat(savedArticle).isNotNull();
        Assertions.assertThat(savedArticle.getId()).isNotNull();
        Assertions.assertThat(savedArticle.getTitle()).isEqualTo(TEST_ARTICLE_TITLE);
        Assertions.assertThat(savedArticle.getSummary()).isEqualTo(TEST_ARTICLE_SUMMARY);
        Assertions.assertThat(savedArticle.getContent()).isEqualTo(TEST_ARTICLE_CONTENT);
        Assertions.assertThat(savedArticle.getAuthorId()).isEqualTo(TEST_ARTICLE_AUTHOR_ID);
        Assertions.assertThat(savedArticle.isPublished()).isEqualTo(false);
        Assertions.assertThat(savedArticle.getPublishedDateTime()).isNotNull();
        Assertions.assertThat(savedArticle.getCreatedDateTime()).isNotNull();

        System.out.println("Article creation assertions completed.");

        articlesMongoRepository.deleteById(savedArticle.getId());
        System.out.println("Test article deleted");
    }

    @Test
    public void ArticleMongoRepository_GetAllArticles(){
        //Act
        List<Article> articles = articlesMongoRepository.findAll();

        //Assert
        Assertions.assertThat(articles).isNotNull();

        System.out.println("Get all article assertion complete");
        System.out.println("Article list size : " + articles.size());
    }

    @Test
    public void ArticleMongoRepository_FindByAuthorId() {
        //Arrange
        Article  article = generateTestArticle();

        //Act
        Article savedArticle = articlesMongoRepository.save(article);
        List<Article> retrievedArticles = articlesMongoRepository.findByAuthorId(TEST_ARTICLE_AUTHOR_ID);

        //Assert
        Assertions.assertThat(retrievedArticles).isNotNull();

        if(!retrievedArticles.isEmpty()){
            Article firstArticle = retrievedArticles.get(0);
            Assertions.assertThat(firstArticle).isNotNull();
            Assertions.assertThat(firstArticle.getTitle()).isEqualTo(TEST_ARTICLE_TITLE);
        }

        System.out.println("Retrieve article by id assertion complete");
        System.out.println("Article list size : " + retrievedArticles.size());

        articlesMongoRepository.deleteById(savedArticle.getId());
        System.out.println("Test article deleted");
    }


    private Article generateTestArticle() {
        Article article = new Article();
        article.setTitle(TEST_ARTICLE_TITLE);
        article.setContent(TEST_ARTICLE_CONTENT);
        article.setSummary(TEST_ARTICLE_SUMMARY);
        article.setAuthorId(TEST_ARTICLE_AUTHOR_ID);
        article.setPublished(false);
        article.setCreatedDateTime(LocalDateTime.now());
        article.setPublishedDateTime(LocalDateTime.now());

        return  article;
    }
}
