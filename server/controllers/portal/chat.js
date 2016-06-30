/*!
 * hnzswh-rvt-api
 * Copyright(c) 2015 hnzswh-rvt-api <3203317@qq.com>
 * MIT Licensed
 */
'use strict';

var util = require('speedt-utils');
var EventProxy = require('eventproxy');

var conf = require('../../settings');

var EventProxy = require('eventproxy');

/**
 *
 * @params
 * @return
 */
exports.indexUI = function(req, res, next){
	res.render('portal/chat/index', {
		conf: conf,
		description: '',
		keywords: ',html5,nodejs'
	});
};

exports.sendMsg = function(req, res, next){

};

/**
 * 长连接
 *
 * @params
 * @return
 */
exports.receiveMsg = function(req, res, next){

};