<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>Regular Expression Sample</title>
<Script type="text/javascript" src="/yeep/js/prototype.js"></script>
<script language="javascript">

    // Functions for Regular Expression
            
    // Validate for the input string
    // whether it is made up of numeric within 20 charact 
    function isDigit(s)
    {
        var patrn=/^[0-9]{1,20}$/;
        if (!patrn.exec(s))
        {
        	alert("The string you input contains Nan!");
        	return;
        }
        alert("Passed!");
    } 

</script>
</head>

<body>

    <!--
        Validate for input string whether it is made up of numeric within 20 charact
    -->
    <input type="text" id="text1" >&nbsp;
    <input type="button" value="isDigit" onclick="isDigit($F('text1'));" >&nbsp;
    <br><br>

    <input type="button" value="close" onclick="window.opener=null;window.close();" >
</body>
</html>
