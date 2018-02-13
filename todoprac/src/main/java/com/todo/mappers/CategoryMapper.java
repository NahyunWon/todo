package com.todo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.todo.domain.Category;

public interface CategoryMapper {
	@Insert("insert into tb_category(cname, mno) values(#{cname}, #{mno})")
	public int create(Category cate);
	
	@Select("select cno, cname from tb_category where mno = #{mno}")
	public List<Category> getList(Category cate);
}
