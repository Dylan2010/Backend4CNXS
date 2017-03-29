// JavaScript Document

$(document).ready(function(e) {
	var servData=testData;
    function loadData(callAddScroller){
		$.each(servData,function(n,v){
			var li=$(document.createElement("li"));
			if(n%2==0){
				li.addClass("odd");
			}else{
				li.addClass("even");
			}
			var article=$(document.createElement("div"));
			article.addClass("article");
			article.addClass("scroller");
			article.append("<div class='scrollbar'><div class='track'><div class='thumb'><div class='end'></div></div></div></div>");
			var viewport = $(document.createElement("div"));
			viewport.addClass("viewport");
			var overview = $(document.createElement("div"));
			overview.addClass("overview");
			//article.append(viewport);
			//viewport.append(overview);
			var h2=$(document.createElement("h2"));
			h2.text(v.title);
			var p=$(document.createElement("p"));
			p.text(v.content);
			var img=$(document.createElement("img"));
			img.attr("src",v.imgUrl);
			overview.append(h2);
			overview.append(p);
			viewport.append(overview);
			article.append(viewport);
			li.append(article);
			li.append(img);
			$("#service_list").append(li);
		});
		
		callAddScroller();
	}
	
	function addScroller(){
		$(".scroller").tinyscrollbar();
	}
	loadData(addScroller);
});


var testData=[
	{
		"title" : "数据服务",
		"content" : "以一种客观角度看待网络主流舆论，不迎合任何舆论，从海量讯息中运用大数据分析打捞并聚焦有价值事件，推广有价值的声音和思想，为用户推送热点舆情信息、季度性行业舆情报告等，帮助用户做出快速反应应对市场中的种种问题。",
		"imgUrl" : "./images/service/img1.png"
	},
	{
		"title" : "IP分析报告",
		"content" : "大数据采集覆盖全网数据，智能分析聚焦关键信息，专业团队量身定制深度分析报告。根据该IP在市场中的全领域分析，用户画像及IP特点，提供定制化的增值方案,以及分领域的横向比较来得出一个对未来的估值分析。<br/>1.网络IP行业分析报告2. 网络IP发展蓝皮书<br/>3.IP价值评估报告4.受众群体分析报告<br/>5.诊断报告6. 增值方案报告<br/>7.运营分析报告8. IP估值预期分析报告",
		"imgUrl" : "./images/service/img2.jpg"
	},
	{
		"title" : "行业排行榜",
		"content" : "以IP为核心，进行跨领域、跨平台衍生等数据，提供泛娱乐领域（ACGN、网剧、网综、电影等）作品的即时排行榜。<br/>1.热门作品榜单<br/>2.最具潜力榜单<br/>3.分领域作品榜单<br/>4.分析社会热点情况等<br/>最专业的角度提供最权威榜单，全面解析IP行业、统计相关数据，从而了解媒体传播信息的内容、传播的方向、评估媒体传播实力、传播效果。",
		"imgUrl" : "./images/service/img3.jpg"
	}
];