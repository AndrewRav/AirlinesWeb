<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/errorStyle.css"%></style>
            <title><fmt:message key="title.errorPage"/></title>
        </head>
        <body>
            <div class="error-container">
                <h1><fmt:message key="error.oops"/></h1>
                <p><fmt:message key="error.systemError"/></p>
            </div>
            <div class="center">
                <form action="index.html">
                    <input class="leave" type="submit" value='<fmt:message key="button.toMain"/>'/>
                </form>
            </div>
        </body>
    </fmt:bundle>
</html>
