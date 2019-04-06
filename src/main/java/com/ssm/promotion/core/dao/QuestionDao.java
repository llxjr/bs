package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

//import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.Question;
import com.ssm.promotion.core.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author blue
 * @project_name perfect-ssm
 * @date 2018-10-11
 */
@Repository
public interface QuestionDao {

   

    /**
     * 查找用户列表
     *
     * @param map
     * @return
     */
    public List<Question> findQuestion(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalQuestion(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param Question
     * @return
     */
    public int updateQuestion(Question question);

    /**
     * 添加用户
     *
     * @param Question
     * @return
     */
    public int addQuestion(Question question);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteQuestion(Integer id);
    
    /**
     * 
     * @param Question
     * @return
     */
  
    
    /**
     * 根据id获取问题
     * @param uuid
     * @return
     */
    Question findById(Integer id);
    
    /**
     * 查询全部
     * @return
     */
	public List<Question> findAllQuestion();
    
   
}
