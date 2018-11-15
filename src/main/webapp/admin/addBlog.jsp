<%@page import="com.toufiq.Model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>

<title>Add Category</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-sm-12 m-xl-auto">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Add Blog</h3>
						<form
							action="<%=request.getContextPath()%>/BlogControllerPath"
							method="post" enctype="multipart/form-data">
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">Blog
									Title</label>
								<div class="col-sm-9">
									<input type="text" name="blogtitle" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">Category
									Name</label>
								<div class="col-sm-9">
									<select class="form-control" name="categoryid">
									 <%List<Category> publishedCategories = (List<Category>)request.getAttribute("publishedCategories");%>
									 
									 <%for(Category myCategory :publishedCategories){
										 %>
										 <option value="<%=myCategory.getCategoryId() %>"><%=myCategory.getCategoryName() %></option>
										 <%
									 } %>
										
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">Short
									Description</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="3" cols="50"
										name="shortdescription"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">Long
									Description</label>
								<div class="col-sm-9">
									<textarea class="form-control" rows="10" cols="50"
										name="longdescription"></textarea>
								</div>
							</div>
							 <div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">Blog
									Image</label>
								<div class="col-sm-9">
									<input type="file" name="blogimage" class="form-control" >
								</div>
							</div>
							
							
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">Publication
									Status</label>
								<div class="col-sm-9">
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											id="inlineCheckbox1" name="status" value="0"> <label
											class="form-check-label" for="inlineCheckbox1" checked>Unpublished</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											id="inlineCheckbox2" name="status" value="1"> <label
											class="form-check-label" for="inlineCheckbox2">Published</label>
									</div>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-sm-12">
									<button type="submit" name="operationbtn"
										class="btn btn-success btn-block" value="addblog">Save
										Blog</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script>tinymce.init({ selector:'textarea' });</script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>