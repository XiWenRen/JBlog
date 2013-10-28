package com.jblog.service;

import java.util.List;

import com.jblog.domain.Article;

public interface ArticleService {

	List<Article> getArticleListByBlogId(int blogId);

	Article getArticleById(int articleId);

	boolean addArticle(Article article);

}
