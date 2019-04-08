package com.ssm.promotion.core.controller.sys;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.controller.base.BasicController;
import com.ssm.promotion.core.dto.QuestionAnswerDTO;
import com.ssm.promotion.core.entity.Article;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.QuestionAnswer;
import com.ssm.promotion.core.entity.User;
import com.ssm.promotion.core.service.QuestionAnswerService;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/qf/answer")
public class QuestionAnswerController extends BasicController {

 @Resource
 private QuestionAnswerService qas;
 private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

	@RequestMapping(value = "/list")
	public String index(){
		return "answer/questionanswer";
	}
 
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			QuestionAnswer questionanswer, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("answer", StringUtil.formatLike(questionanswer.getAnswer()));
		map.put("courseName", StringUtil.formatLike(questionanswer.getCourseName()));
		map.put("stem", StringUtil.formatLike(questionanswer.getStem()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<QuestionAnswerDTO> questionanswerDtos = qas.findQuestionAnswer(map);
		System.out.println(questionanswerDtos);
		Long total = qas.getTotalUser(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(questionanswerDtos);
		result.put("rows", jsonArray);
		result.put("total", total);
		log.info("request: user/list , map: " + map.toString());
		ResponseUtil.write(response, result);
		return null;
	}
 
 	@RequestMapping(value = "addQuestionAnswer", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody QuestionAnswer questionanswer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int resultTotal = 0;
		resultTotal =qas.addqa(questionanswer);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

@RequestMapping(value = "updateQuestionAnswer", method = RequestMethod.POST)
 @ResponseBody
 public Result update(@RequestBody QuestionAnswer questionanswer, HttpServletRequest request,
			HttpServletResponse response) throws  Exception{
	System.out.println(questionanswer.getId());
	int resultTotal = 0;
	 resultTotal = qas.updateQuestionAnswer(questionanswer);
	 if (resultTotal > 0) {
	 	 return ResultGenerator.genSuccessResult();
	 } else {
		 return ResultGenerator.genFailResult("FAIL");
	 }
	 
 }
 
 @RequestMapping(value = "deleteQuestionAnswer/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result delete(@PathVariable(value = "id") int id)
			throws Exception {
//		if (ids.length() > 20) {
//			return ResultGenerator.genFailResult("ERROR");
//		}
//		String[] idsStr = ids.split(",");
//		for (int i = 0; i < idsStr.length; i++) {
			qas.deleteQuestionAnswer(id);
//		}
//		log.info("request: article/delete , ids: " + ids);
		return ResultGenerator.genSuccessResult();
	}
	 @RequestMapping(value = "findbyid/{id}",method=RequestMethod.POST)
	 @ResponseBody
	 public QuestionAnswer findbyid(int id ){
		 
		 QuestionAnswer questionanswer =qas.findQuestionAnswerById(id);
	 return questionanswer;
	 }
	 
	 @RequestMapping(value = "findByQuestionId/{questionId}",method=RequestMethod.POST)
	 @ResponseBody
	 public void findByQuestionId(int questionId,HttpServletRequest request){
		 List<QuestionAnswer> questionAnswers = qas.findByQuestionId(questionId);
		 request.getSession().setAttribute("answers", questionAnswers);
		 
	 }
}
