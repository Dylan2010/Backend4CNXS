// JavaScript Document

$(document).ready(function() {
    $(".nav_parent_li").hover(function(){
		$(this).find(".nav_child").stop().slideDown();
	},function(){
		$(this).find(".nav_child").stop().slideUp();
	});
	
	/*$("#login a").hover(function(){
		$(this).stop().animate({width:"71px"},200);
	},function(){
		$(this).stop().animate({width:"15px"},200);
	});*/
	$("#login").hover(function(){
		$(this).find(".loginbtns").stop().animate({width:"71px"},200);
	},function(){
		$(this).find(".loginbtns").stop().animate({width:"0px"},200);
	});
	
	$(".news_nav li").click(function(){
		$(this).siblings().removeClass("on");
		$(this).addClass("on");
		console.log($(this).index());
		switch($(this).index()){
			case 0:switchModual('events',1);break;
			case 1:switchModual('experts',1);break;
			case 2:switchModual('informations',1);break;
			default:break;
		}
		//switchModual()
	});
	
	var newsData=testdata;
	//console.log(testdata[currentModual]);
	function switchModual(modualName,toIndex){
		currentindex=toIndex;
		currentModual=modualName;
		var currentObj=newsData[modualName][toIndex-1];
		$("#main_img").attr("src",currentObj.img);
		$("#article_title").text(currentObj.title);
		$("#article_text").text(currentObj.abstracts);
		$("#prev_title").text(currentObj.prevTitle);
		$("#next_title").text(currentObj.nextTitle);
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
				index : 1,
				img : 'images/news/sample.jpg',
				title :　'数舟数据与中国新闻出版传媒集',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '大数据，网络文学的寻龙诀',
				nextTitle : '依托大数据，在文化高原探索高峰',
				detailLink : './events.html'
			},
			{
				index : 2,
				img : 'images/news/sample.jpg',
				title :　'依托大数据，在文化高原探索高峰',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '数舟数据与中国新闻出版传媒集',
				nextTitle : '大数据，网络文学的寻龙诀',
				detailLink : './events.html'
			},
			{
				index : 3,
				img : 'images/news/sample.jpg',
				title :　'大数据，网络文学的寻龙诀',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '依托大数据，在文化高原探索高峰',
				nextTitle : '数舟数据与中国新闻出版传媒集',
				detailLink : './events.html'
			}
		],
		experts : [
			{
				index : 1,
				img : 'images/news/sample.jpg',
				title :　'专家专栏1',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '专家专栏3',
				nextTitle : '专家专栏2',
				detailLink : ''
			},
			{
				index : 2,
				img : 'images/news/sample.jpg',
				title :　'专家专栏2',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '专家专栏1',
				nextTitle : '专家专栏3',
				detailLink : ''
			},
			{
				index : 3,
				img : 'images/news/sample.jpg',
				title :　'专家专栏3',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '专家专栏2',
				nextTitle : '专家专栏1',
				detailLink : ''
			}
		],
		informations : [
			{
				index : 1,
				img : 'images/news/sample.jpg',
				title :　'行业资讯1',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '行业资讯3',
				nextTitle : '行业资讯2',
				detailLink : './information.html'
			},
			{
				index : 2,
				img : 'images/news/sample.jpg',
				title :　'行业资讯2',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '行业资讯1',
				nextTitle : '行业资讯3',
				detailLink : './information.html'
			},
			{
				index : 3,
				img : 'images/news/sample.jpg',
				title :　'行业资讯3',
				abstracts : '数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家',
				prevTitle : '行业资讯2',
				nextTitle : '行业资讯1',
				detailLink : './information.html'
			}
		]
	}