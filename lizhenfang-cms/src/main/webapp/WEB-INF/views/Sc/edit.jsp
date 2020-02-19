<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="editForm">
  <div class="control-group">
    <label>收藏夹文本</label>
    <div class="controls">
      <input type="text" id="articleId" name="articleId" placeholder="请输入收藏夹文本..." value="${tousu.articleId}">
    </div>
  </div>
  
  <div class="control-group">
    <label>所属用户id</label>
    <div class="controls">
      <input type="text" id="userId" name="userId" placeholder="请输入收藏夹地址..." value="${tousu.userId}">
    </div>
  </div>
  
  <div class="control-group">
    <label>文本内容</label>
    <div class="controls">
      <input type="text" id="content" name="content" placeholder="请输入所属用户..." value="${tousu.content}">
    </div>
  </div>
  
  <div class="control-group">
    <label>添加时间</label>
    <div class="controls">
      <input type="text" id="created" name="created" placeholder="请输入添加时间..." value="${tousu.created}">
    </div>
 </div>
 
   <input type="hidden" id="id" name="id" value="${tousu.id}">
   
  <div class="control-group">
    <div class="controls">
     <button type="button" onclick="save()">保存</button>
    </div>
  </div>
</form>
<script type="text/javascript">
  function save() {
	var name=$("#articleId").val();
	var price=$("#userId").val();
	var state=$("#content").val();
	var color=$("#created").val();
	if (name==null || articleId=="") {
		$(".alert").html("名称不能为空");
		$(".alert").show();
		return;
	}
	//封装表单
	var formDate=$("#editForm").serialize();
	$.post("/admin/Sc/save",formDate,function(msg){
		console.log(msg);
		reload();
	})
}
</script>


</html>