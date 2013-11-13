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
			logger.info("all:" + comment.toString());
		}
	}
	
	public void testAddComment(){
		Comment comment = new Comment();
		comment.setComment("第一篇文章的测试评论");
		comment.setArticleId(1);
		comment.setUserId(1);
		boolean b = commentMapper.addComment(comment);
		logger.info("添加评论" + (b ? "成功" : "失败"));
	}
	
	@Test
	public void testGetCommentListByArticleId(){
		List<Comment> commentList = commentMapper.getCommentListByArticleId(1);
		for(Comment comment : commentList){
			logger.info("article1:" + comment.toString());
		}
	}
	
	@Test
	public void testDelCommentById(){
		boolean b = commentMapper.delCommentById(3);
		logger.info("删除评论" + (b ? "成功" : "失败"));
	}

}
