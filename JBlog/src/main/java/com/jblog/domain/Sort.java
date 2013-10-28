package com.jblog.domain;

public class Sort {

	private Integer sortId;
	private String sortName;
	private Integer blogId;

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	@Override
	public String toString() {
		return "Sort [sortId=" + sortId + ", sortName=" + sortName
				+ ", blogId=" + blogId + "]";
	}

}
