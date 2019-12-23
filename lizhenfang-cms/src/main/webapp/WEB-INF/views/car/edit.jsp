<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="editForm">
  <div class="control-group">
    <label>名称</label>
    <div class="controls">
      <input type="text" id="name" name="name" placeholder="请输入名称..." value="${car.name}">
    </div>
  </div>
  
  <div class="control-group">
    <label>价格</label>
    <div class="controls">
      <input type="text" id="price" name="price" placeholder="请输入密码..." value="${car.price}">
    </div>
  </div>
  
  <div class="control-group">
    <label>状态</label>
    <div class="controls">
      <input type="text" id="state" name="state" placeholder="请输入状态..." value="${car.state}">
    </div>
  </div>
  
  <div class="control-group">
    <label>颜色</label>
    <div class="controls">
      <input type="text" id="color" name="color" placeholder="请输入颜色..." value="${car.color}">
    </div>
 </div>
 
   <input type="hidden" id="id" name="id" value="${car.id}">
   
  <div class="control-group">
    <div class="controls">
     <button type="button" onclick="save()">保存</button>
    </div>
  </div>
</form>
<script type="text/javascript">
  function save() {
	var name=$("#name").val();
	var price=$("#price").val();
	var state=$("#state").val();
	var color=$("#color").val();
	if (name==null || name=="") {
		$(".alert").html("名称不能为空");
		$(".alert").show();
		return;
	}
	//封装表单
	var formDate=$("#editForm").serialize();
	$.post("/admin/car/save",formDate,function(msg){
		console.log(msg);
		reload();
	})
}
</script>


</html>