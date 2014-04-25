
function DialogBox() 
{
	var dataId;
	var id;
	var top;
	var left;
	var div;
	
	
	this.show = function() { 
		dialogBoxDiv = document.getElementById(this.id);
		dialogBoxDiv.style.visibility = 'visible';
		dialogBoxDiv.style.top = this.top;
		dialogBoxDiv.style.left = this.left;
	}
	
	this.showMiddle = function() { 
		dialogBoxDiv = document.getElementById(this.id);
		dialogBoxDiv.style.position = 'absolute';
		dialogBoxDiv.style.top = document.body.scrollTop + 200;
		dialogBoxDiv.style.left = '35%';
		dialogBoxDiv.style.zIndex = '1';
		dialogBoxDiv.style.visibility = 'visible';
	}
		
	this.hide = function() { 
		dialogBoxDiv.style.visibility = 'hidden';	
	}
}

function hideDialog(dlg) {
		var techPopUp = document.getElementById(dlg);	
		techPopUp.style.visibility = 'hidden';
		techPopUp.style.zIndex = '100';
		techPopUp.style.top = '90%';
		techPopUp.style.left = '90%';	

}

//Common dialog box functions
var currentDialogBox;

function hideFilter() { 
	var db = document.getElementById("dlgFilter");
	db.style.visibility = 'hidden';
	db.style.zIndex = '100';
	//db.style.top = '90%';
	//db.style.left = '10%';	
}

function showFilter() { 
 		
	if(currentDialogBox != null) { 
		currentDialogBox.hide();
	}

	var db = document.getElementById("dlgFilter");
	db.style.position = 'absolute';
	db.style.top = document.body.scrollTop + 200;
	db.style.left = '25%';
	db.style.zIndex = '1';
	db.style.visibility = 'visible';
}

function hideDialogBox(dlg) { 
	var db = document.getElementById(dlg);
	db.style.visibility = 'hidden';
	db.style.zIndex = '100';
	//db.style.top = '90%';
	//db.style.left = '10%';	
}

function showDialogBox(dlg) { 
	if(currentDialogBox != null) { 
		currentDialogBox.hide();
	}

	var db = document.getElementById(dlg);
	db.style.position = 'absolute';
	db.style.top = document.body.scrollTop + 200;
	db.style.left = '35%';
	db.style.zIndex = '1';
	db.style.visibility = 'visible';
}

