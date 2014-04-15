<html>
<head>
<title>Struts and Ajax Sample1</title>
<Script type="text/javascript" src="/yeep/js/prototype.js"></script>
</head>
<body>

Select Department:
<select id="department">
    <option value="Manager">Manager Room</option>
    <option value="Developer">Developer Room</option>
</select>
&nbsp;&nbsp;
<br><br>&nbsp;&nbsp;&nbsp;&nbsp;
Select Position:
<span id="pos">
<select id="position">
</select>
</span>

</body>
</html>

<script language="javascript">

    Event.observe($("department"), 'change', ajaxChangeDept, false);

    function ajaxChangeDept()
    {
        //alert("ajaxChangeDept");
        var department = $F('department');
        var url = '/yeep/strutsAjaxSample.do';
        //var url = 'http://localhost:18080/yeep/strutsAjaxSample.do';
        var pars = 'method=searchPosition'+'&department=' + department;
        var myAjax = new Ajax.Request(
                        url,
                        {method: 'post', parameters: pars, onComplete: showResponse}
                        );
        }

        function showResponse(httprequest)
        {
            $('pos').innerHTML = httprequest.responseText;
        }

</script>
