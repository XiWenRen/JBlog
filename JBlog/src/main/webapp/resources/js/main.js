/**
 * @author: XiWenRen
 * 主题部分的js效果
 */

SPEED_SLOW = 1000;
SPEED_NORMAL = 500;
SPEED_FAST = 255;
BIGBLOCK_HEIGHT = 300;
BIGBLOCK_WIDTH = 700;

COLOR = new Array();
COLOR[0] = 'rgb(244,179,0)';
COLOR[1] = 'rgb(37,115,236)';
COLOR[2] = 'rgb(120,186,0)';
COLOR[3] = 'rgb(174,17,61)';
COLOR[4] = 'rgb(99,47,0)';
COLOR[5] = 'rgb(193,0,79)';

$(document).ready((function() {
	// AJAX getJSON提交方式 参数:
	$.post("article/sortArticles?blogId=1", function(data) {
		$.each(data, function(idx, item) {
			appendNav(item);
			appendArticle(item);
		});
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
		
		$(".menu").click(function() {
			$(this).next().slideToggle(SPEED_NORMAL);
		});
	});
}));

// 显示列表
var appendNav = function (item) {
	var sortNav = '<a href="#" class="menu">'+item.sortName+'</a><ul class="menu_lis">$titles</ul>';
	var titNav = '';
	$.each(item.articleList, function(idx, art) {
		titNav += ('<li><a href="#article_block'+art.articleId+'">'+ art.articleTitle +'</a></li>');
	});
	sortNav = sortNav.replace('$titles', titNav);
	$("#nav").append(sortNav);
	$("#nav").children().last().slideToggle(SPEED_NORMAL);
};

// 显示文章
var appendArticle = function (item) {
	var artList = '';
	$.each(item.articleList, function(idx, art) {
		artList += '<article id="article_block'
			+ art.articleId
			+ '" class="wholeArtBlock">'
			+ '<div class="article_date bcolor">'
			+ art.articleId
			+ '</div>'
			+ '<div class="article_title bcolor">'
			+ art.articleTitle
			+ '</div>'
			+ '<article class="article_content bcolor" id="'+art.articleId+'"><span>'
			+ art.articleContent
			+ '</span></article><article class="article_comments bcolor"></article>'
			+ '<div class="btn_bar"><canvas class="btn toleft" title="查看回复">浏览器不支持1</canvas>'
			+ '<canvas class="btn todown" title="展开文章">浏览器不支持2</canvas></div>'
			+ '</article>';
	});
	$("#body_articles").append(artList);
};

//点击按钮
var btnAction = function (btn) {
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
};

//展开文章
var toggleContent = function (content) {
	var conHeight = pxToInt(content.css('height'));// 获取高度
	if(conHeight <= BIGBLOCK_HEIGHT){
		var conLen = content.text().length;// 获取字数
		var fontSize = pxToInt(content.css('font-size'));// 获取字号
		var lineHei = pxToInt(content.css('line-height'));
		var conWidth = pxToInt(content.css('width'));// 获取宽度
		var eachLineWord = conWidth / fontSize;// 计算每行字数为宽度/字号
		var newHeight = conLen / eachLineWord * lineHei;// 计算显示文章所有内容的高度
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
	
};

//延长btnBar
var extendBtnBar = function (content,newHeight){
	var btnBar = content.next().next();
	btnBar.animate({height:newHeight+"px"},SPEED_SLOW);
	var btnDown = btnBar.children(".btn").eq(1);
	var btnHeight = pxToInt(btnDown.css('height'));
	btnDown.animate({marginTop:(newHeight-2*btnHeight) + 'px'},SPEED_SLOW);
	btnBar.css('height',newHeight+"px");
	btnDown.css('margin-top',(newHeight-2*btnHeight) + 'px');
};

// 进入回复页面
var artToCom = function (com) {
	var con = com.prev();// 获得到article_content元素
	var artId = con.attr("id");
	$.post("comment?articleId=1", function(data) {
		alert(data);
		$.each(data, function(idx, item) {
			
		});
	});
	blockSlide(con, com);
};

// 进入文章页面
var comToArt = function (com) {
	var con = com.prev();
	blockSlide(com, con, 'R');
};

// 去除px
var pxToInt = function (pxStr) {
	return parseInt(pxStr.replace("px", ""));
};

// 画箭头
var drawArrow = function () {
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
};

// 方块交替滑动
var blockSlide = function (bOut, bIn, direction) {
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
};

//Map类型(试验)
function Map(){
	this.maps = new Array();
	
	this.put = function(key,value){
		var map = new Object();
		map.key = key;
		map.value = value;
		this.maps[this.maps.length] = value;
	};
	
	this.get = function(key) {
		var keyIndex = this.getKeyIndex(key);
		return this.maps[keyIndex].value;
	};
	
	this.getKeyIndex = function(key){
		for(var i=0;i<this.maps.length;i++){
			if(this.maps[i].key == key){
				return i;
			}
		}
	};
}
