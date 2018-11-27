<!DOCTYPE html>
<%@page import="com.toufiq.Model.Category"%>
<%@page import="com.toufiq.Model.Blog"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp" %>


    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

          <h1 class="my-4">Page Heading
            <small>Secondary Text</small>
          </h1>
          
          <%
          	List<Blog> allBlogs = (List<Blog>)request.getAttribute("blogs");
          %>
			
			<%
				for(Blog aBlog:allBlogs){
					%>
					 <!-- Blog Post -->
			          <div class="card mb-4">
			            <img class="card-img-top" src="<%=request.getContextPath()+"/image/"+aBlog.getImagePath()%>" alt="Card image cap">
			            <div class="card-body">
			              <h2 class="card-title"><%=aBlog.getBlogTitle() %></h2>
			              <p class="card-text"><%=aBlog.getShortDescription() %></p>
			              <a href="<%=request.getContextPath() %>/HomeController?blogId=<%=aBlog.getBlogId()%>" class="btn btn-primary">Read More &rarr;</a>
			            </div>
			            <div class="card-footer text-muted">
			              Category
			              <a href="<%=request.getContextPath() %>/HomeController?categoryId=<%=aBlog.getCategoryId()%>"><%=aBlog.getCategoryName() %></a>
			            </div>
			          </div>
					<%
				}
			%>
         

        


        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Search Widget -->
          <div class="card my-4">
            <h5 class="card-header">Search</h5>
            <div class="card-body">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                  <button class="btn btn-secondary" type="button">Go!</button>
                </span>
              </div>
            </div>
          </div>

			<%
				List<Category> publishedCategories = (List<Category>) request.getAttribute("categories");
			%>
          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
		                 <% for(Category aCategory:publishedCategories){
		               	  %>
		               	   <li>
		                     <a href="<%=request.getContextPath() %>/HomeController?categoryId=<%=aCategory.getCategoryId()%>"><%=aCategory.getCategoryName() %></a>
		                   </li>
		                 <%} %>
                  </ul>
                </div>
               
              </div>
            </div>
          </div>

          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div>

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

  <%@include file="footer.jsp" %>

 </html>


