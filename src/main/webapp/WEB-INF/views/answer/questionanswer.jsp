<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/answer/questionanswer.js"></script>

</head>
<body style="margin:1px;">
	<table id="dg"  class="easyui-datagrid"></table>
	<div id="tb">		
		<div>
			<a href="javascript:addPage()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:editPage()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteQuestionAnswer()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
		
		<div>
			&nbsp;答案：&nbsp;<input type="text" id="s_answer" size="20"
				onkeydown="if(event.keyCode==13) searQuestionAnswer()" /> 
				题目：&nbsp;<input type="text" id="s_stem" size="20"
				onkeydown="if(event.keyCode==13) searQuestionAnswer()" /> 
				课程：&nbsp;<input type="text" id="s_courseName" size="20"
				onkeydown="if(event.keyCode==13) searQuestionAnswer()" /> <a
				href="javascript:searQuestionAnswer()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>答案：</td>
					<td><input type="text" id="answer" name="answer"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="id" value="0">
					</td>
				</tr>
				<tr>
					<td>所属题目</td>
					<td>
						<select id='questionId' name='questionId'>
							<option value=''>---请选择题目---</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>是否正确：</td>
					<td>
						<select id='correct' name='correct'>
							<option value=''>---选择正确与否---</option>
							<option value='1'>---正确---</option>
							<option value='0'>---不正确---</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>