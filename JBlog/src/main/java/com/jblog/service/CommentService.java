package com.jblog.service;

import java.util.List;

import com.jblog.domain.Comment;

public interface CommentService {

	boolean addComment(Comment comment);

	List<Comment> getCommentListByArticleId(Integer articleId);

	boolean delCommentById(Integer commentId);

}
