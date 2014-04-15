<html>
<head>
<title>Ajax Sample 6</title>
<script language="javascript">

  <%--
  <employees>

    <employee name="J.Doe">
	    <job>Programmer</job>
	    <salary>32768</salary>
    </employee>

    <employee name="A.Baker">
	    <job>Sales</job>
	    <salary>70000</salary>
    </employee>

    <employee name="Big Cheese">
	    <job>CEO</job>
	    <salary>100000</salary>
    </employee>

  </employees>
  --%>
            
  function loadXML(handler)
  {
    var url = "employees.xml";
    
    // If user use Mozilla
    if(document.implementation && document.implementation.createDocument)
    {
      var xmldoc = document.implementation.createDocument("", "", null);
	    xmldoc.onload =  handler(xmldoc, url);
	    xmldoc.load(url);
    }
    // If user use IE
    else if(window.ActiveXObject)
    {
      var xmldoc = new ActiveXObject("Microsoft.XMLDOM");
	    xmldoc.onreadystatechange = function()
      {
		    if(xmldoc.readyState == 4)
        	handler(xmldoc, url);
	    }
	    xmldoc.load(url);
    }
  }

  function makeTable(xmldoc, url)
  {
    var table = document.getElementById("table1");
    table.setAttribute("border","1");
    table.setAttribute("width","600");
    table.setAttribute("class","tab-content");
    document.body.appendChild(table);

    var caption = "Employee Data from " + url;
    table.createCaption().appendChild(document.createTextNode(caption));
      
    var header = table.createTHead();
    var headerrow = header.insertRow(0);
    headerrow.insertCell(0).appendChild(document.createTextNode("Name"));
    headerrow.insertCell(1).appendChild(document.createTextNode("Job"));
    headerrow.insertCell(2).appendChild(document.createTextNode("Salary"));

    var employees = xmldoc.getElementsByTagName("employee");
    for(var i=0;i<employees.length;i++)
    {
	    var e = employees[i];
	    var name = e.getAttribute("name");
	    var job = e.getElementsByTagName("job")[0].firstChild.data;
	    var salary = e.getElementsByTagName("salary")[0].firstChild.data;
	    var row = table.insertRow(i+1);
	    row.insertCell(0).appendChild(document.createTextNode(name));
	    row.insertCell(1).appendChild(document.createTextNode(job));
	    row.insertCell(2).appendChild(document.createTextNode(salary));
    }
  }
  
  
  var http_request = false;

  // initialize, specify the functions of sending response and processing
  function send_request(url)
  {
		http_request = false;

    // initializing XMLHttpRequest
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
        catch (e) {}
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
				var returnObj = http_request.responseXML;
				var xmlobj = http_request.responseXML;
				var employees = xmlobj.getElementsByTagName("employee");
				var feedbackStr = "";

	      // get the content of employees.xml
	      for(var i=0;i<employees.length;i++)
	      {
					var employee = employees[i];
					feedbackStr += "Employee:" + employee.getAttribute("name");
					feedbackStr += " Job:" + employee.getElementsByTagName("job")[0].firstChild.data;
					feedbackStr += " Salary:" + employee.getElementsByTagName("salary")[0].firstChild.data;
					feedbackStr +=  "\r\n";
				}
				alert(feedbackStr);
      }
      else 
      {
      	alert("There is an error on the page you have asked for.");
      }
    }
  }
    
</script>
</head>
<body>

<table id="table1"></table>
<input type="button" name="read" value="Load from XML to Table" onClick="loadXML(makeTable)">
<br>
<br>

<input type="button" name="read" value="Load from XML" onClick="send_request('employees.xml')">
</body>
</html>
