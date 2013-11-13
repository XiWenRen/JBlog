package com.jblog.dao;

import java.util.List;

import com.jblog.domain.Article;
import com.jblog.domain.Sort;

public interface ArticleMapper {
	
	//获取所有文章(暂时测试用)
	List<Article> getArticleList();
	
	//获得当前博客的文章，暂时没有关联回复
	List<Article> getArticleListByBlogId(int blogId);
	
	//获得文章并关联回复
	Article getArticleById(int articleId);
	
	//按文章分类获取文章列表
	List<Sort> getArticleListSepBySort();
	
	//添加文章
	boolean addArticle(Article article);
	
	//删除文章
	boolean deleteArticleById(Integer articleId);
	
	//修改文章
	boolean updateArticle(Article article);

}
