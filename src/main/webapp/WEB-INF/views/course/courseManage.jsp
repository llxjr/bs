<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/course/course.js"></script>
<!-- 
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/qf/course";
	var method;
	
	function searchcurriculum() {
		$("#dg").datagrid('load', {
			"course_name" : $("#course_name1").val()
		
		});
	}
	

	function deletecurriculum() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要删除的数据！");
			return;
		}
		var strIds = [];
		for ( var i = 0; i < selectedRows.length; i++) {
			var id = selectedRows[i].id;
			alert(id);
			
			strIds.push(id);
		}
		var ids = strIds.join(",");
		alert(ids);
		$.messager.confirm("系统提示", "您确认要删除这<font color=red>"
				+ selectedRows.length + "</font>条数据吗？", function(r) {
			if (r) {
			
				$.ajax({
					type : "DELETE",//方法类型
					dataType : "json",//预期服务器返回的数据类型
					url : url + '/' + ids,//url
					data : {},
					success : function(result) {
						//console.log(result);//打印服务端返回的数据
						if (result.resultCode == 200) {
							$.messager.alert("系统提示", "数据已成功删除！");
							$("#dg").datagrid("reload");
						} else {
							$.messager.alert("系统提示", "数据删除失败！");
						}

						;
					},
					error : function() {
						$.messager.alert("ERROR！");
					}
				});
			}
		});

	}

	function openCurriculumAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "添加课程信息");
		method = "POST";
		url=url+"/add";
	}

	function saveCurriculum() {
		var data=new FormData(document.getElementById("fm"));
		$.ajax({
			type :'POST',//方法类型
			url : url,//url
			processData:false,
			contentType:false,
			dataType:'JSON',
			data : data,
			success : function(result) {
				//console.log(result);//打印服务端返回的数据
				if (result.resultCode == 200) {
					$.messager.alert("系统提示", "新增成功");
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
					resetValue();
				} else {
					$.messager.alert("系统提示", "操作失败");
					$("#dlg").dialog("close");
					resetValue();
				}
				;
			},
			error : function() {
				$.messager.alert("系统提示", "操作失败");
			}
		});
	}

	function openCurriculumModifyDialog() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if (selectedRows.length != 1) {
			$.messager.alert("系统提示", "请选择一条要编辑的数据！");
			return;
		}
		var row = selectedRows[0];
		if (row.id == 1) {
			$.messager.alert("系统提示", "操作失败！");
			return;
		}
		if (row.roleId != '' && row.roleId != '') {
			$('#role').find("option[ value='"+ row.roleId + "']").attr("selected", true);
		}
		$("#dlg").dialog("open").dialog("setTitle", "编辑课程信息");
		$('#fm').form('load', row);
		$("#id").val(row.id);
		method = "PUT";
		url="qf/course/update"
	}

	function resetValue() {
		$("#userName").val("");
		$("#password").val("");
	}

	function closeUserDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}
	
	$(function(){
		//获取所有类目
		$.ajax({
			url: 'qf/category/findAllCategorie',
			type: 'GET',
			dataType: 'json',
			success: function(lst) {
				//console.log(lst);
				for (var i = 0; i < lst.length; ++i) {
					var item = lst[i];
					var html = "<option value='" + item.id + "'>" + item.category_name +"</option>";
					$('#category_id').append(html);
				}
			}, error: function() {
				console.log("获取权限类目失败");
			}
		});
	})
</script>
-->

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
			&nbsp;类目名：&nbsp;<input type="text" id="c_courseName" size="20"
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