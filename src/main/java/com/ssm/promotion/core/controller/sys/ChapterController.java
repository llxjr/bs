package com.ssm.promotion.core.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.controller.base.BasicController;
import com.ssm.promotion.core.dto.ChapterDTO;
import com.ssm.promotion.core.entity.Category;
import com.ssm.promotion.core.entity.Chapter;
import com.ssm.promotion.core.entity.Course;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Paper;
import com.ssm.promotion.core.entity.User;
import com.ssm.promotion.core.redis.RedisUtil;
import com.ssm.promotion.core.service.ChapterService;
import com.ssm.promotion.core.service.CourseService;
import com.ssm.promotion.core.service.UserService;
import com.ssm.promotion.core.util.MD5Util;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

/**
 * @author liu66
 */
@Controller
@RequestMapping("/qf/chapter")
public class ChapterController extends BasicController {

	@Resource
	private ChapterService chapterService;
	@Resource
	private CourseService courseService;	
	@Autowired
	private static final Logger log = Logger.getLogger(ChapterController.class);// 日志文件
	

	/**
	 * 跳转tab
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String index() {
		return "chapter/chapter";
	}

	/**
	 * @param page
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			Chapter c_chapter, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseName", StringUtil.formatLike(c_chapter.getCourseName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<ChapterDTO> chapterList = chapterService.findChapter(map);
		
		Long total = chapterService.getTotalChapter(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(chapterList);
		result.put("rows", jsonArray);
		result.put("total", total);
		log.info("request: chapter/list , map: " + map.toString());
		ResponseUtil.write(response, result);
		return null;
	}
	

	/**
	 * 添加或修改
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addChapter", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody Chapter chapter, HttpServletRequest request) throws Exception {
		int resultTotal = 0;
		User currentUser = (User) request.getSession().getAttribute(
				Constants.SESSION_USER);
		if (currentUser != null) {
			chapter.setCreateBy(currentUser.getUserName());
		}
		Course course = courseService.findCourseById(chapter.getCourseId());
		chapter.setCourseName(course.getCourseName());
		Date date = new Date();
		chapter.setCreateTime(date);
		resultTotal = chapterService.addChapter(chapter);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

	/**
	 * 修改
	 * 
	 * @param paper
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "editChapter", method = { RequestMethod.POST })
	@ResponseBody
	public Result update(@RequestBody Chapter chapter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(chapter.getCourseId());
		int resultTotal = chapterService.updateChapter(chapter);
		log.info("request: chapter/update , chpater: " + chapter.toString());
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

	/**
	 * 删除章节
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteChapter/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result delete(@PathVariable Integer id)
			throws Exception {
//		if (ids.length() > 20) {
//			return ResultGenerator.genFailResult("ERROR");
//		}
//		String[] idsStr = ids.split(",");
//		for (int i = 0; i < idsStr.length; i++) {
			chapterService.deleteChapter(id);
//		}
		log.info("request: chapter/delete , id: " + id);
		return ResultGenerator.genSuccessResult();
	}
	/**
	 * 查询全部
	 * @return
	 */
	@RequestMapping(value = "/findAllChapter", method = RequestMethod.GET)
	@ResponseBody
	public List<Chapter> findAllChapter(){
		
		List<Chapter> result = null;
		try {
			result = chapterService.findAllChapter();
		} catch (Exception e) {
			log.error("获取所有类目失败：" + e.getMessage());
		}
		return result;
	}
	/**
	 * 根据课程id查找
	 * @return
	 */
	@RequestMapping(value = "/findbycourseid/{courseId}", method = RequestMethod.POST)
	@ResponseBody
	public List<Chapter> findByCourseId(@PathVariable Integer courseId){
		List<Chapter> result = null;
		try {
			result = chapterService.findByCourseId(courseId);
		} catch (Exception e) {
			log.error("获取所有类目失败：" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	
}
