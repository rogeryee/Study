<html>
<head>
<title>Ajax Sample 1</title>
<script type="text/javascript" src="/yeep/js/prototype.js"></script>
<script language="javascript">

    var http_request = false;

    // initialize, specify the functions of sending response and processing
  function send_request(url)
  {
  	http_request = false;
        
    // initializing XMLHttpRequest
		if(window.XMLHttpRequest) //Mozilla Browser
    {
			http_request = new XMLHttpRequest();
			if (http_request.overrideMimeType)
      {
      	// setting MiME type
				http_request.overrideMimeType('text/xml');
			}
		}
		else if (window.ActiveXObject)  // IE Browser
    {
			try
      {
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			}
      catch (e)
      {
				try
        {
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
        catch (e) 
        {}
			}
		}

    // error in creating XMLHttpRequest
    if (!http_request)
    {
			window.alert("Can not create the instance of XMLHttpRequest!");
			return false;
		}

    http_request.onreadystatechange = processRequest;

    // specify the url and the type of sending response
		http_request.open("GET", url, true);
		http_request.send(null);
	}
            
  // process returned request 
  function processRequest()
  {
    // judge the state
    if (http_request.readyState == 4)
    {
    	// if the request is returned successfully,then process it
      if (http_request.status == 200)
      {
      	var errorSpan = $('error_span');
        errorSpan.innerHTML = http_request.responseText;
      }
      else 
      {
      	var errorSpan = $('error_span');
        errorSpan.innerHTML = "There is an error on the page you have asked for?";
      }
    }
  }
            
  function user_check()
  {
  	var username = $('username');
		if(username.value=="")
    {
    	var errorSpan = $('error_span');
      errorSpan.innerHTML = "Username is required in the page and please fill the blank!";
			username.focus();
			return false;
		}
		else
    {
    	// send request
      send_request('ajaxSample1_2.jsp?username='+username.value);
		}
	}
    
</script>
</head>

<body>

<div id="error_span"></div>
<form name="form1" action="" method="post">
UserName:&nbsp;<input type="text" id="username" name="username" value="">&nbsp;
<input type="button" name="check" value="Check for Unique" onClick="user_check()">
<input type="submit" name="submit" value="Save">
</form>

<span style="cursor: pointer; text-decoration: underline" onclick="send_request('ajaxSample1_2.jsp?username='+$('username').value)">Send a request</span>

</body>
</html>
