package com.jblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.dao.CommentMapper;
import com.jblog.domain.Comment;
import com.jblog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean addComment(Comment comment) {
		return commentMapper.addComment(comment);
	}

	@Override
	public List<Comment> getCommentListByArticleId(Integer articleId) {
		return commentMapper.getCommentListByArticleId(articleId);
	}

	@Override
	public boolean delCommentById(Integer commentId) {
		return commentMapper.delCommentById(commentId);
	}

}
