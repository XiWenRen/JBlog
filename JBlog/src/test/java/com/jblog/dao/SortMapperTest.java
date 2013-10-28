package com.jblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jblog.domain.Sort;

public class SortMapperTest extends MapperTest{
	
	@Autowired
	private SortMapper sortMapper;
	
	@Test
	public void testGetSortList(){
		List<Sort> sortList = sortMapper.getSortList();
		for(Sort sort : sortList){
			logger.info("--all" + sort.toString());
		}
	}
	
	@Test
	public void testGetSortListByBlogId(){
		List<Sort> sortList = sortMapper.getSortListByBlogId(1);
		for(Sort sort : sortList){
			logger.info("==byBlogId" + sort.toString());
		}
	}

}
