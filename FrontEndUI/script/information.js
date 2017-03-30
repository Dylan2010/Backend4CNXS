// JavaScript Document

$(document).ready(function(e) {
    var infoData;
	function getData(doSetData){
		jQuery.support.cors = true;
		$.ajax({
			url : 'http://101.37.39.51:8080/api/Articles/v1/Type/Info/list',
			type:"get",
			dataType : 'json',
			success : function(data){
				//console.log(data);
				doSetData(data);
			},
			error: function(e){
				var a=JSON.stringify(e);
				//alert(a);
			}
		});
		//infoData=testData;
		//console.log(infoData);
		
	}
	function setData(data){
		infoData=data;
		//alert(infoData);
		//console.log(infoData);
		$.each(infoData,function(n,v){
			/*<li class="odd">
					<div class="main_img">
						<img src="images/news/information/img1.jpg"/>
					</div>
					<div class="article">
						<h2></h2>
						<p></p>
					</div>
				</li>*/
				//alert(v);
				//alert(v.imageInfo[1]);
			//v.imageInfo = eval(v.imageInfo);
			//v.imageInfo.replace(/[\\]/g,'');
			//v.imageInfo=eval(v.imageInfo);
			//alert(v.imageInfo);
			//var Json =v.imageInfo;
			v.imageInfo=JSON.parse(v.imageInfo);
			var li=$(document.createElement("li"));
			if(n%2==0){
				li.addClass("odd");
			}else{
				li.addClass("even");
			}
			
			var mainImgDiv = $(document.createElement("div"));
			mainImgDiv.addClass("main_img");
			var img = $(document.createElement("img"));
			img.attr("src",v.imageInfo["1"]);
			mainImgDiv.append(img);
			
			var article = $(document.createElement("div"));
			article.addClass("article");
			var h2 = $(document.createElement("h2"));
			h2.text(v.title);
			var p = $(document.createElement("p"));
			p.text(v.content);
			article.append(h2);
			article.append(p);
			li.append(mainImgDiv);
			li.append(article);
			
			$("#info_ul").append(li);
		});
	}//setdata
	
	getData(setData);
});

var testData=[
	{
		"title" : "大数据，网络文学的寻龙诀",
		"summary" : "数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何炼成大IP》主题访谈会",
		"content" : "（北京讯）1月13日，北京，郎朗读书声不仅敲响了2017的新年钟声，还拉开了数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何炼成大IP》主题访谈会的序幕",
		"imageInfo" : {"1":"./images/news/information/img1.jpg"},
		"type" : "information",
	},
	{
		"title" : "依托IP大数据，在文化高原探索高峰",
		"summary" : "“2016首届中国网络IP大数据发展研讨会”在京拉开帷幕",
		"content" : "12月2日，由中国新闻出版传媒集团有限公司、中国全民阅读媒体联盟主办，浙江升华拜克生物股份有限公司联合主办、数舟（上海）数据信息服务有限公司承办的“2016首届中国网络IP大数据发展研讨会”在京拉开帷幕。",
		"imageInfo" : {"1":"./images/news/information/img2.jpg"},
		"type" : "information",
	}
]