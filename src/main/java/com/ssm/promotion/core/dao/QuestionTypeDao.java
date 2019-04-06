package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.QuestionType;

public interface QuestionTypeDao {
	//查询课程列表
	public List<QuestionType> fTypes(Map<String, Object> map);
	//更新
	public int updateTypes(QuestionType questionType);
	//添加
	public int addTypes(QuestionType questionType);
	//删除
	public int deleteTypes(Integer id);
	//
	public Long getTotalTypes(Map<String, Object> map);
	public QuestionType findById(int id);
}
