<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/question/question.js"></script>
</head>
<body style="margin:1px;">
	<!--easyui中用于显示的，数据的来源在js里面  -->
	<table id="dg"></table>
	<div id="tb">
		<div>
		<div>
			<a href="javascript:addPage()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:editPage()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteQuestion()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;课程名：&nbsp;<input type="text" id="s_courseName" size="20"
				onkeydown="if(event.keyCode==13) searchQuestion()" /> 
				题干名：&nbsp;<input type="text" id="s_stem" size="20"
				onkeydown="if(event.keyCode==13) searchQuestion()" /> <a
				href="javascript:searchQuestion()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>题干：</td>
					<td><input type="text" id="stem" name="stem"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="id" value="0" name="id">
					</td>
				</tr>
				<tr>
					<td>课程：
						<select id='courseId' name='courseId'>
								<option value=''>--选择课程--</option>
						</select>
					</td>
					<td>章节id：<select type="text" id="chapterId" name="chapterId"
						class="easyui-validatebox" required="true" >
						<option value=''>--选择章节--</option>
						</select>&nbsp;<font
						color="red">*</font>
					</td>
				</tr>
				<!-- 
					<tr>
						<td>父类id：</td>
						<td><input type="text" id="parentId" name="parentId"
							class="easyui-validatebox" required="true" />&nbsp;<font
							color="red">*</font></td>
					</tr>
				 -->
				<tr>
					<td>等级：</td>
					<td>
						<select id='level' name='level'>
								<option value='1'>简单</option>
								<option value='2'>一般</option>
								<option value='3'>困难</option>
						</select>
						&nbsp;<font	color="red">*</font>
					</td>
						
				</tr>
				<tr>
					<td>题目类别：</td>
					<td>
						<select id='questionType' name='questionType'>
								<option value='1'>选择题</option>
								<option value='2'>简答题</option>
								<option value='3'>判断题</option>
								<option value='4'>填空题</option>
								<option value='5'>补全短文</option>
								<option value='6'>改错题</option>
								<option value='7'>选词填空题</option>
								<option value='8'>共题干题</option>
								<option value='9'>阅读理解</option>
								<option value='10'>完形填空</option>
						</select>&nbsp;<font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>回答数：</td>
					<td><input type="text" id="answerNum" name="answerNum"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>正确数：</td>
					<td><input type="text" id="correctNum" name="correctNum"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>错误数：</td>
					<td><input type="text" id="errorNum" name="errorNum"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>分值：</td>
					<td><input type="text" id="value" name="value"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font></td>
				</tr>
				<!--
					<tr>
						<td>正确与否：</td>
						<td>
							正确<input type="radio" name="correct"  value="1">
							错误<input type="radio" name="correct"  value="0">
						</td>
					</tr>
				 -->
					<tr>
						<td>题库类别：</td>
						<td><select id='bankType' name='bankType'>
								<option value=''>---请选择课程---</option>
								<option value='1'>---基础题库题目---</option>
								<option value='2'>---强化题库题目---</option>
							</select>
							&nbsp;<font color="red">*</font>
						</td>
					</tr>

			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveQuestion()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeQuestionDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>