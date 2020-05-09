
//-- Compatibility mode "ON" starting here

var toStep = function(index) {
	console.info('To step ' + index);
	document.querySelectorAll('section.current')
		.forEach(function(s) { s.classList.remove('current'); });
	document.getElementById('step' + index).classList.add('current');
};

var unsupportedBrowser = false;
window.addEventListener("load", function() {
		if (!window.fetch) {
			toStep(0); // Warning about non compatible browser
			unsupportedBrowser = true;
		}
	}, true);

//-- Compatibility mode "OFF" from here

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

// Application start
window.addEventListener("load", () => {
	if (unsupportedBrowser) {
		return;
	}

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

	callGet('example', json => {
			toStep(2);
		});

}, true);

