package com.jblog.service;

import java.util.List;

import com.jblog.domain.Article;
import com.jblog.domain.Sort;

public interface ArticleService {

	List<Article> getArticleListByBlogId(int blogId);

	Article getArticleById(int articleId);

	boolean addArticle(Article article);
	
	List<Sort> getArticleListSepBySort(int blogId);

}
