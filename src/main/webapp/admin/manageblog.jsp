<!doctype html>
<%@page import="com.toufiq.Model.Blog"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.toufiq.Model.Category"%>
<%@page import="java.util.List"%>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Manage Blog</title>
  </head>
  <body>
    <%@ include file="header.jsp" %>
   <div class="container" style="margin-top: 100px">
    <div class="row">
        <div class=" m-xl-auto">
            <div class="card" >
                <div class="card-body" >
                    <h3 class="text-center">
						All Blogs
                    </h3>
                    <table class="table">
                    <thead class="thead-dark">
		                <tr>
		                    <th scope="col">Sl No</th>
		                    <th scope="col">Blog Title</th>
		                    <th scope="col">Category Name</th>
		                       <th scope="col">Short Description</th>
		                    <th scope="col">Status</th>
		                    <th scope="col">Action</th>
		                </tr>
			               
	                </thead>
	                <tbody>
	                	<%
	                		List<Blog> allBlog = (List<Blog>)request.getAttribute("allblogs");
	                	 %>
		                
		               <%for(int i=0;i<allBlog.size();i++){
		            	   %>
		            	   <tr>
		            	  		<td>
		            	  			<%=i+1 %>
		            	  		</td>
		            	  		<td><%=allBlog.get(i).getBlogTitle() %></td>
		            	  		<td><%=allBlog.get(i).getCategoryName() %></td>
		            	  		<td><%=allBlog.get(i).getShortDescription() %></td>
		            	  		<td><%=allBlog.get(i).getPublicationStatus()==1?"Published":"Unpublished" %></td>
		            	  		<td>
		            	  			<a href="<%=request.getContextPath() %>/BlogControllerPath?edit=<%=allBlog.get(i).getBlogId()%>">Edit</a>/
		            	  			<a href="<%=request.getContextPath() %>/BlogControllerPath?delete=<%=allBlog.get(i).getBlogId()%>" onclick="return confirm('Are you sure?')">Delete</a>
		            	  		</td>
		            	  	
		            	   </tr>
		            	   <%
		               } 
		               
		               %>
	                </tbody>
                    </table>
                   
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>