/*!
 * hnzswh-rvt-api
 * Copyright(c) 2015 hnzswh-rvt-api <3203317@qq.com>
 * MIT Licensed
 */
'use strict';

var util = require('speedt-utils'),
	express = util.express;

var portal = {
	chat: require('../controllers/portal/chat')
};

function proc_portal(app){
	var chat = portal.chat;
	app.post('/chat/sendMsg', chat.sendMsg);
	app.get('/chat/receiveMsg', chat.receiveMsg);
	app.get('/chat/', chat.indexUI);
}

/**
 *
 * @param
 * @return
 */
module.exports = function(app){
	proc_portal(app);
};