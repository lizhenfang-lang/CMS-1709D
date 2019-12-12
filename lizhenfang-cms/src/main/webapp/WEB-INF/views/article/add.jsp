<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form>
  <div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章标题</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" placeholder="请输入标题">
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章图片</label>
		<div class="col-sm-10">
			<input type="file" class="form-control" placeholder="请输入标题">
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属频道</label>
		<div class="col-sm-10">
			<select id="inputState" class="form-control">
		        <option selected>请选择频道...</option>
		        <option>科技</option>
		        <option>财经</option>
		        <option>国际</option>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">所属分类</label>
		<div class="col-sm-10">
			<select id="inputState" class="form-control">
		        <option selected>请选择频道...</option>
		        <option>科技</option>
		        <option>财经</option>
		        <option>国际</option>
		      </select>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章内容</label>
		<div class="col-sm-10">
			<textarea rows="" cols=""></textarea>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">保存设置</button>
		</div>
	</div>
</form>
