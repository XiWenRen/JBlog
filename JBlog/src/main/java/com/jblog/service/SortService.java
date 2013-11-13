package com.jblog.service;

import java.util.List;

import com.jblog.domain.Sort;

public interface SortService {

	List<Sort> getSortList();

	List<Sort> getSortListByBlogId(int blogId);

}
