<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/resultStyle.css"%></style>
            <title><fmt:message key="title.result"/></title>
    </head>
    <body>
        <h1><fmt:message key="${success ? 'message.success' : 'message.failure'}"/></h1> 
        <form action="BackServlet" method="post">
            <input type="submit" value='<fmt:message key="button.back"/>'/>
        </form>      
    </body>
    </fmt:bundle>
</html>