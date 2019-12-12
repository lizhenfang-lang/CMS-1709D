<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <form class="form-inline">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="name" class="form-control" placeholder="请输入登录名">
	  </div>
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="nickname" class="form-control" placeholder="请输入昵称">
	  </div>
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">登录名称</th>
      <th scope="col">用户昵称</th>
      <th scope="col">是否禁用</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>zhangsan</td>
      <td>蝈蝈</td>
      <td>否</td>
      <td>
      	<button type="button" class="btn btn-primary">禁用</button>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>lisi</td>
      <td>糖果</td>
      <td>是</td>
      <td>
      	<button type="button" class="btn btn-primary">启用</button>
      </td>
    </tr>
  </tbody>
</table>

<div class="row">
	<!-- <nav aria-label="Page navigation example col-5" style="margin-right: 10px;">
		<button type="button" class="btn btn-primary">添加</button>
		<button type="button" class="btn btn-primary">批删</button>
	</nav> -->
   	<nav aria-label="Page navigation example col-4">
	  <ul class="pagination">
	    <li class="page-item"><a class="page-link" href="#">上一页</a></li>
	    <li class="page-item"><a class="page-link" href="#">1</a></li>
	    <li class="page-item"><a class="page-link" href="#">2</a></li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item"><a class="page-link" href="#">下一页</a></li>
	  </ul>
	</nav>
</div>

<script>
	function query(){
		var params = $("form").serialize();
		reload(params);
	}
</script>
