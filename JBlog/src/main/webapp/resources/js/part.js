/**
 * 
 * @author: XiWenRen 主体部分以外的js效果
 */

$(document).ready((function(){
	appendColorBin();
	$("#head_bar").hover(
			function() {
				$(this).stop().animate({marginTop:'-20px'},SPEED_NORMAL);
				drawText("random_color","随");
			}, function() {
				$(this).stop().animate({marginTop:'-85px'},SPEED_NORMAL);
			});
	$(".color_bin").click(function() {
		changeColor($(this));
	});
}));

//显示可选择的颜色
var appendColorBin = function () {
	var colorPicker = $("#color_picker");
	if(colorPicker.children().length < 2){
		for(var i=0;i<COLOR.length;i++){
			colorPicker.append('<li class="color_bin"></li>');
			colorPicker.children().last().css('background-color',COLOR[i]);
		}
	}
};

//改变块颜色
var changeColor = function (colorBin) {
	if(colorBin.children("#random_color").length > 0){
		randomColor();
	}else{
		var color = colorBin.css('background-color');
		$(".bcolor").css('background-color',color);
	}
};

//canvas写字
var drawText = function (e,text){//要写字的元素的ID值，要写的字
	var c = document.getElementById(e);
	var cxt = c.getContext("2d");
	cxt.fillStyle="white";
	cxt.font = "16px Arial";
	cxt.fillText(text,2,15);
};

//色块颜色随机生成
var randomColor = function() {
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
};
