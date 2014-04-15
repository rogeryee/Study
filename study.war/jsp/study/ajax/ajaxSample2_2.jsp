
<%
    String playPos = request.getParameter("playPos");
    if("pos_1".equals(playPos))
        out.print("&nbsp;&nbsp;General Manager<br>&nbsp;&nbsp;Vice of General Manager");
    else if("pos_2".equals(playPos)) 
        out.println("&nbsp;&nbsp;Systems Engineer<br>&nbsp;&nbsp;Software Engineer");
%>
