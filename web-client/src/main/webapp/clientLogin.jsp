<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录餐桌</title>
    
	 <meta name="renderer" content="webkit">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"  media="all">
	  <script src="${pageContext.request.contextPath }/layui/layui.js" charset="utf-8"></script>
	  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	
	<style type="text/css">
		body{
			margin: 0px;
			padding: 0px;
			width: 100%;
			height: 100%;
			background-image: url("${pageContext.request.contextPath }/img/004.jpg");
			}
		#q{
			text-align: center;
			margin-right: 80px;
			margin-top: 100px;
		}
	</style>
  </head>
  
  <body>
	<div id="q" class="layui-col-xs18 layui-col-sm6 layui-col-md4">
		<form class="layui-form" action="${pageContext.request.contextPath }/clientLogin">
		 <label class="layui-form-label" style="width: 100%;text-align: center;">餐桌登录系统</label>
		  <div class="layui-form-item">
		    <label class="layui-form-label">输入框</label>
		    <div class="layui-input-block">
		      <input type="text" name="d_id" required  lay-verify="required" placeholder="请输入id" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">密码框</label>
		    <div class="layui-input-inline">
		      <input type="password" name="d_password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit style="width: 50%" >立即提交</button>
		      <button type="reset" class="layui-btn layui-btn-primary" style="width: 30%">重置</button>
		    </div>
		  </div>
		</form>
 
	<script>
	//Demo
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
	</script>
	</div>
  </body>
</html>
