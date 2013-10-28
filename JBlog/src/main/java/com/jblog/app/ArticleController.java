package com.jblog.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jblog.domain.Article;
import com.jblog.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/allArticles")
	@ResponseBody
	public List<Article> getArticleByBlogId(int blogId){
		logger.info("=========");
		logger.info(articleService.getArticleListByBlogId(blogId).toString());
		return articleService.getArticleListByBlogId(blogId);
	}

}
