<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	  <title>Bootstrap Example</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link rel="stylesheet" href="/resources/css/default.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="container-fluid">
		  <div class="row content">
		  	<!-- Menu -->
		    <div class="col-sm-3 sidenav">
		      <h4>
		      	Todolist
		      	<span class="pull-right">
		      		<a href="#"><span class="btnAddCate glyphicon glyphicon-plus"></span></a>
		      	</span>
		      </h4>
		      
	      	<div class="input-group input-cate hidden">
	      		<input type="text" class="form-control cname" placeholder="카테고리명을 입력하세요.">
		        <span class="input-group-btn">
		          <button class="btn btn-default btnRegCate" type="button">
		            <span class="glyphicon glyphicon-save"></span>
		          </button>
		        </span>
	      	</div>
	      	
		      <ul class="nav nav-pills nav-stacked"></ul><br>
		    </div>
				<!--// Menu -->
				
				<!-- Content -->
		    <div class="col-sm-9">
		      
		    </div>
		    <!--// Content -->
		  </div>
		</div>
	
		<footer class="container-fluid">
		  <p>Footer Text</p>
		</footer>
		
		
		<script>
			$(".btnAddCate").on("click", function(e){
				e.preventDefault();
				$(this).toggleClass("glyphicon-plus glyphicon-minus");
				$(".input-cate").toggleClass("hidden");
			});
		
			$(".btnRegCate").on("click", function(){
				var $cName = $(".cname");
				return false;
				$.ajax({
					url:"/cate",
					type:"post",
					data:{
						mno:1,
						cname:$cName.val()
					},
					dataType:"text"
				}).done(function(result){
					console.log("result");
					console.log(result);
					$cName.val("");
					getCategoryList();
				});
			});
			
			$("ul.nav").on("click",".remove", function(e){
				e.preventDefault();
				var cno = $(this).closest("li").data("cno"));
			})
			
			function getCategoryList(){
				$.ajax({
					url:"/cate",
					data:{mno:1},
					dataType:"json"
				}).done(function(data){
					var strHtml = '<li class="active" data-cno="0"><a href="#">전체</a></li>';
					for(var i in data){
						strHtml += '<li data-cno="'+data[i].cno+'">'+
											 ' 	<a class="remove" href="#"><i class="glyphicon glyphicon-trash"></i></a>'+
											 '	<a class="cate-name" href="#">'+data[i].cname+'</a>'+
											 '</li>';
					}
					$(".nav").html(strHtml);
				});
			}
			
			
			getCategoryList();
		</script>
	</body>
</html>
