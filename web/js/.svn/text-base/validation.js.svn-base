
function ValEmail (emailStr, title, inPopMessage) {
  if(!emailStr.value) {return true;}
/* The following pattern is used to check if the entered e-mail address
   fits the user@domain format.  It also is used to separate the username
   from the domain. */
var emailPat=/^(.+)@(.+)$/
/* The following string represents the pattern for matching all special
   characters.  We don't want to allow special characters in the address. 
   These characters include ( ) < > @ , ; : \ " . [ ]    */
var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]"
/* The following string represents the range of characters allowed in a 
   username or domainname.  It really states which chars aren't allowed. */
var validChars="\[^\\s" + specialChars + "\]"
/* The following pattern represents the range of characters allowed as
   the first character in a valid username or domain.  I just made it
   the same as above, but if you want to add a different constraint,
   you would change it here. */
var firstChars=validChars
/* The following pattern applies if the "user" is a quoted string (in
   which case, there are no rules about which characters are allowed
   and which aren't; anything goes).  E.g. "jiminy cricket"@disney.com
   is a legal e-mail address. */
var quotedUser="(\"[^\"]*\")"
/* The following pattern applies for domains that are IP addresses,
   rather than symbolic names.  E.g. joe@[123.124.233.4] is a legal
   e-mail address. NOTE: The square brackets are required. */
var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/
/* The following string represents at atom (basically a series of
   non-special characters.) */
var atom="(" + firstChars + validChars + "*" + ")"
/* The following string represents one word in the typical username.
   For example, in john.doe@somewhere.com, john and doe are words.
   Basically, a word is either an atom or quoted string. */
var word="(" + atom + "|" + quotedUser + ")"
// The following pattern describes the structure of the user
var userPat=new RegExp("^" + word + "(\\." + word + ")*$")
/* The following pattern describes the structure of a normal symbolic
   domain, as opposed to ipDomainPat, shown above. */
var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$")


/* Finally, let's start trying to figure out if the supplied address is
   valid. */

/* Begin with the course pattern to simply break up user@domain into
   different pieces that are easy to analyze. */
var matchArray = emailStr.value.match(emailPat)
if (matchArray==null) {
  /* Too many/few @'s or something; basically, this address doesn't
     even fit the general mould of a valid e-mail address. */
	if(inPopMessage == true)  {
		alert(title + "is invalid: check @ and .'s")
		emailStr.focus();
		emailStr.select();
	}
	return false
}
var user=matchArray[1]
var domain=matchArray[2]

// See if "user" is valid 
if (user.match(userPat)==null) {
    // user is not valid
    if(inPopMessage == true)  {
    	alert(title + "is invalid: The username doesn't seem to be valid.")
	emailStr.focus();
	emailStr.select();
    }
    return false
}
/* if the e-mail address is at an IP address (as opposed to a symbolic
   host name) make sure the IP address is valid. */
var IPArray=domain.match(ipDomainPat)
if (IPArray!=null) {
    // this is an IP address
	  for (var i=1;i<=4;i++) {
	    if (IPArray[i]>255) {
		if(inPopMessage == true)  {
		        alert(title + " is invalid: Destination IP address is invalid!")
			emailStr.focus();
			emailStr.select();
		}
		return false
	    }
    }
    return true
}

// Domain is symbolic name
var domainArray=domain.match(domainPat)
if (domainArray==null) {
	if(inPopMessage == true)  {	
		alert(title + " is invalid: The domain name doesn't seem to be valid.")
		emailStr.focus();
		emailStr.select();
	}
    return false
}


/* Now we need to break up the domain to get a count of how many atoms
   it consists of. */
var atomPat=new RegExp(atom,"g")
var domArr=domain.match(atomPat)
var len=domArr.length
if (domArr[domArr.length-1].length<2 || 
    domArr[domArr.length-1].length>3) {
   // the address must end in a two letter or three letter word.
   if(inPopMessage == true)  {
   	alert(title + " is invalid: The address must end in a three-letter domain, or two letter country.")
	emailStr.focus();
	emailStr.select();
   }
   return false
}



/* If it just ends in .com, .gov, etc., make sure there's a host name.
   This case can never actually happen because earlier checks take
   care of this implicitly, but we'll do it anyway. */
if (domArr[domArr.length-1].length==3 && len<2) {
   if(inPopMessage == true)  {   
   	alert(title + " is invalid: The address is missing a hostname!")
	emailStr.focus();
	emailStr.select();

   }
   return false
}
// If we've gotten this far, everything's valid!
return true;
}

function ValNumber(field, title, inPopMessage, nonIntegerOK) {
	var valid = "0123456789"
	if(nonIntegerOK) {
		valid += ".-";
	}
	
	var ok = "yes";
	var temp;

	for (var i=0; i<field.value.length; i++) {
		temp = "" + field.value.substring(i, i+1);
		if (valid.indexOf(temp) == "-1") ok = "no";
	}
	if (ok == "no") {
		if(inPopMessage == true)  {
			alert(title + " is invalid: Only numbers are accepted!");
			field.focus();
			field.select();
		}
	return false
   	}
	else return true
}
/**
 * Checks for the following valid date formats:
 * YYYY-MM-DD
 * Also separates date into month, day, and year variables
 */
