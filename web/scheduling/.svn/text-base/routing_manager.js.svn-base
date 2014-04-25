
	var currentDialogBox;

	function setImageToCompleted(imgId) { 
		var imgJob = document.getElementById(imgId);
		imgJob.src = "/CRM/images/green_check.jpg";
	}

	function assignRoadTech() { 
		var employeeId = document.getElementById("assignRoadTechEmployeeId");
		if(isEmpty(employeeId, 'Employee', 'true')) { 
			return false;
		}
				
		sendRequest("/CRM/UpdateJobAssignRoadTechAction.do?jobId=" + currentDialogBox.dataId + "&employeeId=" + employeeId.value);

		setImageToCompleted("img" + currentDialogBox.dataId);		
		currentDialogBox.hide();
		currentDialogBox = null;
	}

	function showAssignRoadTech(jobId) { 		
		if(currentDialogBox != null) { 
			currentDialogBox.hide();
		}
		
		var imgJob = document.getElementById("img" + jobId);
		if(imgJob.src.indexOf("green_check") <= 0) {
			var imgJobTop = getImageTop(imgJob);
			var imgJobLeft = getImageLeft(imgJob);
			
			currentDialogBox = new DialogBox();
			currentDialogBox.id = "dlgAssignRoadTech";
			currentDialogBox.top = imgJobTop - 85;
			currentDialogBox.left = imgJobLeft + 15;
			currentDialogBox.dataId = jobId;
			currentDialogBox.show();
		}
	}
	
	function assignReturnTech() { 
		var employeeId = document.getElementById("assignReturnTechEmployeeId");
		if(isEmpty(employeeId, 'Employee', 'true')) { 
			return false;
		}

		sendRequest("/CRM/UpdateJobAssignReturnTechAction.do?jobId=" + currentDialogBox.dataId + "&employeeId=" + employeeId.value);
		setImageToCompleted("img" + currentDialogBox.dataId);		
		currentDialogBox.hide();		
		currentDialogBox = null;
	}
	
	
	function showAssignReturnTech(jobId, serviceId) { 		
		if(currentDialogBox != null) { 
			currentDialogBox.hide();
		}
				
		var imgJob = document.getElementById("img" + jobId);
		if(imgJob.src.indexOf("green_check") <= 0) {
			var imgJobTop = getImageTop(imgJob);
			var imgJobLeft = getImageLeft(imgJob);
			
			currentDialogBox = new DialogBox();
			currentDialogBox.id = "dlgAssignReturnTech";
			currentDialogBox.top = imgJobTop - 85;
			currentDialogBox.left = imgJobLeft + 15;
			currentDialogBox.dataId = jobId;
			currentDialogBox.show();
		}
	}	
	
	
	function validateFilters()
	{
		if(frmFilters.monthId2 != null) { 
			if(!isEmpty(frmFilters.monthId2, 'Month 2', false)) { 
				if(isEmpty(frmFilters.yearId2, 'Year 2', false)) {
					alert('You must specify both a month and year to filter for.');
					return false;
				}
			}
			if(!isEmpty(frmFilters.yearId2, 'Year 2', false)) { 
				if(isEmpty(frmFilters.monthId2, 'Month 2', false)) { 
					alert('You must specify both a month and year to filter for.');
					return false;
				}
			}
		}
		return true;
	}
		