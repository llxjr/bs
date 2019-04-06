$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'qf/course/datagrid',
						title : '课程管理',
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
									field : 'courseName',
									title : '课程名称',	
									width : 100
								},
								{
									field : 'description',
									title : '课程描述',
									width : 100
								},
								{
									field : 'categoryId',
									title : '类目',
									width : 100,
									  formatter : function(value, row, index) {
											return row.category.categoryName;
										}
								
								},
								{
									field : 'isDel',
									title : '是否启用',
									width : 80,
									sortable : true,
									rownumbers : true,
									formatter : function(value, row, index) {
										if (value == 0) {
											return "否";
										} else {
											return "是";
										}
									}
								},
								{
									field : 'courseImg',	
									title : '图片',
									height: 100,
									width : 80,	
									formatter: function(value,row,index) {
										return'<img width="120px"  height="120px" src="' + value + '" />';
									}
								},
							] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
});

function reset() {
	$('#id').val("");
	$('#courseName').val("");
	$('#description').val("");
	$('#tag').val("");
}

function addPage() {
	$("#categoryId").empty();
	reset();
	getCategory();  
	$('#dlg').dialog({
		title : '添加课程',
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
				reset();
			}
		} ]
	})

}

function add() {
	var courseName = $('#courseName').val();
	var description = $('#description').val();
	var categoryId = $('#categoryId').val();
	var tag = $('#tag').val();
	if (courseName == null || courseName == '') {
		$.messager.alert('系统提示', '课程名不能为空!');
		return;
	}
	if (categoryId == null || categoryId == '') {
		$.messager.alert('系统提示', '请选择目录!');
		return;
	}
//	var course = new Object();
//	course.courseName = categoryName;
//	course.description = description;
//	course.tag = tag
	var formobj = document.getElementById("add_form");
	var data=new FormData(formobj);
//	var data = JSON.stringify(category);
	$.ajax({
		url : 'qf/course/addCourse',
		type : 'POST',
		data : data,
		processData:false,
		contentType:false,
		dataType : 'json',
//		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "添加课程成功!");
				reset();
				$('#dlg').dialog("close");
				$('#dg').datagrid('reload');
			} else {
				$.messager.alert("系统提示", res.message);
			}
		},
		error : function() {
			$.messager.alert("系统错误!");
		}

	})
}

function editPage() {
	$("#categoryId").empty();
	reset();
	getCategory();  
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$('#add_form').form('load', row);
	$("#id").val(row.id);
	var id = $("id").val();
	console.log(id);
	$('#dlg').dialog({
		title : '编辑课程',
		closed : false,
		buttons : [ {
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				edit(id);
			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#dlg').dialog('close');
				reset();
			}
		} ]
	})
}

function edit(id) {
	console.log("编辑课程");
	var formobj = document.getElementById("add_form");
	var data=new FormData(formobj);
	var str = data.toString();
	$.ajax({
		url : 'qf/course/editCourse',
		type : 'POST',
		data : data,
		processData:false,
		contentType:false,
		dataType : 'json',
//		contentType : 'application/json; charset=utf-8',
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "编辑课程成功!");
				reset();
				$('#dlg').dialog("close");
				$('#dg').datagrid('reload');
			} else {
				$.messager.alert("系统提示", res.message);
			}
		},
		error : function() {
			$.messager.alert("系统错误!");
		}

	})
//	$.ajax({
//		url : 'qf/category/editCategory',
//		type : 'POST',
//		data : data,
//		dataType : 'json',
//		contentType : 'application/json; charset=utf-8',
//		success : function(res) {
//			if (res.resultCode == 200) {
//				$.messager.alert("系统提示", "编辑菜单成功!");
//				reset();
//				$('#dlg').dialog("close");
//				$('#dg').datagrid('reload');
//			} else {
//				$.messager.alert("系统提示", res.message);
//			}
//		},
//		error : function() {
//			$.messager.alert("系统错误!");
//		}
//
//	})
}

function deleteCourse() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$.messager.confirm("系统提示", "您确定要删除这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'qf/course/deleteCourse/' + row.id,
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

function getCategory(){
	$.ajax({
        type:"post",
        url:'qf/category/findAllCategory',//访问后台去数据库查询select的选项
        success:function(categorise){
            var categorySelect=document.getElementById("categoryId"); //页面上的<html:select>元素
        	categorySelect.options.add(new Option("",""));
            if(categorise!=null){ //后台传回来的select选项
                for(var i=0;i<categorise.length;i++){
                    //遍历后台传回的结果，一项项往select中添加option
                	categorySelect.options.add(new Option(categorise[i].categoryName,categorise[i].id));
                }
                for(var i=0;i<categorySelect.length;i++){
                	
                }
            }
        },
        error:function(){
            alert('Error');
        }
    })
}

function searchCourse() {
	var searchText = $('#c_courseName').val();
	$("#dg").datagrid('load', {
		url: 'qf/course/datagrid',
		"courseName" : searchText
	});
}