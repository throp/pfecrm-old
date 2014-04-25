	var req = null;
	var console = null;
	var READY_STATE_UNINITIALIZED = 0;
	var READY_STATE_LOADING = 1;
	var READY_STATE_LOADED = 2;
	var READY_STATE_INTERACTIVE = 3;
	var READY_STATE_COMPLETE = 4;
	function sendRequest(URL, params, HttpMethod) 
	{
		if(!HttpMethod) { 
			HttpMethod = "GET";
		}
		req = initXMLHTTPRequest();
		if(req) { 
			req.onreadystatechange=onReadyState;
			req.open(HttpMethod, URL, true);
			req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			req.send(params);
		}
	}
	function initXMLHTTPRequest() 
	{ 
		var xRequest = null;
		if(window.XMLHttpRequest) { 
			xRequest = new XMLHttpRequest();
		}
		else if(window.ActiveXObject) { 
			xRequest = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xRequest;
	}
	
	function onReadyState() 
	{ 
		var ready = req.readyState;
		var data = null;
		if(ready == READY_STATE_COMPLETE) { 
			data = req.responseText;
		}
		else { 
			data = "loading...[" + ready + "]";
		}
	}