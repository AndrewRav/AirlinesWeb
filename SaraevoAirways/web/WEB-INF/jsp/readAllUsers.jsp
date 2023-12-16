<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/readStyle.css"%></style>
            <title><fmt:message key="title.users"/></title>
    </head>
    <body>
        <form action="BackServlet" method="post">
            <input type="submit" class="leave" value='<fmt:message key="button.back"/>' />
        </form>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th><fmt:message key="label.login"/></th>
                    <th><fmt:message key="label.password"/></th>
                    <th><fmt:message key="label.lastName"/></th>
                    <th><fmt:message key="label.firstName"/></th>
                    <th><fmt:message key="label.surName"/></th>
                    <th><fmt:message key="label.email"/></th>
                    <th><fmt:message key="label.update"/></th>
                    <th><fmt:message key="label.delete"/></th>
                </tr>
            </thead>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.lastName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.surName}</td>
                    <td>${user.email}</td>
                    <td><form action="UpdateUserServlet" method="get" class="update">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value='<fmt:message key="button.update"/>'/>
                        </form>
                    </td>
                    <td><form action="DeleteUserServlet" method="post" class="delete">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value='<fmt:message key="button.delete"/>'/>
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </table>
    </body>
    </fmt:bundle>
</html>