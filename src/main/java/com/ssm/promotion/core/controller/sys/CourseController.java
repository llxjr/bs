package com.ssm.promotion.core.controller.sys;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.dto.CategoryManageDTO;
import com.ssm.promotion.core.dto.CourseDTO;
import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.Course;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.User;
import com.ssm.promotion.core.service.CourseService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.SQLUtils;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 课程管理
 * @author liu66
 *
 */

@Controller
@RequestMapping("/qf/course")
public class CourseController {
	
	@Resource
	private CourseService courseService;
	
	private static final Logger log = Logger.getLogger(CourseController.class);
	
	/**
	 * 跳转tab
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String index() {
		return "course/courseManage";
	}
	
	/**
	 * @param page
	 * @param rows
	 * @param c_category
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			Course course, HttpServletResponse response) throws Exception {
		Map<String, Object> map = SQLUtils.bulidConditionMap(course.getCourseName(), null, null
				, new PageBean(page, rows));
		List<CourseDTO> list = courseService.findCourses(map);
		Long total = courseService.getTotalCourse(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(list);
		result.put("rows", jsonArray);
		result.put("total", total);
		log.info("request: qf/course/list , map: " + map.toString());
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping(value = "addCourse", method = { RequestMethod.POST })
	@ResponseBody
	public Result addCourse(@RequestParam("img") MultipartFile c_img,
			Course course, HttpServletRequest request) throws Exception {
		System.out.println(c_img);
//		String path = request.getServletContext().getRealPath("\\")+"\\courseImg"; //设定文件保存的目录
		String path = "D:\\ProjectImage\\courseImg";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		StringUtil stringUtil = new StringUtil();
		String fileName = stringUtil.getUUID() + c_img.getOriginalFilename();
		File img = new File(dir, fileName);//获取文件名并存储到dir
		c_img.transferTo(img);//上传
//		course.setCourseImg("courseImg/" + fileName);
		course.setCourseImg(fileName);
		User currentUser = (User) request.getSession().getAttribute(
				Constants.SESSION_USER);
		if (currentUser != null) {
				course.setCreateBy(currentUser.getUserName());
		}
		Date date = new Date();
		course.setCreateTime(date);
		System.out.println("name:"+ fileName);
		System.out.println(course.getCreateTime());
		System.out.println(course);
		try {
			courseService.addCourse(course);
		} catch (Exception e) {
			log.error("add: " + e);
			e.printStackTrace();
			return ResultGenerator.genFailResult("添加失败,服务器异常!");
		}
		return ResultGenerator.genSuccessResult();	
	}
	
	@RequestMapping(value = "editCourse", method = { RequestMethod.POST })
	@ResponseBody
	public Result editCourse(@RequestParam("img") MultipartFile file,Course course,HttpServletRequest request) throws Exception{
		System.err.println("编辑课程" + file.getOriginalFilename());
		String namString = file.getOriginalFilename();
		System.out.println(course.toString());
		if (namString == null || "".equals(namString)) {
			try {
				courseService.editCourse(course);
				return ResultGenerator.genSuccessResult();
			} catch (Exception e) {
				log.error("delete: " + e);
				e.printStackTrace();
				return ResultGenerator.genFailResult("编辑失败,服务器异常!");
			}
		}else{
//			String path=request.getServletContext().getRealPath("\\")+"\\courseImg";
			String path = "D:\\ProjectImage\\courseImg";
			File dir=new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}
			File img = new File(dir, file.getOriginalFilename());//获取文件名并存储到dir
			file.transferTo(img);//上传
//			course.setCourseImg("courseImg/" + file.getOriginalFilename());
			course.setCourseImg(file.getOriginalFilename());
			User currentUser = (User) request.getSession().getAttribute(
					Constants.SESSION_USER);
			if (currentUser != null) {
					course.setUpdateBy(currentUser.getUserName());
			}
			Date date = new Date();
			course.setUpdateTime(date);
			try {
				courseService.editCourse(course);
			} catch (Exception e) {
				log.error("delete: " + e);
				e.printStackTrace();
				return ResultGenerator.genFailResult("编辑失败,服务器异常!");
			}
		}
		return ResultGenerator.genSuccessResult();
	}
	
	/**
	 * 删除课程
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteCourse/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteCategory(@PathVariable Integer id) {
		System.err.println("删除课程");
		try {
			if (id != null) {
				courseService.deleteCourse(id);
			} else {
				return ResultGenerator.genFailResult("数据主键为空");
			}
		} catch (Exception e) {
			log.error("delete: " + e);
			e.printStackTrace();
			return ResultGenerator.genFailResult("删除失败,服务器异常!");
		}
		return ResultGenerator.genSuccessResult();
	}
	
	@RequestMapping(value = "getAllCourse", method = { RequestMethod.POST })
	@ResponseBody
	public List<Course> getAllCourse(){
		List<Course> courses = new ArrayList<Course>();
		courses = courseService.getAllCourse();
		return courses;
	}
}
