package com.tian.spring.mvc.dao.mapper;

import com.tian.spring.mvc.dao.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//加上该注解才能使用@MapperScan扫描到
public interface ArticleDao {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("record") Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(@Param("id") Integer id);

    int countByUserId(@Param("userId") Integer userId);

    int updateByPrimaryKeySelective(@Param("record") Article record);

    int updateByPrimaryKey(@Param("record") Article record);
}