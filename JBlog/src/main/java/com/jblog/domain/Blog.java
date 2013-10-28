package com.jblog.domain;

public class Blog {

	private Integer blogId;
	private String blogName;
	private String userId;

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName
				+ ", userId=" + userId + "]";
	}

}
