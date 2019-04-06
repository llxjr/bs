$(function() {
	$('#dg').datagrid(
					{
						url : 'qf/answer/datagrid',
						title : '答案管理',
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
									field : 'questionId',
									title : '题目',	
									width : 100,
									formatter:function(value, row, index){
										return row.stem;
									}
								},
								{
									field : 'answer',
									title : '答案',
									width : 100
								},
								{
									field : 'courseId',
									title : '课程',	
									width : 100,
									formatter : function(value, row, index) {
										return row.courseName;
									}
								},
								{
									field : 'chapterId',
									title : '章节',	
									width : 100,
									formatter : function(value, row, index) {
										return row.chapterName;
									}
								},
								{
									field : 'correct',
									title : '是否正确 ',
									width : 80,
									formatter: function(value, row, index){
										if(value == 1){
											return '<span style="color:green">是</span>';
										}else{
											return '<span style="color:red">否</span>';
										}
									}
								}
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})

function searQuestionAnswer() {
		$("#dg").datagrid('load', {
			"answer" : $("#s_answer").val(),
			"stem": $("#s_stem").val(),
			"courseName": $("#s_courseName").val()
		});
	}

function addPage() {
	resetValue();
	findAllQuestion();
	$('#dlg').dialog({
		title : '添加答案',
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
			}
		} ]
	})

}

function editPage() {
	resetValue();
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$('#answer').val(row.answer);
	$('#id').val(row.id);
	document.getElementById("questionId").options.add(new Option("不能修改题目", "-1"));
//	$('#questionId').options.add(new Option("不能修改题目"), "");
	$('#correct').val(row.correct);
	$('#dlg').dialog({
		title : '编辑章节',
		closed : false,
		buttons : [ {
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				edit();
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

function add(){
	var answer = $('#answer').val();
	var questionId = $('#questionId').val();
	var correct = $('#correct').val();
	if (answer == null || answer == '') {
		$.messager.alert('系统提示', '答案不能为空!');
		return;
	}
	if (questionId == null || questionId == '') {
		$.messager.alert('系统提示', '所属题目不能为空!');
		return;
	}
	if (correct == null || correct == '') {
		$.messager.alert('系统提示', '是否正确不能为空!');
		return;
	}
	var questionAnswer = new Object();
	questionAnswer.answer =answer;
	questionAnswer.questionId =questionId;
	questionAnswer.correct =correct;
	var data = JSON.stringify(questionAnswer);
	$.ajax({
		url : 'qf/answer/addQuestionAnswer',
		type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "添加问题成功!");
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

function edit(){
	var id = $('#id').val();
	var answer = $('#answer').val();
//	var questionId = $('#questionId').val();
	var correct = $('#correct').val();
	if (correct == null || correct == '') {
		$.messager.alert('系统提示', '是否正确不能为空');
		return;
	}
	var questionAnswer = new Object();
	questionAnswer.id = $("#id").val();
	questionAnswer.answer = answer;
//	questionAnswer.questionId = questionId;
	questionAnswer.correct = correct-0;
	var data = JSON.stringify(questionAnswer);
	$.ajax({
		url : 'qf/answer/updateQuestionAnswer',
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

function deleteQuestionAnswer() {
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
				url : 'qf/answer/deleteQuestionAnswer/' + row.id,//url
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


function findAllQuestion(){
	$.ajax({
		url: 'qf/question/findAllQuestion',
		type: 'GET',
		success: function(questions){
			var questionSelect = document.getElementById("questionId");
			questionSelect.options.add(new Option("请选择题目",""));
			if(questions != null){
				for (var i = 0; i < questions.length; i++) {
					questionSelect.options.add(new Option(questions[i].stem, questions[i].id));
				}
			}
		},
		error: function(){
			$.massager.alert("系统错误");
		}
	})
}


function resetValue(){
	$("#answer").val();
	$("#questionId").empty();
	$("#correct").val();
}
