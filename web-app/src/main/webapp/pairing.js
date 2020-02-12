
// Calls a GET request to the API
var callGet = (path, thenFn) => {
	fetch(
		'http://localhost:' + window.tpt.port.toFixed() + '/api/' + path)
		.then((response) => {
			if (!response.ok) {
				console.error('GET call failed with status ' + response.status);
			}
			else {
				response.json().then(thenFn);
			}
		});
};

var toStep = (index) => {
	console.info('To step ' + index);
	document.querySelectorAll('section:not([hidden])')
		.forEach(s => s.setAttribute('hidden', ''));
	document.getElementById('step' + index).removeAttribute('hidden');
};

// Application start
window.onload = () => {

	toStep(1);

	var port = 80;
	var query = window.location.hash;
	if (query) {
		var begin = query.indexOf('#');
		if (begin >= 0) {
			port = parseInt(query.substring(begin + 1));
		}
	}
	console.info('Port is ' + port);
	window.tpt = { port: port };

	callGet('tournament', json => {
			toStep(2);
		});
};

