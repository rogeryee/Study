<html>
<head>
<title>Prototype Sample</title>
<Script type="text/javascript" src="/yeep/js/prototype.js"></script>

<script language="javascript">

	// Use $() function
    function testDollar1()
    {
        var d = $('myDiv');
        alert(d.innerHTML);
    }
	
	// Use $() function
    function testDollar2()
    {
        var divs = $('myDiv','myOtherDiv');
        for(i=0; i<divs.length; i++)
        {
            alert(divs[i].innerHTML);
        }
    }
	
	// Use $F() function
    function testDollarF()
    {
        alert(  $F('userName')  );
        alert(  $F('country')  );
    }

	// Use $A() function
    function testDollarA()
    {
        var someNodeList = $('lstEmployees').getElementsByTagName('option');
        var nodes = $A(someNodeList);

        nodes.each(function(aa){
                   alert(aa.nodeName + ': ' + aa.innerHTML);
                   });
    }
	
	// Use $H() function
    function testDollarH()
    {
        //let's create the object
        var a = {
            first: 10,
            second: 20,
            third: 30
        };

        //now transform it into a hash
        var h = $H(a);
        alert(h.toQueryString()); //displays: first=10&second=20&third=30
    }
    
    // Use $R() function
    function testDollarR()
    {
        var range = $R(10, 15, false);
        range.each(function(value, index){
                   alert(value);
                   //alert("value=" + value + " index=" + index);
                  });
    }

	// Use Try.these function
    function testTryThese()
    {
        var value = Try.these
                    (
                        function()
                        {
                            return 1;
                        },
                        function()
                        {
                            return 2;
                        }
                    );
        alert("value returned = " + value);
    }
    
</script>

</head>
<body>

    <!--
        The $() function is a handy shortcut to the all-too-frequent document.getElementById()
    function of the DOM. Like the DOM function, this one returns the element that has the id passed as an argument.
        Unlike the DOM function, though, this one goes further. You can pass more than one id and $()
    will return an Array object with all the requested elements.
    -->
    <div id="myDiv">
        <p>This is a paragraph</p>
    </div>
    
    <div id="myOtherDiv">
        <p>This is another paragraph</p>
    </div>

    <input type="button" value="$() Test1" onclick="testDollar1();">&nbsp;
    <input type="button" value="$() Test2" onclick="testDollar2();">
    <br><br>

    <!--
        The $F() function is a another welcome shortcut. It returns the value of
    any field input control, like text boxes or drop-down lists. The function
    can take as argument either the element id or the element object itself.    
    -->
    <input type="text" id="userName" value="Joe Doe"><br>
    <select id="country">
        <option value="CHINA">China</option>
        <option value="USA">U.S.A</option>
    </select><br>
    <input type="button" value="$F() Test" onclick="testDollarF();">
    <br><br>

    <!--
        The $A() function converts the single argument it receives into an Array object.
        This function, combined with the extensions for the Array class, makes it easier to convert
    or copy any enumerable list into an Array object. One suggested use is to convert DOM NodeLists
    into regular arrays, which can be traversed more efficiently.     
    -->
    <select id="lstEmployees" size="5" >
        <option value="5">Buchanan, Steven</option>
        <option value="8">Callahan, Laura</option>
        <option value="1">Davolio, Nancy</option>
    </select>

    <input type="button" value="$A() Test" onclick="testDollarA();" >
    <br><br>

    <!--
        The $H() function converts objects into enumerable Hash objects that resemble associative arrays.
     -->
    <input type="button" value="$H() Test" onclick="testDollarH();" >
    <br><br>

    <!--
        The $R() function is simply a short hand to writing new
    ObjectRange(lowerBound, upperBound, excludeBounds).
        Jump to the ObjectRange class documentation for a complete explanation
    of this class. In the meantime, let's take a look at a simple example
    that also shows the usage of iterators through the each method.
    -->
    <input type="button" value="$R() Test" onclick="testDollarR();" >
    <br><br>

    <!--
        The Try.these() function makes it easy when you want to, ahem, try different
    function calls until one of them works. It takes a number of functions as
    arguments and calls them one by one, in sequence, until one of them works,
    returning the result of that successful function call.
        In the example, the function xmlNode.text works in some browsers,
    and xmlNode.textContent works in the other browsers. Using the Try.these()
    function we can return the one that works.
    -->
    <input type="button" value="Try.Test" onclick="testTryThese();" >

</body>
</html>