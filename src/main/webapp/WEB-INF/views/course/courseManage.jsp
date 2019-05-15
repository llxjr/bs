<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/course/course.js"></script>

</head>
<body style="margin:1px;">
	<!--easyui中用于显示的，数据的来源在js里面  -->
	<table id="dg"  class="easyui-datagrid" ></table>
	<div id="tb">
		<div>
			<a href="javascript:addPage()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:editPage()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteCourse()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a><img height="10px" width="10px" src="D:\english1.jpg">
		</div>
		<div>
			&nbsp;课程名：&nbsp;<input type="text" id="c_courseName" size="20"
				onkeydown="if(event.keyCode==13) searchCourse()" /> <a
				href="javascript:searchCourse()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	
	
	<!-- <div id="tb">
		<div>
			<a href="javascript:openCurriculumAddDialog()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:openCurriculumModifyDialog()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deletecurriculum()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;用户名：&nbsp;<input type="text" id="course_name1" size="20"
				onkeydown="if(event.keyCode==13) searchcurriculum()" /> <a
				href="javascript:searchcurriculum()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div> 
	-->

	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="add_form" method="post" enctype="multipart/form-data">
			<table cellspacing="8px">
				<tr>
					<td>课程名称：</td>
					<td><input type="text" id="courseName" name="courseName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font>
						<input type="hidden" id="id" name="id" value="0" />
					</td>
						
				</tr>
				<tr>
					<td>课程价格：</td>
					<td><input type="text" id="price" name="price" class="easyui-validatebox"/>
				</tr>
				<tr>
					<td>课程描述：</td>
					<td><input type="text" id="description" name="description" class="easyui-validatebox"/>
				</tr>
				<tr>
					<td>课程类目：</td>
			<td>
						<select id="categoryId" name="categoryId">
							<option value="">---请选择课程类目---</option>											
						</select>
				 		&nbsp;<font color="red">*</font>
					</td>
				</tr>
				<!-- 
				
				<tr>
					<td>是否启用：</td>
					<td>
						<select id="isDel" name="isDel">
						 <option value="">请选择启用</option>
							<option value="1">启用</option>
							<option value="0">不启用</option>						
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr>
				 -->
				<tr>
					<td>增加图片：</td>
					<td><input type="file" id="courseImg" name="img"></td>
				</tr>
				
			</table>
		</form>
	</div>
	
	<!-- 
		<div id="dlg-buttons">
		<a href="javascript:saveCurriculum()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> 
		<a href="javascript:closeUserDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	 -->
	
</body>
</html>