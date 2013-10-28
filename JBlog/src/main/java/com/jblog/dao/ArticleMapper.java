package com.jblog.dao;

import java.util.List;

import com.jblog.domain.Article;

public interface ArticleMapper {
	
	List<Article> getArticleList();
	
	List<Article> getArticleListByBlogId(int blogId);
	
	Article getArticleById(int articleId);
	
	boolean addArticle(Article article);

}
