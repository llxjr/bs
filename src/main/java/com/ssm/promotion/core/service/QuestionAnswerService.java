package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.QuestionAnswerDTO;
import com.ssm.promotion.core.entity.QuestionAnswer;

public interface QuestionAnswerService {

public List<QuestionAnswerDTO> findQuestionAnswer (Map<String, Object> map);
	
	public int addqa(QuestionAnswer questionanswer);
	
	public int updateQuestionAnswer(QuestionAnswer questionanswer);
	
	public int deleteQuestionAnswer(int id);
	
	public QuestionAnswer findQuestionAnswerById(int id);
	
	public Long getTotalUser(Map<String, Object> map);
}
