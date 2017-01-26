<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
java.util.List<com.apn.sefma.dao.Domain> domains = com.apn.sefma.Test.getDomains();
%>

<title>Insert title here</title>
</head>
<body>
Domains: <%= domains.size()%>


<% for(com.apn.sefma.dao.Domain domain : domains){%>
	
<h1><%= domain.getDomainId() %> - <%= domain.getName() %> </h1>


	
<%}%>


</body>
</html>