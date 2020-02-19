<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form>
  <input type="text" name="name" value="${tousu.articleId}" placeholder="请输入名称...">
  <input type="hidden" name="pageNum" value="${pageInfo.pageNum}">
   <button type="button" onclick="query()">查询</button>
</form>


<table class="table">
  <tr>
    <td><input type="checkbox" id="chkAll"></td>
    <td>主键</td>
    <td>所属用户id</td>
    <td>收藏夹地址</td>
    
    <td>文本内容</td>
    <td>添加时间</td>
    <td>操作</td>
  </tr>
   <c:forEach items="${pageInfo.list}" var="li">
     <tr>
        <td><input type="checkbox" name="chk_list" value="${li.id}"></td>
        <td>${li.id}</td>
        <td>${li.articleId}</td>
        <td>${li.userId}</td>
        <td>${li.content}</td>
        <td>${li.created}</td>
        <td>
           <button onclick="del(${li.id})">删除</button>
           <button onclick="upd(${li.id})">修改</button>
        </td>
        </tr>
      </c:forEach>
</table>
<button onclick="delAll()">批删</button>
<button onclick="add()">添加</button>
<!-- 分页 -->
<jsp:include page="../common/page.jsp"></jsp:include>

<script src="/public/js/checkbox.js"></script>
<script>
	//添加
	function add() {
		openPage("/admin/Sc/edit");
	}
	//编辑
	function upd(id) {
		openPage("/admin/Sc/edit?id="+id);
	}
	//分页
	function gotoPage(pageNo){
		$("[name=pageNum]").val(pageNo);
		query();
	}
	//批量删除
    function delAll() {
		var ids=getCheckboxIds();
		console.log(ids);
		if (confirm("确定要删除吗？")) {
			$.post("/admin/Sc/deleteAll",{ids:ids},function(msg){
				if (msg) {
					alert("删除成功！");
					reload();
				}else {
					alert("删除失败！");
				}
			})
		}
		
	}
	//查询
	function query(){
		var params = $("form").serialize();
		reload(params);
	}
</script>
