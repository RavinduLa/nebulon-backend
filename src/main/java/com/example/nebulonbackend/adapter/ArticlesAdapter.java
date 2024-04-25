/*
 * @Author: Ravindu Wataketiya - MS23466944
 * Description: Adapter interface for Articles
 *
 * */

package com.example.nebulonbackend.adapter;

import com.example.nebulonbackend.model.Article;

import java.util.List;

public interface ArticlesAdapter {
    Article save(Article article);
    Article getById(String id);
    List<Article> getAll();

    List<Article> getByAuthorId(String id);

    Article updateById(String id, Article article);
}
