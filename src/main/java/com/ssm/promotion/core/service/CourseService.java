package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.dto.CourseDTO;
import com.ssm.promotion.core.entity.Course;

/**
 * 
 * @author liu66
 *
 */

public interface CourseService {
	public List<CourseDTO> findCourses(Map<String, Object> map);
	public Long getTotalCourse(Map<String, Object> map);
	public List<Course> getAllCourse();
	public Course findCourseById(int id);
	public int addCourse(Course course);
	public int deleteCourse(int id);
	public int editCourse(Course course);
}
