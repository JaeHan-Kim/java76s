<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style>
.row{
    margin-left:0px;
    margin-right:0px;
}

#wrapper {
    padding-left: 70px;
    transition: all .4s ease 0s;
    height: 100%
}

#sidebar-wrapper {
    margin-left: -150px;
    left: 70px;
    width: 150px;
    background: #222;
    position: fixed;
    height: 100%;
    z-index: 10000;
    transition: all .4s ease 0s;
}

.sidebar-nav {
    display: block;
    float: left;
    width: 150px;
    list-style: none;
    margin: 0;
    padding: 0;
}
#page-content-wrapper {
    padding-left: 0;
    margin-left: 0;
    width: 100%;
    height: auto;
}
#wrapper.active {
    padding-left: 150px;
}
#wrapper.active #sidebar-wrapper {
    left: 150px;
}

#page-content-wrapper {
  width: 100%;
}

#sidebar_menu li a, .sidebar-nav li a {
    color: #999;
    display: block;
    float: left;
    
    text-decoration: none;
    width: 150px;
    background: #252525;
    border-top: 1px solid #373737;
    border-bottom: 1px solid #1A1A1A;
    -webkit-transition: background .5s;
    -moz-transition: background .5s;
    -o-transition: background .5s;
    -ms-transition: background .5s;
    transition: background .5s;
}
.sidebar_name {
    padding-top: 25px;
    color: #fff;
    opacity: .7;
}

.sidebar-nav li {
  line-height: 40px;
  text-indent: 20px;
}

.sidebar-nav li a {
  color: #999999;
  display: block;
  text-decoration: none;
}

.sidebar-nav li a:hover {
  color: #fff;
  background: rgba(255,255,255,0.2);
  text-decoration: none;
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
  text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
  height: 65px;
  line-height: 60px;
  font-size: 18px;
}

.sidebar-nav > .sidebar-brand a {
  color: #999999;
}

.sidebar-nav > .sidebar-brand a:hover {
  color: #fff;
  background: none;
}

#main_icon
{
    float:right;
   padding-right: 65px;
   padding-top:20px;
}
.sub_icon
{
    float:right;
   padding-right: 65px;
   padding-top:10px;
}
.content-header {
  height: 65px;
  line-height: 65px;
}

.content-header h1 {
  margin: 0;
  margin-left: 20px;
  line-height: 65px;
  display: inline-block;
}

@media (max-width:767px) {
    #wrapper {
    padding-left: 70px;
    transition: all .4s ease 0s;
}
#sidebar-wrapper {
    left: 70px;
}
#wrapper.active {
    padding-left: 150px;
}
#wrapper.active #sidebar-wrapper {
    left: 150px;
    width: 150px;
    transition: all .4s ease 0s;
}
}

  </style>
</head>
<body>
<jsp:include page="/Header.jsp"/>
	
		<div class="container-fluid text-center">
		<div class="row content">
<!--  <div class="col-sm-2">-->
	<div id="wrapper" class="active">

		<div id="sidebar-wrapper">
			<ul id="sidebar_menu" class="sidebar-nav">
				<li class="sidebar-brand"><a id="menu-toggle" href="#">Menu</a></li>
			</ul>
			<ul class="sidebar-nav" id="sidebar">
				<li><a>link1</a></li>
				<li><a>link2</a></li>
			</ul>
		</div>

  <!-- Page content -->
      <div id="page-content-wrapper">
        <!-- Keep all page content within the page-content inset div! -->
        <div class="page-content inset">
             <h3>Some of my Work</h3><br>
  <div class="row">
    <div class="col-xs-4">
    	<video width="320" height="240" controls>
 				<source src="video/file-1449829335165-1.mp4" type="video/mp4">
			</video>
      <p>Some text..</p>
    </div>
  	<div class="col-xs-4">
    	<video width="320" height="240" controls>
 				<source src="video/file-1449832127075-1.mp4" type="video/mp4">
			</video>
      <p>Some text..</p>
    </div>
    <div class="col-xs-4">
    	<video width="320" height="240" controls>
 				<source src="video/file-1449936443602-1.mp4" type="video/mp4">
			</video>
      <p>Some text..</p>
    </div>
  </div>
          </div>
        </div>
      </div>
	</div>
<!--  </div>-->

				
				
		</div>

	<footer class="container-fluid text-center">
		<jsp:include page="/Copyright.jsp" />
	</footer>
<script>
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("active");
});
</script>

</html>
