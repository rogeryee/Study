<html>
<head>
<title>Ajax Sample 2</title>
<script type="text/javascript" src="/yeep/js/prototype.js"></script>
<script language="javascript">

  var http_request = false;
	var currentPos = null;

  // initialize, specify the functions of sending response and processing
  function send_request(url)
  {
		http_request = false;

    //initializing XMLHttpRequest
		if(window.XMLHttpRequest) //Mozilla Browser
    {
			http_request = new XMLHttpRequest();

      // setting MiME type
      if (http_request.overrideMimeType)
      {
				http_request.overrideMimeType('text/xml');
			}
		}
		else if (window.ActiveXObject) // IE Browser
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
				$(currentPos).innerHTML = http_request.responseText;
      }
      else
      {
      	alert("There is an error on the page you have asked for.");
      }
   	}
 	}

  // show roles of department
	function showRoles(obj)
  {
  	var position = $(obj);
    position.parentNode.style.display = "";
		position.innerHTML = "Loading data ......"
		currentPos = obj;
		send_request("ajaxSample2_2.jsp?playPos="+obj);
	}
    
</script>
</head>

<body>
<table width="200" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="20"><a href="javascript:void(0)" onClick="showRoles('pos_1')">Manager Room</a></td>
    </tr>
    <tr style="display:none">
        <td height="20" id="pos_1">&nbsp;</td>
    </tr>
    <tr>
        <td height="20"><a href="javascript:void(0)" onClick="showRoles('pos_2')">Developer Room</a></td>
    </tr>
    <tr style="display:none ">
        <td id="pos_2" height="20">&nbsp;</td>
    </tr>
</table>

</body>
</html>
