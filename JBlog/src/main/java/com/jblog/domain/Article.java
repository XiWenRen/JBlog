package com.jblog.domain;

import java.util.Date;
import java.util.List;

public class Article {

	private Integer articleId;
	private String articleTitle;
	private String articleContent;
	private String userId;
	private Date pubTime;
	private Date modTime;
	private Integer clickNum;
	private Integer readNum;
	private Integer blogId;
	private Integer sortId;
	private List<Comment> commList;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Integer getReadNum() {
		return readNum;
	}

	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public List<Comment> getCommList() {
		return commList;
	}

	public void setCommList(List<Comment> commList) {
		this.commList = commList;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle="
				+ articleTitle + ", articleContent=" + articleContent
				+ ", userId=" + userId + ", pubTime=" + pubTime + ", modTime="
				+ modTime + ", clickNum=" + clickNum + ", readNum=" + readNum
				+ ", blogId=" + blogId + ", sortId=" + sortId + ", commList="
				+ commList + "]";
	}

}
