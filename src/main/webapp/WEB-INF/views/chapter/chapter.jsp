<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/chapter/chapter.js"></script>
</head>
<body style="margin:1px;">
	<table id="dg"  class="easyui-datagrid"></table>
	<div id="tb">
		<div>
			<a href="javascript:addPage()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:editPage()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteChapter()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;章节名：&nbsp;<input type="text" id="c_courseName" size="20"
				onkeydown="if(event.keyCode==13) searchChapter()" /> <a
				href="javascript:searchChapter()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>章节名称：</td>
					<td><input type="text" id="chapterName" name="chapterName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="id"  value="0" name="id">
					</td>
				</tr>
<!-- 
				<tr>
					<td>所属类目：</td>
					<td>
						<select id='category' name='category'>
							<option value='-1'>---请选择类目---</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr>
-->
				 
				<tr>
					<td>所属课程：</td>
					<td>
						<select id='courseId' name='courseId'>
							<option value='-1'>---请选择课程---</option>
						</select>
						&nbsp;<font color="red">*</font>
					</td>
				</tr><td>章节标签：</td>
					<td><input type="text" id="tag" name="tag"
						class="easyui-validatebox"/>&nbsp;
					</td>
				</tr>
<!--
				<tr>
					<td>章节名称：</td>
					<td><input type="text" id="chapterName" name="chapterName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
 

				<tr>
					<td>视频：</td>
					<td><input type="text" id="hasVideo" name="hasVideo"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden"  value="0">
					</td>
				</tr>

 -->
				
				
				<!-- 
				<tr>
					<td>子类：</td>
					<td><input type="text" id="hasChild" name="hasChild"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden"  value="0">
					</td>
				</tr>
				
				<tr>
					<td>父类：</td>
					<td><input type="text" id="parentId" name="parentId"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden"  value="0">
					</td>
				</tr>
				<tr>
					<td>是否免费：</td>
					<td><input type="text" id="isFree" name="isFree"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden"  value="0">
					</td>
				</tr>
				 -->
				
				

			</table>
		</form>
	</div>
<!-- 
	<div id="dlg-buttons">
		<a href="javascript:saveChapter()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeChapterDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
-->
</body>
</html>