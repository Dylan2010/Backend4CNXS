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
	
	$("#maincontent").css("min-height",$(window).height()-$("#navigator").outerHeight()-$("#footer").outerHeight()-89);
	
});

