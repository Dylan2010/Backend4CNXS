// JavaScript Document\\

$(document).ready(function(e) {
	var keyword = decodeURI(GetQueryString("keyword"));
	var eventData;
    function GetQueryString(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r!=null)return  unescape(r[2]); return null;
	}
	
	function getData(doSetData){
		jQuery.support.cors = true;//跨域
		$.ajax({
			async: false,
			url : 'http://101.37.39.51:8080/api/Articles/v1/search',
			type:"get",
			data : {"keyword":keyword},
			dataType : 'json',
			success : function(data){
				//console.log(data);
				doSetData(data,addScroller);
			},
			error: function(e){
				var a=JSON.stringify(e);
				////alert(a);
			}
		});
	}
	
	function setData(data,setScroller){
		eventData = data;
		$.each(eventData,function(n,v){
			switch(v.type){
				case "Events" : v.detailLink = './events.html?id='+v.id;break;
				case "Experts" : v.detailLink = './experts.html';break;
				case "Info" : v.detailLink = './infos.html';break;
				default : break;
			}
			//console.log(v.imageInfo);
			v.imageInfo=JSON.parse(v.imageInfo);
			
			var li = $(document.createElement("li"));
			var a = $(document.createElement("a"));
			a.attr("href",v.detailLink);
			var list_img = $(document.createElement("div"));
			list_img.addClass("list_img");
			var img = $(document.createElement("img"));
			img.attr("src",v.imageInfo["1"]);
			var title = $(document.createElement("span"));
			title.text(v.title);
			var arrow = $(document.createElement("span"));
			arrow.addClass("arr");
			arrow.text(">>");
			list_img.append(img);
			a.append(list_img);
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