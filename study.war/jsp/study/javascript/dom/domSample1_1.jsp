<html>
<head>
<title>DOM Sample 1</title>
<script language="javascript">

	var elementName = ""; // global variable used for storing the Element Name. Must be cleaned, if have been used.

  function countTotalElementUseLength(node) // the parameter "node" is an Object of Node
  {
		var total = 0;

    // check node 
    if(node.nodeType == 1) // if node is an Element node
    {
			total++;// plus 1 to counter
		  elementName = elementName + node.tagName + "\r\n"; // save the tag name
	  }
	  var childrens = node.childNodes; // get all children of the node

    for(var i=0;i<childrens.length;i++)
    {
			total += countTotalElementUseLength(childrens[i]); // execute recursion for all children node
	  }

    return total;
  }

	function countTotalElementUseSibling(node) // the parameter "node" is an Object of Node
  {
		var total = 0;
        
    if(node.nodeType == 1) // if node is an Element node
    {
			total++; // plus 1 to counter
		  elementName = elementName + node.tagName + "\r\n"; // save the tag name
	  }

    var childrens = node.childNodes; // get all children of the node

    for(var m=node.firstChild; m!=null;m=m.nextSibling)
    {
			total += countTotalElementUseSibling(m); // execute recursion for all children node
	  }
	  return total;
  }
    
</script>
</head>

<body>

<a href="javascript:void(0)" onClick="alert('Total Count:' + countTotalElementUseLength(document) + '\r\nAll Elements As Follow:\r\n' + elementName);elementName='';">Start use Length</a>
<br>
<a href="javascript:void(0)" onClick="alert('Total Count:' + countTotalElementUseSibling(document) + '\r\nAll Elements As Follow:\r\n' + elementName);elementName='';">Start use Sibling</a>

</body>
</html>
