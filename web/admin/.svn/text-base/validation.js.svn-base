function validateEmployee()
{
	if(isEmpty(frmEmployee.firstName, 'First Name', 'true')
		|| isEmpty(frmEmployee.lastName, 'Last Name', 'true')
		|| isEmpty(frmEmployee.employeeType, 'Employee Type', 'true')) {
		return false;
	}

	if(isEmpty(frmEmployee.userName, 'Username', false) &&
		 !isEmpty(frmEmployee.password, 'Password', false)) { 
		 	alert('Please enter both a username and password.');
		 	return false;
	}

	if(!isEmpty(frmEmployee.userName, 'Username', false) &&
		 isEmpty(frmEmployee.password, 'Password', false)) { 
		 	alert('Please enter both a username and password.');
		 	return false;
	}
	return true;

}

function validateManufacturer()
{
	if(isEmpty(frmManufacturer.name, 'Name', 'true') ||
		 isEmpty(frmManufacturer.abbreviation, 'Abbreviation', 'true')) {
		return false;
	}
	return true;

}

function validateChemical()
{
	if(isEmpty(frmChemical.name, 'Name', 'true')) {
		return false;
	}
	if(isEmpty(frmChemical.abbreviation, 'Abbreviation', 'true')) {
		return false;
	}	
	return true;

}
