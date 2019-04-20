package com.ssm.promotion.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.promotion.core.dao.CategoryDao;
import com.ssm.promotion.core.dao.CourseDao;
import com.ssm.promotion.core.dto.CourseDTO;
import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.Course;
import com.ssm.promotion.core.service.CourseService;

/**
 * 
 * @author liu66
 *
 */

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseDao courseDao;
	@Resource
	private CategoryDao categoryDao;
	
	@Override
	public List<CourseDTO> findCourses(Map<String, Object> map) {
		List<Course> courses = courseDao.findCourses(map);
		List<CourseDTO> dtos = new ArrayList<CourseDTO>();
		Course course = null;
		for (int i = 0; i < courses.size(); i++) {
			course = courses.get(i);
			CourseDTO courseDTO = new CourseDTO();
			courseDTO.setCategory(categoryDao.findCategoryById(course.getCategoryId()));
			courseDTO.setPrice(course.getPrice());
			courseDTO.setCourseImg(course.getCourseImg());
			courseDTO.setCourseName(course.getCourseName());
			courseDTO.setDescription(course.getDescription());
			courseDTO.setId(course.getId());
			courseDTO.setTag(course.getTag());
			courseDTO.setIsDel(course.getIsDel());
			courseDTO.setIsNotPaper(course.getIsNotPaper());
			courseDTO.setCreateTime(course.getCreateTime());
			courseDTO.setCreateBy(course.getCreateBy());
			courseDTO.setUpdateTime(course.getUpdateTime());
			courseDTO.setUpdateBy(course.getUpdateBy());
			dtos.add(courseDTO);
		}
		return dtos;
	}

	@Override
	public Long getTotalCourse(Map<String, Object> map) {
		return courseDao.getTotalCourse(map);
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseDao.getAllCourse();
	}

	@Override
	public int addCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@Override
	public int deleteCourse(int id) {
		return courseDao.deleteCourse(id);
	}

	@Override
	public int editCourse(Course course) {
		return courseDao.editCourse(course);
	}

	@Override
	public Course findCourseById(int id) {
		return courseDao.findCourseById(id);
	}

}
