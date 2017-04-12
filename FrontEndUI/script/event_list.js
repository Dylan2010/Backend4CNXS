// JavaScript Document

$(document).ready(function(e) {
    var eventData=testData;
    function getData(doSetData){
		$.ajax({
			async: false,
			url : '/api/Articles/v1/Type/Events/list',
			type:"get",
			dataType : 'json',
			success : function(data){
				doSetData(data,addScroller);
			},
			error: function(e){
				var a=JSON.stringify(e);
			}
		});
		
	}
	
	function setData(data,setScroller){
		eventData = data;
		$.each(eventData,function(n,v){
			v.detailLink = './events.html'+'?id='+v.id;//+'&date='+v.creationTime;
			//console.log(v.imageInfo);
			v.imageInfo=JSON.parse(v.imageInfo);
			
			var li = $(document.createElement("li"));
			var a = $(document.createElement("a"));
			a.attr("href",v.detailLink);
			var list_img = $(document.createElement("div"));
			list_img.addClass("list_img");
			var img = $(document.createElement("img"));
			img.attr("src",v.imageInfo["1"]);
			var date = $(document.createElement("span"));
			date.text(v.eventDate);
			var title = $(document.createElement("span"));
			title.text(v.title);
			var arrow = $(document.createElement("span"));
			arrow.addClass("arr");
			arrow.text(">>");
			list_img.append(img);
			a.append(list_img);
			a.append(date);
			a.append(title);
			a.append(arrow);
			li.append(a);
			$("#event_list_ul").append(li);
		});
		setScroller();
	}
	
	function addScroller(){
		$(".scroller").tinyscrollbar();
	}
	getData(setData);
});

var testData=[
	{
		"id" : 1,
		"title" : "依托IP大数据，在文化高原探索高峰",
		"imageInfo" : "{\"1\":\"./images/news/events/list/img1.jpg\"}",
		"type" : "event",
		"eventDate" : "2016-12-02",
		"detailLink" : './events.html'
	},
	{
		"id" : 2,
		"title" : "中国新闻出版传媒集团有限公司总经理李忠发表讲话",
		"imageInfo" : "{\"1\":\"./images/news/events/list/img2.jpg\"}",
		"type" : "event",
		"eventDate" : "2016-12-15",
		"detailLink" : './events.html'
	},
	{
		"id" : 3,
		"title" : "著名编剧兰晓龙会议现场发言",
		"imageInfo" : "{\"1\":\"./images/news/events/list/img3.jpg\"}",
		"type" : "event",
		"eventDate" : "2016-12-17",
		"detailLink" : './events.html'
	},
	{
		"id" : 4,
		"title" : "国家新闻出版广电总局数字出版司程晓龙发言",
		"imageInfo" : "{\"1\":\"./images/news/events/list/img4.jpg\"}",
		"type" : "event",
		"eventDate" : "2016-12-17",
		"detailLink" : './events.html'
	},
	{
		"id" : 5,
		"title" : "数舟（上海）数据信息服务有限公司董事长翁天雄在会议现场",
		"imageInfo" : "{\"1\":\"./images/news/events/list/img5.jpg\"}",
		"type" : "event",
		"eventDate" : "2016-12-17",
		"detailLink" : './events.html'
	},
	{
		"id" : 6,
		"title" : "依托IP大数据，在文化高原探索高峰",
		"imageInfo" : "{\"1\":\"./images/news/events/list/img1.jpg\"}",
		"type" : "event",
		"eventDate" : "2016-12-02",
		"detailLink" : './events.html'
	}
];