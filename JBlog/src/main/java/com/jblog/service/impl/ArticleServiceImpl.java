package com.jblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.dao.ArticleMapper;
import com.jblog.domain.Article;
import com.jblog.domain.Sort;
import com.jblog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> getArticleListByBlogId(int blogId) {
		return articleMapper.getArticleListByBlogId(blogId);
	}

	@Override
	public Article getArticleById(int articleId) {
		return articleMapper.getArticleById(articleId);
	}

	@Override
	public boolean addArticle(Article article) {
		return articleMapper.addArticle(article);
	}

	@Override
	public List<Sort> getArticleListSepBySort(int blogId) {
		return articleMapper.getArticleListSepBySort(blogId);
	}

}
