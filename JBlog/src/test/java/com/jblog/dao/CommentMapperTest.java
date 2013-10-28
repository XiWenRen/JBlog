package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.Comment;

public class CommentMapperTest extends MapperTest {
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Test
	public void testGetCommentList(){
		List<Comment> commentList = commentMapper.getCommentList();
		for(Comment comment : commentList){
			logger.info(comment.toString());
		}
	}

}
