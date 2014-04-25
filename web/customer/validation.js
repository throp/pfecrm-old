	function validateBilling()
	{
		if(isEmpty(frmBilling.name, 'Customer Name', 'true')
		|| isEmpty(frmBilling.address1, 'Address', 'true')
		|| isEmpty(frmBilling.city, 'City', 'true')
		|| isEmpty(frmBilling.state, 'State', 'true')
		|| isEmpty(frmBilling.zip, 'Zip', 'true')
		|| !ValNumber(frmBilling.zip, 'Zip', true, 'false')
		|| !ValPhone(frmBilling.primaryContactPhoneNumber, 'Primary Contact Phone Number', true)
		|| !ValEmail(frmBilling.primaryContactEmailAddress, 'Primary Contact Email Address', true)
		|| !ValPhone(frmBilling.secondaryContactPhoneNumber, 'Secondary Contact Phone Number', true)
		|| !ValEmail(frmBilling.secondaryContactEmailAddress, 'Secondary Contact Email Address', true)		
		|| !ValPhone(frmBilling.faxNumber, 'Contact Fax Number', true)
		|| isEmpty(frmBilling.status, 'Status', true)
		|| isEmpty(frmBilling.officeId, 'Office', true)) {
			return false;
		}

		
		return true;
	}
	
	function validateEditBilling()
	{
		if(isEmpty(frmBilling.name, 'Customer Name', 'true')
		|| isEmpty(frmBilling.address1, 'Address', 'true')
		|| isEmpty(frmBilling.city, 'City', 'true')
		|| isEmpty(frmBilling.state, 'State', 'true')
		|| isEmpty(frmBilling.zip, 'Zip', 'true')
		|| !ValNumber(frmBilling.zip, 'Zip', true, 'false')
		|| !ValPhone(frmBilling.primaryContactPhoneNumber, 'Primary Contact Phone Number', true)
		|| !ValEmail(frmBilling.primaryContactEmailAddress, 'Primary Contact Email Address', true)
		|| !ValPhone(frmBilling.secondaryContactPhoneNumber, 'Secondary Contact Phone Number', true)
		|| !ValEmail(frmBilling.secondaryContactEmailAddress, 'Secondary Contact Email Address', true)		
		|| !ValPhone(frmBilling.faxNumber, 'Contact Fax Number', true)) {
			return false;
		}

		return true;
	}	

	function validateLocation()
	{
		if(isEmpty(frmLocation.name, 'Location Name', 'true')
		|| isEmpty(frmLocation.address1, 'Address', 'true')
		|| isEmpty(frmLocation.city, 'City', 'true')
		|| isEmpty(frmLocation.state, 'State', 'true')
		|| isEmpty(frmLocation.zip, 'Zip', 'true')
		|| !ValNumber(frmLocation.zip, 'Zip', true, 'false')
		|| !ValPhone(frmLocation.contactPhoneNumber, 'Phone Number', true)) {
			return false;
		}

	
		return true;
		
		
	}