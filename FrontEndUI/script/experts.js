// JavaScript Document

var currentExpert=0;
$(document).ready(function(e) {
	//console.log($(".center").index());
    $(".experts_view .prev_btn").click(function(){
		var prevIndex=currentExpert-1<0?$(".experts_view li").length-1:currentExpert-1;
		show_expert(prevIndex);
	});
	$(".experts_view .next_btn").click(function(){
		var nextIndex=currentExpert+1>=$(".experts_view li").length?0:currentExpert+1;
		show_expert(nextIndex);
	});
	
	function show_expert(index){
		currentExpert=index;
		$(".left").removeClass("left");
		$(".right").removeClass("right");
		$(".center").removeClass("center");
		$(".experts_view li").eq(index).addClass("center");
		$(".experts_view li").eq(index-1<0?$(".experts_view li").length-1:index-1).addClass("left");
		$(".experts_view li").eq(index+1>=$(".experts_view li").length?0:index+1).addClass("right");
	}
});