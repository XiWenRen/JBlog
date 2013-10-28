<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<style type="text/css">
.ddiv {
	height: 20px;
	width: 100px;
	border: 1px solid black;
	float: left;
	overflow: visible;
}
</style>
</head>


<script src="resources/js/jquery-2.0.3.js"></script>
<script type="text/javascript">
	$(document).ready(
			(function() {
				//AJAX getJSON提交方式 参数:
				$.post("article/allArticles?blogId=1", function(data) {
					$.each(data, function(idx, item) {
						$("#article").append(
								"标题：" + item.articleTitle + "</br>文章:"
										+ item.articleContent + "</br>" + "作者："
										+ item.userId + "</br>");
					});
				});
			}));
</script>
<body>

	<div id="article"></div>

</body>
</html>
