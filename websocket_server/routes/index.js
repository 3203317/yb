/*!
 * hnzswh-rvt-api
 * Copyright(c) 2015 hnzswh-rvt-api <3203317@qq.com>
 * MIT Licensed
 */
'use strict';

var util = require('speedt-utils'),
	express = util.express;

var portal = {
	index: require('../controllers/portal/index')
};

function proc_portal(app){
	var index = portal.index;
	app.get('/', index.indexUI);
}

/**
 *
 * @param
 * @return
 */
module.exports = function(app){
	proc_portal(app);
};