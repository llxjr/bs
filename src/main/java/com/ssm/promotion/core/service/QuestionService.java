package com.ssm.promotion.core.service;

import com.ssm.promotion.core.dto.QuestionDTO;
import com.ssm.promotion.core.entity.Picture;
import com.ssm.promotion.core.entity.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
	/**
	 * 返回相应的数据集合
	 * 
	 * @param map
	 * @return
	 */
	public List<QuestionDTO> findQuestion(Map<String, Object> map);

	/**
	 * 数据数目
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotalQuestion(Map<String, Object> map);

	/**
	 * 
	 * 
	 * @param Question
	 * @return
	 */
	public int addQuestion(Question question);

	/**
	 * 
	 * 
	 * @param Question
	 * @return
	 */
	public int updateQuestion(Question question);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteQuestion(Integer id);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public Question findById(Integer id);
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Question> findAllQuestion();
}
