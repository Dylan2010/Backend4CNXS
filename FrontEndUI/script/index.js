// JavaScript Document

$(document).ready(function() {
    $(".part").hover(function(){
		$(this).find("p").stop().slideDown();
	},function(){
		$(this).find("p").stop().slideUp();
	});
	
	function lineAnimation(){
		var factor1 = parseInt(Math.random()*100);
		var factor2 = parseInt(Math.random()*100);
		var factor3 = parseInt(Math.random()*100);
		
		if(factor1<=33){
			dotAnimation($("#dot1"));
		}
		if(factor2<=33){
			dotAnimation($("#dot2"));
		}
		if(factor3<=33){
			dotAnimation($("#dot3"));
		}
	}
	
	function dotAnimation(ele){
		ele.fadeIn(500,function(){
			ele.fadeOut(500);
		});
	}
	
	function timelineAnimation(){
		$(".base_line").animate({width:'1010px'},1000,'swing',function(){
			$(".timeline_mask").animate({width:'1010px'},1000,'linear',function(){
				$(".part").fadeIn(200);
			});
		});
	}
	timelineAnimation();
	var timer = setInterval(lineAnimation,2000);
	//dotAnimation($("#dot1"));
});