function ValDate(dateStr, title, inPopMessage) 
{
	//don't worry about if it's empty
  if(dateStr.value == "") { return true; }
  
  //An acceptable date pattern
	var datePat = /^(\d{4})(-)(\d{2})\2(\d{2})$/;

	var matchArray = dateStr.value.match(datePat); // is the format ok?
	if (matchArray == null) {
		if(inPopMessage == true)  {
			alert(title + " is invalid: Date is not in a valid format (YYYY-MM-DD).")
			dateStr.focus();
			dateStr.select();
		}
			return false;
	}
	
	year = matchArray[1]; // parse date into variables
	month = matchArray[3];
	day = matchArray[4];
	if (month < 1 || month > 12) { // check month range
		if(inPopMessage == true)  {
			alert(title + " is invalid: Month must be between 1 and 12.");
			dateStr.focus();
			dateStr.select();
		}
		return false;
	}
	if (day < 1 || day > 31) {
		if(inPopMessage == true)  {
			alert(title + " is invalid: Day must be between 1 and 31.");
			dateStr.focus();
			dateStr.select();
		}
		return false;
	}
	if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		if(inPopMessage == true)  {
			alert(title + " is invalid: "+month+" doesn't have 31 days!")
			dateStr.focus();
			dateStr.select();
		}
		return false
	}
	if (month == 2) { // check for february 29th
		var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		if (day>29 || (day==29 && !isleap)) {
			if(inPopMessage == true)  {
				alert(title + " is invalid: February " + year + " doesn't have " + day + " days!");
				dateStr.focus();
				dateStr.select();
			}
			return false;
	   }
}

return true;  // date is valid
}

function ValPhone(phoneStr, title, inPopMessage) {
// Checks for the following valid phone formats:
// 999-999-9999
// Also separates phone into month, day, and year variables
if(!phoneStr.value) {return true;}
var phonePat = /^(\d{3})(-)(\d{3})\2(\d{4})$/;

var matchArray = phoneStr.value.match(phonePat); // is the format ok?
if (matchArray == null) {
	if(inPopMessage == true)  {
		alert(title + " is invalid: phone is not in a valid format (555-555-5555).")
		phoneStr.focus();
		phoneStr.select();
	}

		
return false;
}
else return true;  // phone is valid
}

function isEmpty(field, title, inPopMessage)
{
	var empty = false;
	
	if(field.type == "select-one")
	{
		if(field.value == "" || field.value == "-1") { empty = true; }
	}
  else if(field.type == "text"  || field.type == "textarea")
  {
  	if(field.value == "" ) { empty = true; }
  }

  
  if(empty)
  {
    if(inPopMessage)
    {
      alert('Please enter a value for the ' + title + '.');
      field.focus();
    }
    return true;
  }
  
  return false;
}

function isMiscEmpty(lst, title, inPopMessage)
{
	if(lst.options.length == 0)
	{
		if(inPopMessage)
		{
			alert('Please select a value for the ' + title + '.');
			lst.focus();
		}
		return true;
	}
	return false;
}	

function isValidField(field, val_type, title, inPopMessage)
{
  switch(val_type)
  {
    case 'email':
      isValid = ValEmail(field, title, inPopMessage);
      break;
    case 'number':
      isValid = ValNumber(field, title, inPopMessage);
      break;
    case 'phone':
      isValid = ValPhone(field, title, inPopMessage);
      break;
    case 'date':
      isValid = ValDate(field, title, inPopMessage);
      break;
    case 'text':
      //do nothing at this point.
      break; 
    default:
      alert('Default');
  }
  return isValid;
}


function ValForm(inArr, inPopMessage)
{
  var count;
  var isValid = 1;
  var field;
  var val_type;
  for(count=0; isValid && count<inArr.length; count++)
  {
    if(inArr[count])
    {
      field = inArr[count][0];
      val_type = inArr[count][1];
      verify = inArr[count][2];

      if(verify && isEmpty(field, inPopMessage)) { return false; }

      switch(val_type)
      {
        case 'email':
          isValid = ValEmail(field, inPopMessage);
          break;
        case 'number':
          isValid = ValNumber(field, inPopMessage);
          break;
        case 'phone':
          isValid = ValPhone(field, inPopMessage);
          break;
        case 'date':
          isValid = ValDate(field, inPopMessage);
          break;
        case 'text':
          //do nothing at this point.
          break; 
        default:
          alert('Default');
      }
    } 
  }
  return isValid;
}

function datesAreEqual(fromDate, fromMonth, fromYear,  toDate, toMonth, toYear)
{
  if( toYear.options.value == fromYear.options.value &&
      toMonth.options.value == fromMonth.options.value &&
      toDate.options.value == fromDate.options.value)
   { return true; }
  else
   { return false; }
}

function dateIsLessThan(fromDate, fromMonth, fromYear, fromName, toDate, toMonth, toYear, toName, print_message)
{
  var msg = "Invalid Date: the " + fromName + " must be less than the " + toName; 
  if(fromYear.options.value < toYear.options.value)
   { return true; }
  else if(fromYear.options.value > toYear.options.value)
  { 
    if(print_message == 1) { alert(msg); }
    return false; 
  }
  else
  {
    if(fromMonth.options.value < toMonth.options.value)
     { return true; } 
    else if(fromMonth.options.value > toMonth.options.value)
    { 
      if(print_message == 1) { alert(msg); }
      return false; 
    }
    else
    {
      if(fromDate.options.value < toDate.options.value)
       { return true; }
      else
      { 
        if(print_message == 1) { alert(msg); }
        return false; 
      }
    }
  }
  
}

/**
 * Get the value of the radio button that is selected
 */
function getSelectedRadioValue(radioGroup)
{
	//validate
	if(radioGroup == null) { alert('radioGroup passed in to getSelectedRadioValue() is null'); }
	
	var selectedRadioValue = "";
	var i;
	for(i=0; i<radioGroup.length; i++)
	{
		if(radioGroup[i].checked) { selectedRadioValue = radioGroup[i].value; break; }
	}
	return selectedRadioValue;
}

