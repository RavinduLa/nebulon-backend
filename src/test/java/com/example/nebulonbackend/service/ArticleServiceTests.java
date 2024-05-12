package com.example.nebulonbackend.service;

import com.example.nebulonbackend.adapter.ArticlesAdapter;
import com.example.nebulonbackend.dto.ArticleDto;
import com.example.nebulonbackend.model.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.assertj.core.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTests {

    @Mock
    private ArticlesAdapter articlesAdapter;

    @InjectMocks
    private ArticlesService articlesService;

    public static final String TEST_ARTICLE_TITLE = "Test Article";
    public static final String TEST_ARTICLE_CONTENT = "Test Content. Content is this.";
    public static final String TEST_ARTICLE_SUMMARY = "Test Summary";
    public static final String TEST_ARTICLE_AUTHOR_ID = "samAuth001";

    @Test
    public  void ArticleService_CreateArticle_ReturnSavedArticle_Delete() {
        ArticleDto articleDto = generateTestArticleDTO();

        ArticleDto savedArticleDto = articlesService.saveArticle(articleDto);

        Assertions.assertThat(savedArticleDto).isNotNull();

        System.out.println("Article creation assertions completed.");

        //articlesService.deleteArticleById(savedArticleDto.getId());
        //System.out.println("Test article deleted");
    }

    private ArticleDto generateTestArticleDTO() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle(TEST_ARTICLE_TITLE);
        articleDto.setContent(TEST_ARTICLE_CONTENT);
        articleDto.setSummary(TEST_ARTICLE_SUMMARY);
        articleDto.setAuthorId(TEST_ARTICLE_AUTHOR_ID);
        articleDto.setPublished(false);
        articleDto.setCreatedDateTime(LocalDateTime.now());
        articleDto.setPublishedDateTime(LocalDateTime.now());

        return articleDto;
    }
}
