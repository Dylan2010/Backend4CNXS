// JavaScript Document

$(document).ready(function() {
    $(".nav_parent_li").hover(function(){
		$(this).find(".nav_child").stop(true,true).slideDown();
	},function(){
		$(this).find(".nav_child").stop(true,true).slideUp();
	});
	
	/*$("#login a").hover(function(){
		$(this).stop().animate({width:"71px"},200);
	},function(){
		$(this).stop().animate({width:"15px"},200);
	});*/
	/*$("#login").hover(function(){
		$(this).find(".loginbtns").stop().animate({width:"71px"},200);
	},function(){
		$(this).find(".loginbtns").stop().animate({width:"0px"},200);
	});*/
	function calcPageHeight(){
		var minHeight = $(window).height()-$("#navigator").outerHeight()-$("#footer").outerHeight()-89;
		//console.log(minHeight);
		if($("#maincontent").outerHeight()>minHeight){
			minHeight = $("#maincontent").outerHeight();
		}
		$("#maincontent").css("height",minHeight);
	}
	calcPageHeight();
	
	$(window).resize(function(){
		//alert(1);
		calcPageHeight();
	});
	//$("#maincontent").css("min-height",$(window).height()-$("#navigator").outerHeight()-$("#footer").outerHeight()-89);
	
});

