package com.ssm.promotion.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.Role;
import com.ssm.promotion.core.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.CategoryDao;
import com.ssm.promotion.core.dao.ChapterDao;
import com.ssm.promotion.core.dao.CourseDao;
//import com.ssm.promotion.core.dao.CurriculumDao;
//import com.ssm.promotion.core.dao.PaperDao;
import com.ssm.promotion.core.dao.UserDao;
import com.ssm.promotion.core.dto.ChapterDTO;
import com.ssm.promotion.core.service.ChapterService;
//import com.ssm.promotion.core.service.PaperService;
import com.ssm.promotion.core.service.RoleService;
import com.ssm.promotion.core.service.UserService;
import com.ssm.promotion.core.util.MD5Util;
import com.ssm.promotion.core.util.StringUtil;


@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterDao chapterDao;
    @Resource
    private CourseDao courseDao;
//    private CurriculumDao curriculumDao;
    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<ChapterDTO> findChapter(Map<String, Object> map) {
    	List<ChapterDTO> dtoList = new ArrayList<ChapterDTO>();
    	List<Chapter> cList =chapterDao.findChapterByCourseName(map);
    	Chapter chapter = null;
    	for (int i = 0; i < cList.size(); i++) {
			chapter =cList.get(i);
			ChapterDTO dto =new ChapterDTO();
//			dto.setCategory(categoryDao.findCategorybyid(chapter.getCategoryId()));
//			dto.setCurriculum(curriculumDao.findCurriculumById(chapter.getCourseId()));
//			dto.setCourse(courseDao.findCourseById(chapter.getCourseId()));
			dto.setId(chapter.getId());
			dto.setCourseId(chapter.getCourseId());
			dto.setCourseName(chapter.getCourseName());
			dto.setChapterName(chapter.getChapterName());
			dto.setTag(chapter.getTag());;
			dto.setFunctionType(chapter.getFunctionType());
			dto.setHasChild(chapter.getHasChild());
//			dto.setHasVideo(chapter.getHasVideo());
			dto.setIsFree(chapter.getIsFree());
			dto.setParentId(chapter.getParentId());
			dto.settOrder(chapter.gettOrder());
			dto.setCreateTime(chapter.getCreateTime());
			dto.setCreateBy(chapter.getCreateBy());
			dtoList.add(dto);
		}
        return dtoList;
    }

    @Override
    public int updateChapter(Chapter chapter) {
     return chapterDao.updateChapter(chapter);
    }

    @Override
    public Long getTotalChapter(Map<String, Object> map) {
        return chapterDao.getTotalChapter(map);
    }

    @Override
    public int addChapter(Chapter chapter) {
 
        return chapterDao.addChapter(chapter);
    }

    @Override
    public int deleteChapter(Integer id) {
      return chapterDao.deleteChapter(id);
    }



	@Override
	public List<Chapter> findAllChapter() {
		// TODO Auto-generated method stub
		return chapterDao.findAllChapter();
	}

	@Override
	public Chapter findById(Integer id) {
		// TODO Auto-generated method stub
		return chapterDao.findById(id);
	}

	@Override
	public List<Chapter> findByCourseId(int courseId) {
		return chapterDao.findByCourseId(courseId);
	}



}
