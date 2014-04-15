<html>
<head>
<title>DOM Sample 2</title>
<script language="javascript">

	// reverse the order of nodes
  function reverseNode(node)
  {
		var kids = node.childNodes; // get the list of children nodes
		var kidsNum = kids.length; // count the children nodes

    // traverse the children nodes in reversed order
    for(var i=kidsNum-1;i>=0;i--)
    {
			var c = node.removeChild(kids[i]); // remove the specified node and save it in variable c
			node.appendChild(c); // put c in the new place
		}
	}

	// reverse the table content
	function reverseTable(obj)
  {
  	var node = obj; // the "table" element
    var child = obj.getElementsByTagName("tr"); // get all rows of the table
	  var newChild = new Array(); // define the array to save all rows.

    for(var i=0;i<child.length;i++)
    {
    	newChild[i] = child[i].firstChild.innerHTML;
	  }

    node.removeChild(node.childNodes[0]); // remove all rows
	  var header = node.createTHead(); // create a new head of table

    for(var i=0;i<newChild.length;i++)
    {
			var headerrow = header.insertRow(i); // insert a row
		  var cell = headerrow.insertCell(0); // insert a cell into row

      // create TextNode in cell
		  cell.appendChild(document.createTextNode(newChild[newChild.length-i-1]));
	  }
  }
    
  // replace the content between obj1 and obj2 (obj1 and obj2 are two tables)
  function replaceContent(obj1,obj2)
  {
		var table1 = obj1; //var table1 = document.getElementsByTagName("table")[0];
	  var table2 = obj2 //var table2 = document.getElementsByTagName("table")[1];

    var kid1 = table1.firstChild.firstChild.firstChild; // locate at <td> node in table1
	  var kid2 = table2.firstChild.firstChild.firstChild; // locate at <td> node in table2
    var repKid = kid2.firstChild; // locate the TextNode of the <td> node in table2

    try
		{
			// replace the content of table1 by the table2's
      // and table2 has no content
      kid1.replaceChild(repKid,kid1.firstChild);

      // If follow code was open, there will be an "object error" because the table2 has already been changed.
		  //kid2.replaceChild(kid1.firstChild,kid2.firstChild);
		}
    catch(e)
    {
		alert(e);
	  }
  }
    
  // insert string to table content
  function insertStr()
  {
    var f = document.form1;
    var value = f.str.value;

    if(value!="")
    {
	    // beginning with the lastest TextNode, and become a <tbody> structure
	    var text = document.createTextNode(value); // create a TextNode
	    var td = document.createElement("td"); // create a <td> element
	    var tr = document.createElement("tr"); // create a <tr> element
	    var tbody = document.createElement("tbody"); // create a <tbody> element

      td.appendChild(text); // put TextNode into <td>
    	tr.appendChild(td); // put <td> into <tr>
    	tbody.appendChild(tr); // put <tr> into <tbody>

      var parNode = document.getElementById("table1"); // locate the table object
    	parNode.insertBefore(tbody,parNode.firstChild); // put <tbody> into table as the first element
    	//parNode.appendChild(tbody); // put <tbody> into table as the lastest element
  	}
  }

</script>
</head>
<body>

<div id="row">
<p>1st Row</p>
<p>2nd Row</p>
<p>3rd Row</p>
<p>4th Row</p>
</div>
<p>
<input type="button" name="reverseRow" value="reverse row" onClick="reverseNode(document.getElementById('row'))">
</p>

<table width="200" border="1" cellpadding="4" cellspacing="0" id="tab">
    <tr>
        <td height="25">1st Row</td>
    </tr>
    <tr>
        <td height="25">2nd Row</td>
    </tr>
    <tr>
        <td height="25">3rd Row</td>
    </tr>
    <tr>
        <td height="25">4th Row</td>
    </tr>
</table>
<br>
<input type="button" name="reverseTable" value="reverse table" onClick="reverseTable(document.getElementById('tab'))">

<br><br>
<table width="200" border="1" cellspacing="0" cellpadding="0" id="tab1">
<tbody>
    <tr>
        <td>Table 1</td>
    </tr>
</tbody>
</table>
<br>
<table width="200" border="1" cellspacing="0" cellpadding="0" id="tab2">
<tbody>
    <tr>
        <td>Table 2</td>
    </tr>
</tbody>
</table>
<br>
<input type="button" name="replaceNode" value="replace table" onClick="replaceContent(document.getElementById('tab1'),document.getElementById('tab2'))">
<br>

<form name="form1" method="post" action="">
    <input name="str" type="text" id="str" value="">
    <input name="insert" type="button" id="insert" value="Save Message" onClick="insertStr()">
</form>

<table width="400" border="1" cellspacing="0" cellpadding="0" id="table1">
<tbody>
    <tr>
        <td height="25">Message Board:</td>
    </tr>
</tbody>
</table>
</body>
</html>
