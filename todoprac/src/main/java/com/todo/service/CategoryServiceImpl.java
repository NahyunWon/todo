package com.todo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.todo.domain.Category;
import com.todo.mappers.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Inject
	CategoryMapper mapper;
	
	@Override
	public void registerCategory(Category cate) throws Exception {
		mapper.create(cate);
	}

	@Override
	public List<Category> getList(Category cate) throws Exception {
		return mapper.getList(cate);
	}
}
