(function(jq) {
	var resize = function() {
		if (!parent || !parent.resizeInnerPage)
			return;
		parent.resizeInnerPage(jq(document.body));
	}
	jq(window).load(resize);
	jq(window).resize(resize);
	var _old = jq.fn.html;
	jq.fn.html = function() {
		_old.apply(this, arguments);
		resize();
	};
})($);
function go(url) {
	parent.location.href = parent.location.pathname + url;
}