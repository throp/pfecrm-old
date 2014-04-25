
	function toggleBlanketPo()
	{
		isBlanketPO = isBlanketPO ? false : true;
		if(isBlanketPO) { 
			frmLocation.po.value = blanketPO;
			frmLocation.po.disabled = true;
		}	
		else { 
			frmLocation.po.disabled = false;
			frmLocation.po.value = "";
		}
	}
	
	function toggleContact()
	{
		isUseCustomerContact = isUseCustomerContact ? false : true;
		if(isUseCustomerContact) {
			frmLocation.contactFirstName.disabled = true;
			frmLocation.contactLastName.disabled = true;
			frmLocation.contactPhoneNumber.disabled = true;
			frmLocation.contactPhoneExtension.disabled = true;
			frmLocation.contactTitle.disabled = true;
			frmLocation.contactEmailAddress.disabled = true;
			frmLocation.contactFirstName.value = customerContactFirstName;
			frmLocation.contactLastName.value = customerContactLastName;
			frmLocation.contactPhoneNumber.value = customerContactPhoneNumber;
			frmLocation.contactPhoneExtension.value = customerContactPhoneExtension;
			frmLocation.contactTitle.value = customerContactTitle;
			frmLocation.contactEmailAddress.value = customerContactEmailAddress;			
		}
		else { 
			frmLocation.contactFirstName.disabled = false;
			frmLocation.contactLastName.disabled = false;
			frmLocation.contactPhoneNumber.disabled = false;
			frmLocation.contactPhoneExtension.disabled = false;
			frmLocation.contactTitle.disabled = false;
			frmLocation.contactEmailAddress.disabled = false;		
			frmLocation.contactFirstName.value = locationContactFirstName;
			frmLocation.contactLastName.value = locationContactLastName;
			frmLocation.contactPhoneNumber.value = locationContactPhoneNumber;
			frmLocation.contactPhoneExtension.value = locationContactPhoneExtension;
			frmLocation.contactTitle.value = locationContactTitle;
			frmLocation.contactEmailAddress.value = locationContactEmailAddress;						
		}
		
	}
	
	function toggleAddress()
	{
		isUseCustomerAddress = isUseCustomerAddress ? false : true;
		if(isUseCustomerAddress) { 
			frmLocation.address1.disabled = true;
			frmLocation.address2.disabled = true;
			frmLocation.address3.disabled = true;
			frmLocation.city.disabled = true;
			frmLocation.state.disabled = true;
			frmLocation.zip.disabled = true;
			frmLocation.address1.value = customerAddress1;
			frmLocation.address2.value = customerAddress2;
			frmLocation.address3.value = customerAddress3;
			frmLocation.city.value = customerCity;
			frmLocation.state.value = customerState;
			frmLocation.zip.value = customerZip;				
		}
		else { 
			frmLocation.address1.disabled = false;
			frmLocation.address2.disabled = false;
			frmLocation.address3.disabled = false;
			frmLocation.city.disabled = false;
			frmLocation.state.disabled = false;
			frmLocation.zip.disabled = false;
			frmLocation.address1.value = locationAddress1;
			frmLocation.address2.value = locationAddress2;
			frmLocation.address3.value = locationAddress3;
			frmLocation.city.value = locationCity;
			frmLocation.state.value = locationState;
			frmLocation.zip.value = locationZip;		
		}
		
		
	}