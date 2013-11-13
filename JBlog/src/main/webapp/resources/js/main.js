/**
 * @author: XiWenRen
 * 主题部分的js效果
 */

SPEED_SLOW = 1000;
SPEED_NORMAL = 500;
SPEED_FAST = 255;
BIGBLOCK_HEIGHT = 300;
BIGBLOCK_WIDTH = 700;

COLOR_YELLOW = 'rgb(244,179,0)';
COLOR_BLUE = 'rgb(37,115,236)';
COLOR_GREEN = 'rgb(120,186,0)';
COLOR_RED = 'rgb(174,17,61)';
COLOR_BROWN = 'rgb(99,47,0)';
COLOR_PINK = 'rgb(193,0,79)';

$(document).ready((function() {
	// AJAX getJSON提交方式 参数:
	$.post("article/allArticles?blogId=1", function(data) {
		$.each(data, function(idx, item) {
			appendNav(item);
			appendArticle(item);
		});
		$("#body_articles").css('margin-left', $("#body_nav").width());// take
		// into
		// css
		$(".btn_bar").hover(function() {
			$(this).stop().animate({
				opacity : 1
			}, SPEED_NORMAL);
			drawArrow();
		}, function() {
			$(this).stop().animate({
				opacity : 0
			}, SPEED_FAST);
		});
		$(".btn").click(function() {btnAction($(this));});
		randomColor();
	});
}));

// 显示列表
function appendNav(item) {
	$("#nav").append(
			'<ul><li><a href="#article_block' + item.articleId + '">'
					+ item.articleTitle + '</a></li></ul>');
}

// 显示文章
function appendArticle(item) {
	$("#body_articles")
			.append(
					'<article id="article_block'
							+ item.articleId
							+ '" class="wholeArtBlock">'
							+ '<div class="article_date bcolor">'
							+ item.articleId
							+ '</div>'
							+ '<div class="article_title bcolor">'
							+ item.articleTitle
							+ '</div>'
							+ '<article class="article_content bcolor">'
							+ item.articleContent
							+ '</article><article class="article_comments bcolor"></article>'
							+ '<div class="btn_bar"><canvas class="btn toleft">浏览器不支持1</canvas><canvas class="btn todown">浏览器不支持2</canvas></div>'
							+ '</article>');
};

//点击按钮
function btnAction(btn) {
	var btnBar = btn.parent();
	if (btn.hasClass("toleft")) {
		btnBar.css('opacity', '0');
		var blockCom = btnBar.prev();// 获取回复模块
		if (blockCom.css('display') == 'none') {
			artToCom(blockCom);
		} else {
			comToArt(blockCom);
		}
	} else {
		var blockCon = btnBar.prev().prev();
		toggleContent(blockCon);
	}
}

//展开文章
function toggleContent(content) {
	var conHeight = pxToInt(content.css('height'));// 获取高度
	if(conHeight <= BIGBLOCK_HEIGHT){
		var conLen = content.text().length;// 获取字数
		var fontSize = pxToInt(content.css('font-size'));// 获取字号
		var conWidth = pxToInt(content.css('width'));// 获取宽度
		var eachLineWord = conWidth / fontSize - 4;// 计算每行字数为宽度/字号
		var newHeight = conLen / eachLineWord * fontSize;// 计算显示文章所有内容的高度
		if (newHeight > conHeight) {
			content.animate({
				height : newHeight + 'px'
			}, SPEED_SLOW);
			extendBtnBar(content,newHeight);
		}
	}else{
		content.animate({
			height : BIGBLOCK_HEIGHT+'px'
		}, SPEED_SLOW);
		extendBtnBar(content, BIGBLOCK_HEIGHT);
	}
	
}

//延长btnBar
function extendBtnBar(content,newHeight){
	var btnBar = content.next().next();
	btnBar.animate({height:newHeight+"px"},SPEED_SLOW);
	var btnDown = btnBar.children(".btn").eq(1);
	var btnHeight = pxToInt(btnDown.css('height'));
	btnDown.animate({marginTop:(newHeight-2*btnHeight) + 'px'},SPEED_SLOW);
	btnBar.css('height',newHeight+"px");
	btnDown.css('margin-top',(newHeight-2*btnHeight) + 'px');
}

// 进入回复页面
function artToCom(toComBtn) {
	var con = toComBtn.prev();// 获得到article_content元素
	var com = con.next();
	blockSlide(con, com);
}

// 进入文章页面
function comToArt(toArtBtn) {
	var com = toArtBtn;
	var con = com.prev();
	blockSlide(com, con, 'R');
}

// 去除px
function pxToInt(pxStr) {
	return parseInt(pxStr.replace("px", ""));
}

// 画箭头
function drawArrow() {
	var c = document.getElementsByClassName("btn");
	for (var i = 0; i < c.length; i++) {
		var cxt = c[i].getContext("2d");
		cxt.lineWidth = 8;
		cxt.strokeStyle = 'white';
		cxt.moveTo(75, 75);
		cxt.lineTo(225, 75);
		cxt.lineTo(150, 50);
		cxt.moveTo(225, 75);
		cxt.lineTo(150, 100);
		cxt.stroke();
	}
}

// 方块交替滑动
function blockSlide(bOut, bIn, direction) {
	var dirNum = (direction != 'R') ? '-400px' : '400px';
	bOut.animate({
		marginLeft : dirNum
	}, 500);
	bOut.fadeOut(100);
	setTimeout(function() {
		bIn.fadeIn(0);
		bIn.animate({
			marginLeft : '0px'
		}, 255);
	}, 600);
}

//色块颜色随机生成
function randomColor() {
	var wholeArts = $(".wholeArtBlock");
	wholeArts.each(function() {
		$(this).children().each(function() {
			if($(this).hasClass('bcolor')){
				var r = Math.round(Math.random()*255);
				var g = Math.round(Math.random()*255);
				var b = Math.round(Math.random()*255);
				$(this).css('background-color','rgb('+r+','+g+','+b+')');
			}
		});
	});
}