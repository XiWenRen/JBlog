package com.jblog.dao;

import java.util.List;

import com.jblog.domain.Comment;

public interface CommentMapper {
	
	List<Comment> getCommentList();

}
