
//-- Compatibility mode "ON" starting here

var toStep = function(index) {
	console.info('To step ' + index);
	document.querySelectorAll('section.current')
		.forEach(function(s) { s.classList.remove('current'); });
	var section = document.getElementById('step' + index);
	section.classList.add('current');
	return section;
};

var unsupportedBrowser = false;
window.addEventListener("load", function() {
		if (!window.fetch) {
			toStep(0); // Warning about non compatible browser
			unsupportedBrowser = true;
		}
	}, true);

//-- Compatibility mode "OFF" from here

var defaultPort = 8000;

var handleError = () => {
	var section = toStep(3);
	var port = (window.tpt || { port: -1 }).port;
	section.querySelector('#port').innerHTML = port.toFixed();
	if (port != defaultPort) {
		// Automatically redirect to the default port
		setTimeout(() => {
			window.location.hash = defaultPort.toFixed();
			window.location.reload(false);
		}, 3000)
	}
};

// Calls a GET request to the API
var callGet = (path, thenFn) => {
	fetch(
		'http://localhost:' + window.tpt.port.toFixed() + '/api/' + path)
		.then((response) => {
			if (!response.ok) {
				console.error('GET call failed with status ' + response.status);
				handleError();
			}
			else {
				response.json().then(thenFn);
			}
		})
		.catch((error) => {
			handleError();
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
			var section = toStep(2);
			// We display the values returned by the API
			section.querySelector('#cfg').innerHTML = json.config_value.toFixed()
			section.querySelector('#app').innerHTML = json.app_value.toFixed()
		});

}, true);

