package com.todo.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.domain.Category;
import com.todo.service.CategoryService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/cate")
public class CategoryController {
	@Inject
	CategoryService service;
	
	@GetMapping("")
	public ResponseEntity<List<Category>> getCategoryList(Category cate){
		ResponseEntity<List<Category>> entity = null;
		try {
			entity = new ResponseEntity<List<Category>>(service.getList(cate),HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	@PostMapping("")
	public ResponseEntity<String> registerCategory(Category cate){
		ResponseEntity<String> entity = null;
		try {
			log.info("cate : "+cate);
			service.registerCategory(cate);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
