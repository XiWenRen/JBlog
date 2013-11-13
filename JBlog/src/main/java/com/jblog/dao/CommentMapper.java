package com.jblog.dao;

import java.util.List;

import com.jblog.domain.Comment;

public interface CommentMapper {
	
	List<Comment> getCommentList();
	
	boolean addComment(Comment comment);
	
	List<Comment> getCommentListByArticleId(Integer articleId);
	
	boolean delCommentById(Integer commentId);

}
