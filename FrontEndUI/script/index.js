// JavaScript Document

$(document).ready(function() {
    $(".part").hover(function(){
		$(this).find("p").stop().slideDown();
	},function(){
		$(this).find("p").stop().slideUp();
	});
});