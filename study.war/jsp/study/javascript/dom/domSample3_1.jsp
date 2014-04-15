<html>
<head>
<title>innerHTML Sample</title>

<script language="javascript">

    function chageValue(obj,number)
    {
        if (number == 1)
        {
            //document.getElementById(obj).innerHTML = "Value = 1";
            document.getElementById(obj).innerText = "Value = 1";
        }
        if (number == 2)
        {
            //document.getElementById(obj).innerHTML = "Value = 2";
            document.getElementById(obj).innerText = "Value = 2";
        }
    }

</script>
    
</head>
<body>

DIV:<div id="div1">Default DIV Value</div>

<a href="#" onClick="chageValue('div1',1)">Change value to 1</a>, &nbsp;
<a href="#" onClick="chageValue('div1',2)">Change value to 2</a>
<br>
SPAN:<span id="span1">Default SPAN Value</span> <br>
<a href="#" onClick="chageValue('span1',1)">Change value to 1</a>, &nbsp;
<a href="#" onClick="chageValue('span1',2)">Change value to 2</a>

<br>
<div id="test">
   <span style="color:red">test1</span>
    test2
</div>

<a href="javascript:alert(test.innerHTML)">Content of innerHTML</a>
<a href="javascript:alert(test.innerText)">Content of innerText</a>
<a href="javascript:alert(test.outerHTML)">Content of outerHTML</a>


</body>
</html>