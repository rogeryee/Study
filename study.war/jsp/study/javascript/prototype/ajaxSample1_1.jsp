<html>
<head>
<title>Prototype Ajax Sample1</title>
<Script type="text/javascript" src="/yeep/js/prototype.js"></script>

<script language="javascript">

	var url = "http://localhost:18080/yeep/jsp/study/javascript/prototype/";
  function writeTextArea()
  {
  	var username = $('username').value;
    var fullURL = url + 'ajaxSample1_2.jsp';
    var pars = 'username=' + username;
    var myAjax = new Ajax.Request(
    	fullURL,
      {method: 'post', parameters: pars, onComplete: showResponse}
    );
	}

  function showResponse(originalRequest)
  {
  	//put returned XML in the textarea
    $('result').value = originalRequest.responseText;
  }

	function getHTML()
	{
  	var username = $('username1').value;
    var fullURL = url + 'ajaxSample1_3.jsp';
    var pars = 'username=' + username;
    var myAjax = new Ajax.Updater(
      url,
      {method: 'post', parameters: pars,onSuccess:showResponse1, onFailure: reportError});
	}
	
	function showResponse1(originalRequest)
  {
    $('placeholder').value = originalRequest.responseText;
  }

  function reportError(request)
  {
  	alert('Sorry. There was an error.');
  }
       
</script>

</head>
<body>

<!--
Using Ajax.Request
-->
name:&nbsp;<input type="text" name="username" value="">&nbsp;
<input type="submit" name="submit" value="Save" onClick="writeTextArea()">
<br><textarea id=result cols=60 rows=10 ></textarea>

<br><br>

<!--
Using Ajax.Updater
-->
name:&nbsp;<input type="text" name="username1" value="">&nbsp;
<input type="submit" name="submit" value="GetText" onClick="getHTML()">
<div id="placeholder"></div>

</body>
</html>