<%@page import="com.toufiq.Model.Admin"%>
<%
Admin myAdmin = null;
String errorpage = "";
try {
	if(session.getAttribute("admin")==null){
		throw new Exception();
	}
	 myAdmin = (Admin)session.getAttribute("admin");
} catch (Exception e) {
	errorpage = "index.jsp";
	RequestDispatcher dd=request.getRequestDispatcher(errorpage);
	dd.forward(request, response);
} 


%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Admin Pannel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Category Info
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <a class="dropdown-item" href="<%=request.getContextPath() %>/CategoryControllerPath?req=addcategory">Add Category</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="<%=request.getContextPath() %>/CategoryControllerPath?req=managecategory">Manage Category</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Blog Info
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <a class="dropdown-item" href="<%=request.getContextPath() %>/BlogControllerPath?req=addblog">Add Blog</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="<%=request.getContextPath() %>/BlogControllerPath?req=manageblog">Manage Blog</a>
                    </div>
                </li>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    
                     <%=myAdmin.getEmail()%>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <a class="dropdown-item" href="<%=request.getContextPath() %>/adminlogin?logout=true">Logout</a>

                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>