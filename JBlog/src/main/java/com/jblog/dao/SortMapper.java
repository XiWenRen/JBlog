package com.jblog.dao;

import java.util.List;

import com.jblog.domain.Sort;

public interface SortMapper {
	
	List<Sort> getSortList();
	
	List<Sort> getSortListByBlogId(int blogId);

}
