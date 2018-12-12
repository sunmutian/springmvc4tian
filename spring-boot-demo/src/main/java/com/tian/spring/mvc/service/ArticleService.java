package com.tian.spring.mvc.service;


import com.tian.spring.mvc.dao.domain.Article;

import java.util.List;

/**
 * @auther: tianweichang
 * @date: 2018/9/8 18:24
 * @Description:
 */
public interface ArticleService {
    Article getArticleById(int id);

    List<Article> selectArticleByUserId(int userId);

    boolean updateArticle(Article article);

    boolean insertArticle(Article article);

    boolean deleteArticleById(int id);

    Integer selectCountByUserId(int userId);
}
