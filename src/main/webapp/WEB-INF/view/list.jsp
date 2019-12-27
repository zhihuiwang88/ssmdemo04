<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../static/layui/css/layui.css" media="all">
</head>
<body>
<script type="text/javascript"  src="../static/layui/layui.js"></script>
<script type="text/javascript" src="../static/layui/lay/modules/jquery.js"></script>
<script type="text/html" id="personBtn">
<a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
</script>

<table id="perTable"  lay-filter="test"></table>

	<script>
	/* 表格数据渲染 */
		layui.use('table', function() {
			var perRender = layui.table;
			perRender.render({
				elem : '#perTable',
				height : 330,
				url : './findAllParam',
				method : 'get',
				page:true,
				limit : 3,
				limits : [ 3, 6, 9 ],
				loading : false,
				skin:'line',
				cols : [ [ {
					type : 'checkbox',
					align : 'center',
					width : 120
				}, {
					field : 'id',
					title : 'ID',
					align : 'center',
					width : 120
				}, {
					field : 'name',
					title : '用户名',
					align : 'center',
					width : 120
				}, {
					field : 'age',
					title : '年龄',
					align : 'center',
					width : 120
				}, {
					field : 'city',
					title : '城市',
					align : 'center',
					width : 120
				}, {
					title : '操作',
					width: 215, 
					align : 'center',
					toolbar:"#personBtn"
				} 
				] ]
				})
			
		});
	
	
	 
	
	
	</script>
</body>
</html>