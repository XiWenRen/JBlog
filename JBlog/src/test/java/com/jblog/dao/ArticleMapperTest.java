package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.Article;
import com.jblog.domain.Sort;

public class ArticleMapperTest extends MapperTest{
	
	@Autowired
	private ArticleMapper articleMapper;
	
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
	
	public void testGetArticleById(){
		Article article = articleMapper.getArticleById(2);
		logger.info("--byArticleId" + article.toString());
	}
	
	@Test
	public void testGetArticleListSepBySort(){
		List<Sort> sortList = articleMapper.getArticleListSepBySort(1);
		for(Sort sort : sortList){
			logger.info("-" + sort.getSortName());
			logger.info(" --" + sort.toString());
		}
	}
	
	public void testAddArticle(){
		Article article = new Article();
		article.setArticleTitle("单元测试的文章添加测试");
		article.setArticleContent("这里是单元测试");
		article.setUserId(1);
		article.setBlogId(1);
		article.setSortId(1);
		boolean b = articleMapper.addArticle(article);
		logger.info("添加" + (b?"成功":"失败"));
	}
	
	public void testDeleteArticleById(){
		boolean b = articleMapper.deleteArticleById(5);
		logger.info("删除" + (b ? "成功" : "失败"));
	}
	
	public void testUpdateArticle(){
		Article article = new Article();
		article.setArticleId(6);
		article.setArticleContent("单元测试的文章修改测试");
		boolean b = articleMapper.updateArticle(article);
		logger.info("修改" + (b ? "成功" : "失败"));
	}
}
