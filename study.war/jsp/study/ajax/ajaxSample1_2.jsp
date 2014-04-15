<%
    String username = request.getParameter("username");
    if("roger".equals(username))
        out.print("This name has already been used, please try another one!");
    else
        out.print("This name is acceptable, please continue");
%>

