	function findImage(name, doc) {
		var i, img;
		for (i = 0; i < doc.images.length; i++) {
	    	if (doc.images[i].name == name) {
				return doc.images[i];
			}
		}
		for (i = 0; i < doc.layers.length; i++) {
	    	if ((img = findImage(name, doc.layers[i].document)) != null) {
				img.container = doc.layers[i];
				return img;
	    	}
		}
		return null;
	}
	
	function getImage(name) {
		if (document.layers) {
	    	return findImage(name, document);
		}
		return null;
	}	



function getElementTop(elem) {
		yPos = elem.offsetTop;
		tempEl = elem.offsetParent;
		while (tempEl != null) {
  			yPos += tempEl.offsetTop;
	  		tempEl = tempEl.offsetParent;
  		}
		return yPos;
}

function getElementLeft(elem) {
		xPos = elem.offsetLeft;
		tempEl = elem.offsetParent;
  		while (tempEl != null) {
  			xPos += tempEl.offsetLeft;
	  		tempEl = tempEl.offsetParent;
  		}
		return xPos;
}


	
	function getImageTop(myImage) {
		var y, obj;
		if (document.layers) {
			var img = getImage(myImage);
			if (img.container != null)
				return img.container.pageY + img.y;
			else
				return img.y;
		} else {
			return getElementTop(myImage);
		}
		return -1;
	}
	
	
	function getImageLeft(myImage) {
		var x, obj;
		if (document.layers) {
			var img = getImage(myImage);
	    	if (img.container != null)
				return img.container.pageX + img.x;
			else
				return img.x;
	  	} else {
			return getElementLeft(myImage);
		}
		return -1;
	}	
	
	var jobId;
	function showDialogBox(j, dialogBox) { 
		jobId = j;
		var techPopUp = document.getElementById(dialogBox);
		var imgJob = document.getElementById("img" + jobId);
		if(imgJob.src.indexOf("green_check") <= 0) {
			var imgJobTop = getImageTop(imgJob);
			var imgJobLeft = getImageLeft(imgJob);
			techPopUp.style.visibility = 'visible';
			techPopUp.style.top = imgJobTop - 85;
			techPopUp.style.left = imgJobLeft + 15;
		}
	}	