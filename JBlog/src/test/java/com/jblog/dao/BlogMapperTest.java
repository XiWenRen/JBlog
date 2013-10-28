package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.Blog;

public class BlogMapperTest extends MapperTest{
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Test
	public void testGetCommentList(){
		List<Blog> blogList = blogMapper.getBlogList();
		for(Blog blog : blogList){
			logger.info(blog.toString());
		}
	}

}
