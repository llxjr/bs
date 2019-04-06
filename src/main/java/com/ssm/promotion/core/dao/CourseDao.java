package com.ssm.promotion.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.promotion.core.entity.Course;

/**
 * 
 * @author liu66
 *
 */

@Repository
public interface CourseDao {

	public List<Course> findCourses(Map<String,Object> map);
	public Long getTotalCourse(Map<String,Object> map);
	public List<Course> getAllCourse();
	public int addCourse(Course course);
	public int deleteCourse(int id);
	public int editCourse(Course course);
	public Course findCourseById(int id);
}
