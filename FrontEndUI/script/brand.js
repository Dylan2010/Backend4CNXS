// JavaScript Document

$(document).ready(function(e) {
    $(".brand_nav").hover(function(){
		$(this).find(".on").show();
		$(this).find("h2").show();
		$(this).addClass("on");
	},function(){
		$(this).find(".on").hide();
		$(this).find("h2").hide();
		$(this).removeClass("on");
	});
});