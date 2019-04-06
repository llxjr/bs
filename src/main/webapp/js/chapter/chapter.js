$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'qf/chapter/datagrid',
						title : '试卷列表',
						fitColumns : true,
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'id',
									title : '编号',
									checkbox : true
								},
//								{
//									field : 'categoryId',
//									title : '类目号',
//									width : 100,
//									sortable : true,
//									rownumbers : true,
//									formatter : function(value, row, index) {
//										return row.category.category_name;
//									}
//								},
								
								{
									field : 'courseId',
									title : '所属课程',
									width : 100,
									sortable : true,
									rownumbers : true,
									formatter : function(value, row, index) {
										return row.courseName;
									}
								},	
								{
									field : 'tag',
									title : '章节标签',
									width : 100
									
								},
								{
									field : "chapterName",
									title : "章节名称",
									width : 100
								},
//								{
//									field : 'createTime',
//									title : '创建时间',
//									width : 160,
//									sortable : true,
//									formatter : function(date){
//										var time = new Date(date.time);
//										return time.toLocaleString();
//									}
//								}, {
//									field : 'createBy',
//									title : '创建人',
//									width : 80
//								}
//								{
//									field : "parentId",
//									title : "父类",
//									width : 100
//								},
//								{
//									field : "isFree",
//									title : "是否免费",
//									width : 100
//								}
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})

function searchChapter() {
	var searchText = $('#c_courseName').val();
	$("#dg").datagrid('load', {
		url: 'qf/chapter/datagrid',
		"courseName" : searchText
	});
}

function look(id) {

		$.ajax({
			url: 'qf/chapter/' + id,
			method: 'GET',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			success: function(read){
				
					$('#dg').datagrid('open');
				} 
		})
}

function getCourse(){
	$.ajax({
        type:"post",
        url:'qf/course/getAllCourse',//访问后台去数据库查询select的选项
        success:function(courses){
            var courseSelect=document.getElementById("courseId"); //页面上的<html:select>元素
        	courseSelect.options.add(new Option("",""));
            if(courses!=null){ //后台传回来的select选项
                for(var i=0;i<courses.length;i++){
                    //遍历后台传回的结果，一项项往select中添加option
                	courseSelect.options.add(new Option(courses[i].courseName,courses[i].id));
                }

                for(var i=0;i<courseSelect.length;i++){
                	
                }
            }
        },
        error:function(){
            alert('Error');
        }
    })
}

function addPage() {
	resetValue();
	$("#courseId").empty();
	getCourse();
	$('#dlg').dialog({
		title : '添加章节',
		closed : false,
		cache: false,
	    width: 600,             
	    height: 300,        
		buttons : [ {
			text : '保存',
			iconCls : 'icon-add',
			handler : function() {
				add();
			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#dlg').dialog("close");
				resetValue();
			}
		} ]
	})

}

function editPage() {
	$("#courseId").empty();
	resetValue();
	getCourse();
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$('#chapterName').val(row.chapterName);
	$('#id').val(row.id);
	$('#courseId').val(row.courseId);
	$('#tag').val(row.tag);
	$('#dlg').dialog({
		title : '编辑章节',
		closed : false,
		buttons : [ {
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				editchapter();
			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#dlg').dialog('close');
				resetValue();
			}
		} ]
	})
}


function add() {
	var chapterName = $('#chapterName').val();
	var courseId = $('#courseId').val();
	var tag = $('#tag').val();
	if (chapterName == null || chapterName == '') {
		$.messager.alert('系统提示', '章节名不能为空!');
		return;
	}
	if (courseId == null || courseId == '') {
		$.messager.alert('系统提示', '课程名不能为空!');
		return;
	}
	var chapter = new Object();
	chapter.chapterName = chapterName;
	chapter.courseId = courseId;
	chapter.tag = tag;
	var data = JSON.stringify(chapter);
	$.ajax({
		url : 'qf/chapter/addChapter',
		type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "添加章节成功!");
				resetValue();
				$('#dlg').dialog("close");
				$('#dg').datagrid('reload');
				return;
			} else {
				$.messager.alert("系统提示", res.message);
				return;
			}
		},
		error : function() {
			$.messager.alert("系统错误!");
			return;
		}

	})
}

function editchapter() {
	var chapterName = $('#chapterName').val();
	var courseId = $('#courseId').val();
	var tag = $('#tag').val();
	if (chapterName == null || chapterName == '') {
		$.messager.alert('系统提示', '章节名不能为空!');
		return;
	}

	var chapter = new Object();
	chapter.id = $("#id").val();
	chapter.chapterName = chapterName;
	chapter.courseId = courseId;
	chapter.tag = tag;
	var data = JSON.stringify(chapter);
	$.ajax({
		url : 'qf/chapter/editChapter',
		type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "编辑章节成功!");
				resetValue();
				$('#dlg').dialog("close");
				$('#dg').datagrid('reload');
				return;
			} else {
				$.messager.alert("系统提示", res.message);
				return;
			}
		},
		error : function() {
			$.messager.alert("系统错误!");
			return;
		}

	})
}

function deleteChapter() {
	var selectedRows = $("#dg").datagrid('getSelections');
	if (selectedRows.length == 0) {
		$.messager.alert("系统提示", "请选择要删除的数据！");
		return;
	}
//	var strIds = [];
//	for ( var i = 0; i < selectedRows.length; i++) {
//		var id = selectedRows[i].id;
//		if (id == 1) {
//			$.messager.alert("系统提示", "操作失败!");
//			return;
//		}
//		strIds.push(id);
//	}
//	var ids = strIds.join(",");
	var row = selectedRows[0];
	$.messager.confirm("系统提示", "您确定要删除这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'qf/chapter/deleteChapter/' + row.id,
				dataType : 'json',
				type : 'DELETE',
				data : {},
				success : function(result) {
					if (result.resultCode == 200) {
						$.messager.alert("系统提示", "删除成功!");
						$('#dg').datagrid('reload');
					} else {
						$.messager.alert("系统提示", result.message);
					}
				}
			})
		}
	})

}



function resetValue() {
//	$("#categoryId").val();
	$("#chapterName").val();
	$("#courseId").val();
	$("#tag").val();
//	$("#chapterName").val();
//	$("#hasVideo").val();
//	$("#hasChild").val();
//	$("#parentId").val();
//	$("#isFree").val();
//	$("#tOrder").val();
//	$("#createTime").val();
//	$("#createBy").val();
//	$("#updateTime").val();
//	$("#updateBy").val();
//	$("#functionType").val();
}

function closeChapterDialog() {
	$("#dlg").dialog("close");
	resetValue();
}
