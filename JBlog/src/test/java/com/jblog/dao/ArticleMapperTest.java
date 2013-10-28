package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.Article;

public class ArticleMapperTest extends MapperTest{
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Test
	public void testGetArticleList(){
		List<Article> articleList = articleMapper.getArticleList();
		for(Article article : articleList){
			logger.info("--all" + article.toString());
		}
	}
	
	public void testGetArticleListByBlogId(){
		List<Article> articleList = articleMapper.getArticleListByBlogId(1);
		for(Article article : articleList){
			logger.info("--byBlogId" + article.toString());
		}
	}
	
	@Test
	public void testGetArticleById(){
		Article article = articleMapper.getArticleById(2);
		logger.info("--byArticleId" + article.toString());
	}
	
	public void testAddArticle(){
		Article article = new Article();
		article.setArticleTitle("单元测试的文章添加测试");
		article.setArticleContent("这里是单元测试");
		article.setUserId("000001");
		article.setBlogId(1);
		article.setSortId(1);
		boolean b = articleMapper.addArticle(article);
		logger.info(b?"success":"failure");
	}

}
