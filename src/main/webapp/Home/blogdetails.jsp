<!DOCTYPE html>
<%@page import="com.toufiq.Model.Blog"%>
<html lang="en">

<%@include file="header.jsp" %>

  <%Blog aBlog =(Blog) request.getAttribute("blog"); %>
    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <!-- Title -->
          <h1 class="mt-4"><%=aBlog.getBlogTitle() %></h1>

          <!-- Author -->
          <p class="lead">
            by
            <a href="#">Admin</a>
          </p>

          <hr>

          <!-- Date/Time -->
          <p>Category Name 
          	<a href="<%=request.getContextPath() %>/HomeController?categoryId=<%=aBlog.getCategoryId()%>"><%=aBlog.getCategoryName() %></a>
          </p>

          <hr>

          <!-- Preview Image -->
          <img class="img-fluid rounded" src="<%=request.getContextPath()+"/image/"+aBlog.getImagePath()%>" alt="img">

          <hr>

          <!-- Post Content -->
          <p class="lead"></p>

          <p><%=aBlog.getLongDescription() %></p>

       
         

          
          <hr>

          <!-- Single Comment -->
          <div class="media mb-4">
           
          </div>

          <!-- Comment with nested comments -->
          <div class="media mb-4">
           

          </div>

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

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">Web Design</a>
                    </li>
                    <li>
                      <a href="#">HTML</a>
                    </li>
                    <li>
                      <a href="#">Freebies</a>
                    </li>
                  </ul>
                </div>
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="#">JavaScript</a>
                    </li>
                    <li>
                      <a href="#">CSS</a>
                    </li>
                    <li>
                      <a href="#">Tutorials</a>
                    </li>
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
