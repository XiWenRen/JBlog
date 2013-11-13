/**
 * 
 * @author: XiWenRen 主体部分以外的js效果
 */

$(document).ready((function(){
	
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

function changeColor(colorBin) {
	if(colorBin.children("#random_color").length > 0){
		randomColor();
	}else{
		var color = colorBin.css('background-color');
		$(".bcolor").css('background-color',color);
	}
}

function drawText(e,text){//要写字的元素的ID值，要写的字
	var c = document.getElementById(e);
	var cxt = c.getContext("2d");
	cxt.fillStyle="white";
	cxt.font = "16px Arial";
	cxt.fillText(text,2,15);
}
