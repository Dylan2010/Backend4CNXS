// JavaScript Document

var currentExpert=0;
$(document).ready(function(e) {

	function getData(doSetData){
		$.ajax({
			async: false,
			url : '/api/Articles/v1/Type/Experts/list',
			type:"get",
			dataType : 'json',
			success : function(data){
				doSetData(data,initAnimation);
			},
			error: function(e){
				var a=JSON.stringify(e);
				////alert(a);
			}
		});
	}
	
	function setData(data,doInitAnimation){
		experts = data;
		$.each(experts,function(n,v){
			v.imageInfo = JSON.parse(v.imageInfo);
			var li=$(document.createElement("li"));
			var img=$(document.createElement("img"));
			img.attr("src",v.imageInfo["1"]);
			li.append(img);
			$("#experts_ul").append(li);
		});
		doInitAnimation();
	}
	
	function initAnimation(){
		$("#experts_ul").children("li").eq(0).addClass("center");
		$("#experts_ul").children("li").eq(1).addClass("right");
		$("#experts_ul").children("li").last().addClass("left");
		
		$("#expert_name").text(experts[currentExpert].title);
		$("#expert_summary").text(experts[currentExpert].summary);
		$("#expert_content").text(experts[currentExpert].content);
	}
	
    $(".experts_view .prev_btn").click(function(){
		var prevIndex=currentExpert-1<0?$(".experts_view li").length-1:currentExpert-1;
		currentExpert=prevIndex;
		$("#expert_name").text(experts[currentExpert].title);
		$("#expert_summary").text(experts[currentExpert].summary);
		$("#expert_content").text(experts[currentExpert].content);
		show_expert(currentExpert);
	});
	$(".experts_view .next_btn").click(function(){
		var nextIndex=currentExpert+1>=$(".experts_view li").length?0:currentExpert+1;
		currentExpert=nextIndex;
		$("#expert_name").text(experts[currentExpert].title);
		$("#expert_summary").text(experts[currentExpert].summary);
		$("#expert_content").text(experts[currentExpert].content);
		show_expert(currentExpert);
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
	
	getData(setData);
});

var staticData=[
	{
		"id" : 1,
		"title" : "谭建龙",
		"summary" : "中国科学院信息工程研究所，研究员",
		"content" : "《面向业务、多元互动、智能评估、公信交易--------网络IP价值评估大数据平台建设》",
		"imageInfo" : "{\"1\":\"images/news/experts/tjl.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 2,
		"title" : "章毅",
		"summary" : "四川大学计算机学院院长、四川大学机器智能实验室创始人、教授，博导",
		"content" : "《IP大数据价值评估的神经网络方法》",
		"imageInfo" : "{\"1\":\"images/news/experts/zy.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 3,
		"title" : "陈文斌",
		"summary" : "复旦大学数学科学学院教授",
		"content" : "《IP估值数量模型探讨》",
		"imageInfo" : "{\"1\":\"images/news/experts/cwb.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 4,
		"title" : "陈村",
		"summary" : "上海作家协会副主席，上海网络作家协会会长",
		"content" : "《在一个个错误中前行》",
		"imageInfo" : "{\"1\":\"images/news/experts/cc.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 5,
		"title" : "邵燕君",
		"summary" : "北京大学中文系副教授，中国作协网络委员会委员、中国网络文学研究专家",
		"content" : "《全球媒介革命视野下的中国网络文学——中国网络文学的域外传播》",
		"imageInfo" : "{\"1\":\"images/news/experts/syj.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 6,
		"title" : "谈瀛洲",
		"summary" : "博士生导师，复旦大学中澳创意写作中心主任，上海作家协会会员，传记文学研究会理事",
		"content" : "《传统文学，网络文学与IP》",
		"imageInfo" : "{\"1\":\"images/news/experts/tyz.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 7,
		"title" : "兰晓龙",
		"summary" : "著名编剧",
		"content" : "《IP时代下剧本编剧的创新》",
		"imageInfo" : "{\"1\":\"images/news/experts/lxl.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 8,
		"title" : "高歌",
		"summary" : "编剧、制作人、制片人、柒羽文化CEO",
		"content" : "《影视剧制作与IP估值的良性关系》",
		"imageInfo" : "{\"1\":\"images/news/experts/gg.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 9,
		"title" : "史可扬",
		"summary" : "于北京师范大学艺术与传媒学院教授，博士生导师",
		"content" : "《IP电影热下的冷思考》",
		"imageInfo" : "{\"1\":\"images/news/experts/sky.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 10,
		"title" : "王永恩",
		"summary" : "中国传媒大学研究院博士，北京师范大学、上海戏剧学院博士后",
		"content" : "《经典作品价值与网络IP估值的思索》",
		"imageInfo" : "{\"1\":\"images/news/experts/wye.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	},
	{
		"id" : 11,
		"title" : "汤祈岑",
		"summary" : "网络文学大IP改编影视剧的新锐代表",
		"content" : "《我经历的那些大IP》",
		"imageInfo" : "{\"1\":\"images/news/experts/tqc.jpg\"}",
		"type" : "expert",
		"eventDate" : "",
		"createDate" : ""
	}	
];
var experts=staticData;