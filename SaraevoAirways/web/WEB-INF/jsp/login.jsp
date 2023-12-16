<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/loginStyle.css"%></style>
            <title><fmt:message key="title.login"/></title>
        </head>
        <body>
            <form action="local">
                <input type="hidden" name="locale" value="en"/>
                <input type="submit" value='<fmt:message key="en"/>'/>
            </form>
            <form action="local">
                <input type="hidden" name="locale" value="ru"/>
                <input type="submit" name="locale" value='<fmt:message key="ru"/>'/>
            </form>
            <form action="LoginServlet" method="get">
                <label for="login"><fmt:message key="label.login"/></label><br>
                <input type="text" id="login" name="login" required><br>
                <label for="password"><fmt:message key="label.password"/></label><br>
                <input type="password" id="password" name="password" required><br>
                <input type="submit" value='<fmt:message key="button.login"/>'>
            </form>
        </body>
        <script>
            window.onload = function () {
                var status = '${status}';
                if (status === 'failed') {
                    alert('<fmt:message key="message.login.failure"/>');
                }
            }
        </script>
    </fmt:bundle>
</html>