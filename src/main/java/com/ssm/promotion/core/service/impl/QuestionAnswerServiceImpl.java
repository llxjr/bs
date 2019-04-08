package com.ssm.promotion.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.ChapterDao;
import com.ssm.promotion.core.dao.QuestionAnswerDao;
import com.ssm.promotion.core.dao.QuestionDao;
import com.ssm.promotion.core.dto.QuestionAnswerDTO;
import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Question;
import com.ssm.promotion.core.entity.QuestionAnswer;
import com.ssm.promotion.core.service.QuestionAnswerService;
@Service("questionAnswerServiceImpl")
public class QuestionAnswerServiceImpl implements QuestionAnswerService{
	@Resource
	private QuestionAnswerDao questionAnswerDao;
	@Resource
	private QuestionDao questionDao ;
	@Resource 
	private ChapterDao chapterDao;
	
	@Override
	public List<QuestionAnswerDTO> findQuestionAnswer(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<QuestionAnswer> questionAnswers = questionAnswerDao.findQuestionAnswer(map);
		List<QuestionAnswerDTO> questionAnswerDTOs = new ArrayList<QuestionAnswerDTO>();
		if (questionAnswers != null && questionAnswers.size() > 0 ) {
			for (int i = 0; i < questionAnswers.size(); i++) {
				QuestionAnswerDTO questionAnswerDTO = new QuestionAnswerDTO();
				questionAnswerDTO.setId(questionAnswers.get(i).getId());
				questionAnswerDTO.setCorrect(questionAnswers.get(i).getCorrect());
				questionAnswerDTO.setaOrder(questionAnswers.get(i).getaOrder());
				questionAnswerDTO.setAnswer(questionAnswers.get(i).getAnswer());
				questionAnswerDTO.setChapterId(questionAnswers.get(i).getChapterId());
				questionAnswerDTO.setChapterName(questionAnswers.get(i).getChapterName());
				questionAnswerDTO.setCourseId(questionAnswers.get(i).getCourseId());
				questionAnswerDTO.setCourseName(questionAnswers.get(i).getCourseName());
				questionAnswerDTO.setQuestionId(questionAnswers.get(i).getQuestionId());
				questionAnswerDTO.setStem(questionAnswers.get(i).getStem());
				questionAnswerDTOs.add(questionAnswerDTO);
			}
		}
		return questionAnswerDTOs;
	}

	@Override
	public int addqa(QuestionAnswer questionanswer) {
		Question question = questionDao.findById(questionanswer.getQuestionId());
		if (question != null) {
			questionanswer.setStem(question.getStem());
			questionanswer.setChapterId(question.getChapterId());
			questionanswer.setChapterName(question.getChapterName());
			questionanswer.setCourseId(question.getCourseId());
			questionanswer.setCourseName(question.getCourseName());
		}
		List<QuestionAnswer> questionAnswers = questionAnswerDao.findByQuestionId(questionanswer.getQuestionId());
		questionanswer.setaOrder(questionAnswers.size()+1);
		return questionAnswerDao.addQuestionAnswer(questionanswer);
	}

	@Override
	public int updateQuestionAnswer(QuestionAnswer questionanswer) {
//		Question question = questionDao.findById(questionanswer.getQuestionId());
//		if (question != null) {
//			questionanswer.setStem(question.getStem());
//			questionanswer.setChapterId(question.getChapterId());
//			questionanswer.setChapterName(question.getChapterName());
//			questionanswer.setCourseId(question.getCourseId());
//			questionanswer.setCourseName(question.getCourseName());
//		}
		return questionAnswerDao.updateQuestionAnswer(questionanswer);
	}

	@Override
	public int deleteQuestionAnswer(int id) {
		// TODO Auto-generated method stub
		return questionAnswerDao.deleteQuestionAnswer(id);
	}

	@Override
	public QuestionAnswer findQuestionAnswerById(int id) {
		// TODO Auto-generated method stub
		return questionAnswerDao.findQuestionAnswerById(id);
	}

	@Override
	public Long getTotalUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return questionAnswerDao.getTotalUser(map);
	}

	@Override
	public List<QuestionAnswer> findByQuestionId(int questionId) {
		return questionAnswerDao.findByQuestionId(questionId);
	}
	
	
	

}
