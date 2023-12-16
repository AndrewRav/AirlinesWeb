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
            <title><fmt:message key="title.tickets"/></title>
    </head>
    <body>
        <form action="BackServlet" method="post">
            <input type="submit" class="leave" value='<fmt:message key="button.back"/>' />
        </form>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th><fmt:message key="label.flightNumber"/></th>
                    <th><fmt:message key="label.seat"/></th>
                    <th><fmt:message key="label.departurePoint"/></th>
                    <th><fmt:message key="label.destinationPoint"/></th>
                    <th><fmt:message key="label.departureTime"/></th>
                    <th><fmt:message key="label.arrivalTime"/></th>
                    <th><fmt:message key="label.airplaneType"/></th>
                    <th><fmt:message key="label.firstName"/></th>
                    <th><fmt:message key="label.lastName"/></th>
                    <th><fmt:message key="label.surName"/></th>
                    <th><fmt:message key="label.update"/></th>
                    <th><fmt:message key="label.delete"/></th>
                </tr>
            </thead>
            <c:forEach var="ticket" items="${ticket}">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.flightNumber}</td>
                    <td>${ticket.seat}</td>
                    <td>${ticket.departurePoint}</td>
                    <td>${ticket.destinationPoint}</td>
                    <td>${ticket.departureTime}</td>
                    <td>${ticket.arrivalTime}</td>
                    <td>${ticket.airplaneType}</td>
                    <td>${ticket.ticketOwnerFirstName}</td>
                    <td>${ticket.ticketOwnerLastName}</td>
                    <td>${ticket.ticketOwnerSurName}</td>
                    <td><form action="UpdateTicketServlet" method="get" class="update">
                            <input type="hidden" name="id" value="${ticket.id}"/>
                            <input type="submit" value='<fmt:message key="button.update"/>'/>
                        </form>
                    </td>
                    <td><form action="DeleteTicketServlet" method="post" class="delete">
                            <input type="hidden" name="id" value="${ticket.id}"/>
                            <input type="submit" value='<fmt:message key="button.delete"/>'/>
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </table>
    </body>
    </fmt:bundle>
</html>