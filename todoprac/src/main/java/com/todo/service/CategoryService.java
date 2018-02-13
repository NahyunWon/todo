package com.todo.service;

import java.util.List;

import com.todo.domain.Category;

public interface CategoryService {
	public void registerCategory(Category cate) throws Exception;
	public List<Category> getList(Category cate) throws Exception;
}
