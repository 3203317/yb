/*!
 * calliao
 * Copyright(c) 2015 hnzswh-rvt-api <3203317@qq.com>
 * MIT Licensed
 */
'use strict';

!(function(window, document){
	// (document.getElementsByTagName('body')[0]).innerHTML('<div id="abcde"></div>')
	// (document.getElementsByTagName('body')[0]).innerHTML = "<p>你好</p>";
	var body = document.body;
	var div = document.createElement("div");
	div.setAttribute('id', 'calliao');
	div.innerHTML = '<img title="开启摄像头（火狐、WebKit）" alt="摄像头" src="http://www.foreworld.net/public/assets/images/camera/48x48.png">';
	body.appendChild(div);

	var link = document.createElement( "link" ); 
	link.type = "text/css"; 
	link.rel = "stylesheet"; 
	link.href = 'http://127.0.0.1:3012/public/assets/css/calliao.css';
	document.getElementsByTagName( "head" )[0].appendChild( link ); 

	// console.log(document.domain)
	// 获取域名
	console.log(window.location.host)

	// 请求登陆聊天室

	// 聊天机器人
})(window, document);