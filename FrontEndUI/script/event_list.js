// JavaScript Document

$(document).ready(function(e) {
    var eventData=testData;
    function loadData(callAddScroller){
		$.each(eventData,function(n,v){
			/*
			<li>
				<a href="events.html">
					<div class="list_img">
						<img src="images/news/events/list/img1.jpg"/>
					</div>
					<span>2016-12-02</span>
					<span>
						依托IP大数据，在文化高原探索高峰
					</span>
				</a>
			</li>
			*/
			var li = $(document.createElement("li"));
			var a = $(document.createElement("a"));
			a.attr("href",v.detailLink);
			var list_img = $(document.createElement("div"));
			list_img.addClass("list_img");
			var img = $(document.createElement("img"));
			img.attr("src",v.imgUrl);
			var date = $(document.createElement("span"));
			date.text(v.eventDate);
			var title = $(document.createElement("span"));
			title.text(v.title);
			list_img.append(img);
			a.append(list_img);
			a.append(date);
			a.append(title);
			li.append(a);
			$("#event_list_ul").append(li);
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
		"id" : 1,
		"title" : "依托IP大数据，在文化高原探索高峰",
		"imgUrl" : "./images/news/events/list/img1.jpg",
		"type" : "event",
		"eventDate" : "2016-12-02",
		"detailLink" : './events.html'
	},
	{
		"id" : 2,
		"title" : "中国新闻出版传媒集团有限公司总经理李忠发表讲话",
		"imgUrl" : "./images/news/events/list/img2.jpg",
		"type" : "event",
		"eventDate" : "2016-12-15",
		"detailLink" : './events.html'
	},
	{
		"id" : 3,
		"title" : "著名编剧兰晓龙会议现场发言",
		"imgUrl" : "./images/news/events/list/img3.jpg",
		"type" : "event",
		"eventDate" : "2016-12-17",
		"detailLink" : './events.html'
	},
	{
		"id" : 4,
		"title" : "国家新闻出版广电总局数字出版司程晓龙发言",
		"imgUrl" : "./images/news/events/list/img4.jpg",
		"type" : "event",
		"eventDate" : "2016-12-17",
		"detailLink" : './events.html'
	},
	{
		"id" : 5,
		"title" : "数舟（上海）数据信息服务有限公司董事长翁天雄在会议现场",
		"imgUrl" : "./images/news/events/list/img5.jpg",
		"type" : "event",
		"eventDate" : "2016-12-17",
		"detailLink" : './events.html'
	},
	{
		"id" : 6,
		"title" : "依托IP大数据，在文化高原探索高峰",
		"imgUrl" : "./images/news/events/list/img1.jpg",
		"type" : "event",
		"eventDate" : "2016-12-02",
		"detailLink" : './events.html'
	}
];