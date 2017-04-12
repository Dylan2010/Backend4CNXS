// JavaScript Document

$(document).ready(function(e) {
	var eventData=testData;
	function getData(getUrl,doSetData,doSetShare,setScroller){
		var nid = GetQueryString("id");
		getUrl = '/api/Articles/v1/Type/Events/id/'+nid;
		$.ajax({
			async: false,
			url : getUrl,
			type:"get",
			dataType : 'json',
			success : function(data){
				doSetData(data,addScroller,doSetShare);
			},
			error: function(e){
				var a=JSON.stringify(e);
			}
		});
	}
	function setData(data,doSetShare,setScroller){
		eventData = data;
		eventData.imageInfo=JSON.parse(eventData.imageInfo);
		$("#main_img").attr("src",eventData.imageInfo["1"]);
		$("#event_title").text(eventData.title);
		$("#event_content").text(eventData.content);
		$("#content_img1").attr("src",eventData.imageInfo["2"]);
		$("#content_img2").attr("src",eventData.imageInfo["3"]);
		$("#content_img3").attr("src",eventData.imageInfo["4"]);
		
		var next_id;
		$.ajax({
			url : "/api/Articles/v1/Type/Events/latest?next=false&date="+eventData.creationTime,
			type:"get",
			dataType : 'json',
			success : function(data){
				next_id=data.id;
				$("#next_btn").attr("href","./events.html?id="+next_id);
			},
			error: function(e){
				var a=JSON.stringify(e);
			}
		});
		
		
		doSetShare();
		setScroller();
		
	}
	
	function setShare(){
		bShare.addEntry({
			title: eventData.title,
			//url: "http://www.cmdsdis.cn",
			summary: eventData.summary,
			pic: eventData.imgUrl
		});
	}
	
	function addScroller(){
		$(".scroller").tinyscrollbar();
	}
	
	getData("",setData,setShare,addScroller);
	
	function GetQueryString(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null)return  unescape(r[2]); return null;
	}
    
});


var testData={
	"title" : "大数据，网络文学的寻龙诀",
	"summary" : "数舟数据建立专家智库，陈村邵燕君等行业专家应邀成为首批智库专家",　
	"content" : "（北京讯）1月13日，北京，朗朗读书声不仅敲响了2017的新年钟声，还拉开了数舟（上海）数据信息服务有限公司承办的《大数据来了，网络文学如何成为大IP》主题访谈会的序幕。此次访谈会是“全民阅读‘红沙发’系列访谈”的重要组成部分，也是数舟（上海）数据信息服务有限公司首度加盟该系列的重要标志。全民阅读“红沙发”系列访谈由中国新闻出版传媒集团有限公司主办，该系列访谈创办于2012年，以主持人对话嘉宾的形式向公众全方位展现阅读的魅力与风采。",
	"imgInfo" : "{\"1\":\"./images/news/events/main.jpg\",\"2\":\"./images/news/events/sub_img1.jpg\",\"3\":\"./images/news/events/sub_img2.jpg\",\"4\":\"./images/news/events/sub_img3.jpg\"}",
	"type" : "event"
}