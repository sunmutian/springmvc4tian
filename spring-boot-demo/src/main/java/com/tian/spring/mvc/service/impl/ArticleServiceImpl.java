package com.tian.spring.mvc.service.impl;

import com.tian.spring.mvc.dao.domain.Article;
import com.tian.spring.mvc.dao.mapper.ArticleDao;
import com.tian.spring.mvc.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: tianweichang
 * @date: 2018/12/8 16
 * @Description:
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    public Article getArticleById(int id) {
        return articleDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> selectArticleByUserId(int userId) {
        return null;
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateByPrimaryKeySelective(article) > 0;
    }

    @Override
    public boolean insertArticle(Article article) {
        return articleDao.insert(article) > 0;
    }

    @Override
    public boolean deleteArticleById(int id) {
        return false;
    }

    @Override
    public Integer selectCountByUserId(int userId) {
//        return articleDao.countByUserId(userId);
        return 100;
    }
}
