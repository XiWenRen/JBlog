package com.jblog.domain;

public class Comment {

	private Integer CommentId;
	private String Comment;
	private Integer articleId;
	private Integer userId;

	public Integer getCommentId() {
		return CommentId;
	}

	public void setCommentId(Integer commentId) {
		CommentId = commentId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Comment [CommentId=" + CommentId + ", Comment=" + Comment
				+ ", articleId=" + articleId + ", userId=" + userId + "]";
	}

}
