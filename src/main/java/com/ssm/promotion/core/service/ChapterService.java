package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.ChapterDTO;
import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.User;

/**
 * @author zpy
 * @project_name perfect-ssm
 * @date 2018-10-10
 */
public interface ChapterService {

    
    /**
     * @param map
     * @return
     */
   public List<ChapterDTO> findChapter(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalChapter(Map<String, Object> map);

    /**
     * @param Chapter
     * @return
     */
    public int updateChapter(Chapter chapter);

    /**
     * @param Chapter
     * @return
     */
    public int addChapter(Chapter chapter);

    /**
     * @param id
     * @return
     */
    public int deleteChapter(Integer id);
    
  
    /**
     * 根据id获取章节
     * @param uuid
     * @return
     */
    public Chapter findById(Integer id);
    
    /**
     * 根据课程id查找
     * @param courseId
     * @return
     */
    public List<Chapter> findByCourseId(int courseId);
    
    /**
     * 查询全部
     * @return
     */
    List<Chapter>findAllChapter();
}
