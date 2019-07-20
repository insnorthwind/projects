<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAccountServiceImplProxyid" scope="session" class="msft.contoso.webservices.service.AccountServiceImplProxy" />
<%
	if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAccountServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
	String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAccountServiceImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp%>
<%
	}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
%>
        <%=tempResultreturnp3%>
        <%
        	}
        break;
        case 5:
                gotMethod = true;
                String endpoint_0id=  request.getParameter("endpoint8");
                    java.lang.String endpoint_0idTemp = null;
                if(!endpoint_0id.equals("")){
                 endpoint_0idTemp  = endpoint_0id;
                }
                sampleAccountServiceImplProxyid.setEndpoint(endpoint_0idTemp);
        break;
        case 10:
                gotMethod = true;
                msft.contoso.webservices.service.AccountServiceImpl getAccountServiceImpl10mtemp = sampleAccountServiceImplProxyid.getAccountServiceImpl();
        if(getAccountServiceImpl10mtemp == null){
        %>
<%=getAccountServiceImpl10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
	}
break;
case 15:
        gotMethod = true;
        String name_1id=  request.getParameter("name24");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        msft.contoso.webservices.beans.Account getAccount15mtemp = sampleAccountServiceImplProxyid.getAccount(name_1idTemp);
if(getAccount15mtemp == null){
%>
<%=getAccount15mtemp%>
<%
	}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">owner:</TD>
<TD>
<%
	if(getAccount15mtemp != null){
java.lang.String typeowner18 = getAccount15mtemp.getOwner();
        String tempResultowner18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeowner18));
%>
        <%=tempResultowner18%>
        <%
        	}
        %>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
	if(getAccount15mtemp != null){
java.lang.String typename20 = getAccount15mtemp.getName();
        String tempResultname20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename20));
%>
        <%=tempResultname20%>
        <%
        	}
        %>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">role:</TD>
<TD>
<%
	if(getAccount15mtemp != null){
java.lang.String typerole22 = getAccount15mtemp.getRole();
        String tempResultrole22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typerole22));
%>
        <%=tempResultrole22%>
        <%
        	}
        %>
</TD>
</TABLE>
<%
	}
break;
case 26:
        gotMethod = true;
        String owner_3id=  request.getParameter("owner31");
            java.lang.String owner_3idTemp = null;
        if(!owner_3id.equals("")){
         owner_3idTemp  = owner_3id;
        }
        String name_4id=  request.getParameter("name33");
            java.lang.String name_4idTemp = null;
        if(!name_4id.equals("")){
         name_4idTemp  = name_4id;
        }
        String role_5id=  request.getParameter("role35");
            java.lang.String role_5idTemp = null;
        if(!role_5id.equals("")){
         role_5idTemp  = role_5id;
        }
%>
        <jsp:useBean id="com1dbs1id1webservices1beans1Account_2id" scope="session" class="msft.contoso.webservices.beans.Account" />
        <%
        	com1dbs1id1webservices1beans1Account_2id.setOwner(owner_3idTemp);
                com1dbs1id1webservices1beans1Account_2id.setName(name_4idTemp);
                com1dbs1id1webservices1beans1Account_2id.setRole(role_5idTemp);
                boolean addAccount26mtemp = sampleAccountServiceImplProxyid.addAccount(com1dbs1id1webservices1beans1Account_2id);
                String tempResultreturnp27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addAccount26mtemp));
        %>
        <%=tempResultreturnp27%>
        <%
        	break;
        case 37:
                gotMethod = true;
                String name_6id=  request.getParameter("name40");
                    java.lang.String name_6idTemp = null;
                if(!name_6id.equals("")){
                 name_6idTemp  = name_6id;
                }
                boolean deleteAccount37mtemp = sampleAccountServiceImplProxyid.deleteAccount(name_6idTemp);
                String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteAccount37mtemp));
        %>
        <%=tempResultreturnp38%>
        <%
        	break;
        case 42:
                gotMethod = true;
                msft.contoso.webservices.beans.Account[] getAllAccounts42mtemp = sampleAccountServiceImplProxyid.getAllAccounts();
        if(getAllAccounts42mtemp == null){
        %>
<%=getAllAccounts42mtemp %>
<%
}else{
        String tempreturnp43 = null;
        if(getAllAccounts42mtemp != null){
        java.util.List listreturnp43= java.util.Arrays.asList(getAllAccounts42mtemp);
        tempreturnp43 = listreturnp43.toString();
        }
        %>
        <%=tempreturnp43%>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>