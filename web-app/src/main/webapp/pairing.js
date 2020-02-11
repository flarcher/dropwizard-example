
window.onload = () => {
	console.warn('Hello!');

	var port = 80;
	var query = window.location.hash;
	if (query) {
		var begin = query.indexOf('#');
		if (begin >= 0) {
			port = parseInt(query.substring(begin + 1));
		}
	}

	console.info('Port is ' + port);
};

