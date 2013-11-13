package com.jblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.dao.SortMapper;
import com.jblog.domain.Sort;
import com.jblog.service.SortService;

@Service
public class SortServiceImpl implements SortService {
	
	@Autowired
	private SortMapper sortMapper;

	@Override
	public List<Sort> getSortList() {
		return sortMapper.getSortList();
	}

	@Override
	public List<Sort> getSortListByBlogId(int blogId) {
		return sortMapper.getSortListByBlogId(blogId);
	}

}
