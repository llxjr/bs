package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author blue
 * @project_name perfect-ssm
 * @date 2018-10-11
 */
@Repository
public interface ChapterDao {

    

    /**
     * 查找Chapter列表
     *
     * @param map
     * @return
     */
    public List<Chapter> findChapter(Map<String, Object> map);
    
    public List<Chapter> findChapterByCourseName(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalChapter(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param Chapter
     * @return
     */
    public int updateChapter(Chapter chapter);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addChapter(Chapter chapter);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteChapter(Integer id);
    
    /**
     * 根据用户名获取用户
     * @param user
     * @return
     */
    Chapter getChapterByName(String paperName);
    
    /**
     * 根据id获取用户
     * @param uuid
     * @return
     */
    public Chapter findById(Integer id);
   
    
    /**
     * 根据课程id查找
     * @param id
     * @return
     */
    public List<Chapter> findByCourseId(int courseId);
    
    /**
     * 查询全部
     * @return
     */
    List<Chapter> findAllChapter();
    
}
