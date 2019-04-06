$(function() {
	$('#dg').datagrid(
					{
						url : 'qf/question/datagrid',
						title : '题目管理',
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
								{
									field : 'stem',
									title : '题干',	
									width : 100
								},
								{
									field : 'courseId',
									title : '课程',	
									width : 100,
									formatter : function(value, row, index) {
										return row.course.courseName;
									}
								},
								{
									field : 'chapterId',
									title : '章节',	
									width : 100,
									formatter : function(value, row, index) {
										return row.chapter.chapterName;
									}
								},
//								{
//									field : 'parentId',
//									title : '父类id',
//									width : 100
//								},
								{
									field : 'level',
									title : '等级',
									width : 100,
									formatter : function(value, row, index) {
										if (value == 3) {
											return "困难";
										} 
										else if(value == 2) {
											return "一般";
										}else {
											return "简单";
										}
									}
								},
								{
									field : 'questionType',
									title : '题目类别',
									width : 100,
									formatter : function(value, row, index) {
										return row.questionType.type_name;
									}
								},{
									field : 'answerNum',
									title : '回答数目',
									width : 100
								},{
									field : 'correctNum',
									title : '正确数目',
									width : 100
								},{
									field : 'errorNum',
									title : '错误数目',
									width : 100
								},
								{
									field : 'value',
									title : '分值',
									width : 100
								},
								{
									field : 'correct',
									title : '是否正确',
									width : 100
								},
								{
									field : 'bankType',
									title : '题库类别',
									width : 100,
									formatter: function(value, row, index){
										if(value == 1){
											return "基础练习题";
										}else{
											return "强化练习题";
										}
									}
								},
								 ] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
	$("#courseId").change(function(){
		$("#chapterId").empty();
		var courseId = $("#courseId").val();
		$.ajax({
			url : 'qf/chapter/findbycourseid/' + courseId,
			type : 'POST',
			data : {},
			dataType : "json",//预期服务器返回的数据类型
			contentType : 'application/json; charset=utf-8',
			success:function(chapters){
				var chapterSelect=document.getElementById("chapterId"); //页面上的<html:select>元素
				chapterSelect.options.add(new Option("",""));
	            if(chapters!=null){ //后台传回来的select选项
	                for(var i=0;i<chapters.length;i++){
	                    //遍历后台传回的结果，一项项往select中添加option
	                	chapterSelect.options.add(new Option(chapters[i].chapterName,chapters[i].id));
	                }
	                for(var i=0;i<chapterSelect.length;i++){
	                	
	                }
	            }
			},
			error : function() {
				$.messager.alert("系统错误!");
				return;
			}
		})
	});
})

function searchQuestion() {
	var stem = $('#s_stem').val();
	var courseName = $("#s_courseName").val();
	$("#dg").datagrid('load', {
		url: 'qf/question/datagrid',
		"stem" : stem,
		"courseName":courseName
	});
}


function addPage() {
	resetValue();
	getCourse();
	$("#answerNum").val(0);
	$("#correctNum").val(0);
	$("#errorNum").val(0);
	$('#dlg').dialog({
		title : '添加题目',
		closed : false,
		cache: false,
	    width: 600,             
	    height: 300,        
		buttons : [ {
			text : '保存',
			iconCls : 'icon-add',
			handler : function() {
				addQuestion();
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
	resetValue();
	getCourse();
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$("#id").val(row.id);
	$("#stem").val(row.stem);
	$("#chapterId").val(row.chapterId);
//	$("#parentId").val(row.parentId);
	$("#bankType").val(row.bankType);
	$("#level").val(row.level);
	$("#questionType").val(row.questionType);
	$("#answerNum").val(row.answerNum);
	$("#correctNum").val(row.correctNum);
	$("#errorNum").val(row.errorNum);
	$("#value").val(row.value);
	$('#dlg').dialog({
		title : '编辑问题',
		closed : false,
		buttons : [ {
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				editQuestion();
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

function addQuestion() {
	var stem = $("#stem").val();
	var chapterId = $("#chapterId").val();
//	var parentId = $("#parentId").val();
	var bankType = $("#bankType").val();
	var level = $("#level").val();
	var questionType = $("#questionType").val();
	var answerNum = $("#answerNum").val();
	var correctNum = $("#correctNum").val();
	var errorNum = $("#errorNum").val();
	var value = $("#value").val();
	if (stem == null || stem == '') {
		$.messager.alert('系统提示', '题干不能为空!');
		return;
	}
	if (chapterId == null || chapterId == '') {
		$.messager.alert('系统提示', '章节不能为空!');
		return;
	}
	if (level == null || level == '') {
		$.messager.alert('系统提示', '等级不能为空!');
		return;
	}
	if (questionType == null || questionType == '') {
		$.messager.alert('系统提示', '题目类型不能为空!');
		return;
	}
	if (answerNum == null || answerNum == '' || answerNum != 0) {
		$.messager.alert('系统提示', '答题次数必须为0!');
		return;
	}
	if (correctNum == null || correctNum == '' || correctNum != 0) {
		$.messager.alert('系统提示', '正确次数必须为0!');
		return;
	}
	if (errorNum == null || errorNum == '' || errorNum != 0) {
		$.messager.alert('系统提示', '错误次数必须为0!');
		return;
	}

	var question = {
			"stem" : stem,
			"chapterId" : chapterId,
//			"parentId" : parentId,
			"bankType" : bankType,
			"level" : level,
			"questionType" : questionType,
			"answerNum" : answerNum,
			"correctNum" : correctNum,
			"correctNum" : correctNum,
			"errorNum": errorNum,
			"value" : value
		}
	var data = JSON.stringify(question);
	$.ajax({
		url : 'qf/question/addQuestion',
		type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "添加题目成功!");
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

function editQuestion() {
	var id = $("#id").val();
	var stem = $("#stem").val();
	var chapterId = $("#chapterId").val();
//	var parentId = $("#parentId").val();
	var bankType = $("#bankType").val();
	var level = $("#level").val();
	var questionType = $("#questionType").val();
	var answerNum = $("#answerNum").val();
	var correctNum = $("#correctNum").val();
	var errorNum = $("#errorNum").val();
	var value = $("#value").val();
	if (stem == null || stem == '') {
		$.messager.alert('系统提示', '题干不能为空!');
		return;
	}
	if (level == null || level == '') {
		$.messager.alert('系统提示', '等级不能为空!');
		return;
	}
//	if (answerNum == null || answerNum == '' || answerNum != 0) {
//		$.messager.alert('系统提示', '答题次数必须为0!');
//		return;
//	}
//	if (correctNum == null || correctNum == '' || correctNum != 0) {
//		$.messager.alert('系统提示', '正确次数必须为0!');
//		return;
//	}
//	if (errorNum == null || errorNum == '' || errorNum != 0) {
//		$.messager.alert('系统提示', '错误次数必须为0!');
//		return;
//	}

	var question = {
			"id": id,
			"stem" : stem,
			"chapterId" : chapterId,
//			"parentId" : parentId,
			"bankType" : pankType,
			"level" : level,
			"questionType" : questionType,
			"answerNum" : answerNum,
			"correctNum" : correctNum,
			"correctNum" : correctNum,
			"errorNum": errorNum,
			"value" : value
		}
	var data = JSON.stringify(question);
	$.ajax({
		url : 'qf/question/editQuestion',
		type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "编辑题目成功!");
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

function deleteQuestion() {
	var selectedRows = $("#dg").datagrid('getSelections');
	if (selectedRows.length == 0) {
		$.messager.alert("系统提示", "请选择要删除的数据！");
		return;
	}

	var row = selectedRows[0];
	$.messager.confirm("系统提示", "您确认要删除这条数据吗？", function(r) {
		if (r) {
			$.ajax({
				type : "DELETE",//方法类型
				dataType : "json",//预期服务器返回的数据类型
				url : 'qf/question/deleteQuestion/' + row.id,
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



function resetValue() {
	$("#stem").val();
	$("#courseId").empty();
	$("#chapterId").empty();
//	$("#parentId").val();
	$("#bankType").val();
	$("#level").val();
	$("#questionType").val();
	$("#answerNum").val();
	$("#correctNum").val();
	$("#errorNum").val();
	$("#value").val();
	
}



