<html>
<head>
<title>Javascript Function Sample</title>

<script language="javascript">

    // function definations
    function addFuncDef1(x,y){return x+y;}
    var addFuncDef2 = function(x,y){return x+y;}
    var addFuncDef3 = new Function("x","y","return x+y;");
    var addFuncDef4 = function a(x,y){return x+y;}

     //function arguments
     function addFuncArg(x,y)
     {
        alert('addFuncArg ----> x = ' + x + ',y = ' + y);
        alert('addFuncArg ----> arguments[0] = ' + arguments[0] + ',arguments[1] = ' + arguments[1]);

        alert('addFuncArg ----> arguments.callee = ' + arguments.callee)
        alert('addFuncArg ----> typeof (arguments.callee) = ' + typeof (arguments.callee));

        arguments[0] = 11 ;
        
        return x + y;
    }

    // pass fucntion to variable as general variable
    var  test1 = function (x,y)  { return  x + y;} ;
    var  func = test1;
    function addFuncPass(func,x,y)
    {
        return  func(x,y);
    }

</script>
    
</head>
<body>

    <!--
        There are four kinds Defination for Function, but the usages of them are different 
    -->
    <input type="button" value="Call addFuncDef1" onclick="alert(addFuncDef1(1,2));" >&nbsp;
    <input type="button" value="Call addFuncDef2" onclick="alert(addFuncDef2(1,2));" >&nbsp;
    <input type="button" value="Call addFuncDef3" onclick="alert(addFuncDef3(1,2));" >&nbsp;
    <input type="button" value="Call addFuncDef4" onclick="alert(addFuncDef4(1,2));" >&nbsp;
    <br><br>

    <!--
        There are four kinds Defination for Function, but the usages of them are different
    -->
    <input type="button" value="Call addFuncArg" onclick="alert(addFuncArg(1,2));" >&nbsp;
    <br><br>

    <!--
        We can pass function as a general variable to anther function
    -->
    <input type="button" value="Call addFuncPass" onclick="alert(addFuncPass(func,1,2));" >&nbsp;
    <br><br>


</body>
</html>