// JavaScript Document

$(document).ready(function(e) {
    $(".news_nav li").click(function(){
		$(this).siblings().removeClass("on");
		$(this).addClass("on");
		//console.log($(this).index());
		switch($(this).index()){
			case 0:switchModual('events',1);$("#events_more").show();break;
			case 1:switchModual('experts',1);$("#events_more").hide();break;
			case 2:switchModual('informations',1);$("#events_more").hide();break;
			default:break;
		}
		//switchModual()
	});
	
	var newsData=testdata;
	//console.log(testdata[currentModual]);
	function switchModual(modualName,toIndex){//模块名称，索引
		currentindex=toIndex;
		currentModual=modualName;
		var currentObj=newsData[modualName][toIndex-1];
		var dataLength=newsData[modualName].length;
		console.log(dataLength);
		var nextNum=(currentObj.num>=dataLength?0:currentObj.num);
		var prevNum=(currentObj.num==1?dataLength-1:currentObj.num-2);
		$("#main_img").attr("src",currentObj.imgUrl);
		$("#article_title").text(currentObj.title);
		$("#article_text").text(currentObj.summary);
		$("#prev_title").text(newsData[modualName][prevNum].title);
		$("#next_title").text(newsData[modualName][nextNum].title);
		$("#more_link").attr("href",currentObj.detailLink);
	}
	switchModual('events',1);
	
	$("#prev_link").click(function(){
		prev();
	});
	$("#next_link").click(function(){
		next();
	});
	function prev(){
		switchModual(currentModual,currentindex==1?newsData[currentModual].length:currentindex-1);
	}
	function next(){
		switchModual(currentModual,currentindex==newsData[currentModual].length?1:currentindex+1);
	}
});

var currentindex = 1;
var currentModual = 'events';
var testdata={
		events : [
			{
				"num" : 1,//当前json object在数组中的序号，计算上一个下一个用
				"title" : "数舟数据与中国新闻出版传媒集",
				"summary" : "数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家",
				"content" : "",
				"imgUrl" : "./images/news/sample1.png",
				"type" : "event",
				"eventDate" : "",
				"detailLink" : './events.html'
			},
			{
				"num" : 2,
				"title" : "依托大数据，在文化高原探索高峰",
				"summary" : "数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家",
				"content" : "",
				"imgUrl" : "./images/news/sample1.png",
				"type" : "event",
				"eventDate" : "",
				"detailLink" : './events.html'
			},
			{
				"num" : 3,
				"title" : "大数据，网络文学的寻龙诀",
				"summary" : "数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家",
				"content" : "",
				"imgUrl" : "./images/news/sample1.png",
				"type" : "event",
				"eventDate" : "",
				"detailLink" : './events.html'
			}
		],
		experts : [
			{
				"num" : 1,
				"title" : "谭建龙",
				"summary" : "中国科学院信息工程研究所，研究员",
				"content" : "",
				"imgUrl" : "./images/news/experts/tjl.jpg",
				"type" : "expert",
				"eventDate" : "",
				"detailLink" : './experts.html'
			},
			{
				"num" : 2,
				"title" : "章毅",
				"summary" : "四川大学计算机学院院长、四川大学机器智能实验室创始人、教授，博导",
				"content" : "",
				"imgUrl" : "./images/news/experts/zy.jpg",
				"type" : "expert",
				"eventDate" : "",
				"detailLink" : './experts.html'
			},
			{
				"num" : 3,
				"title" : "陈文斌",
				"summary" : "复旦大学数学科学学院教授",
				"content" : "",
				"imgUrl" : "./images/news/experts/cwb.jpg",
				"type" : "expert",
				"eventDate" : "",
				"detailLink" : './experts.html'
			}
		],
		informations : [
			{
				"num" : 1,
				"title" : "大数据，网络文学的寻龙诀",
				"summary" : "数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何炼成大IP》主题访谈会",
				"content" : "",
				"imgUrl" : "./images/news/sample3.jpg",
				"type" : "information",
				"eventDate" : "",
				"detailLink" : './information.html'
			},
			{
				"num" : 2,
				"title" : "依托IP大数据，在文化高原探索高峰",
				"summary" : "“2016首届中国网络IP大数据发展研讨会”在京拉开帷幕",
				"content" : "",
				"imgUrl" : "./images/news/sample3.jpg",
				"type" : "information",
				"eventDate" : "",
				"detailLink" : './information.html'
			},
			{
				"num" : 3,
				"title" : "行业资讯3",
				"summary" : "数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家",
				"content" : "",
				"imgUrl" : "./images/news/sample3.jpg",
				"type" : "information",
				"eventDate" : "",
				"detailLink" : './information.html'
			}
		]
	}