<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="../resources/css/timeoutStyle.css"%></style>
        <title><fmt:message key="title.timeoutPage"/></title>
    </head>
    <body>
        <div class="timeout-container">
            <h1><fmt:message key="timeout.oops"/></h1>
            <p><fmt:message key="timeout.inactive"/></p>
            <form action="index.html">
                <input type="submit" value='<fmt:message key="button.toMain"/>'/>
            </form>
        </div>
    </body>
    </fmt:bundle>
</html>
