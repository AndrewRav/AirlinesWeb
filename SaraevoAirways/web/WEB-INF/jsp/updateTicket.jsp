<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/updateStyle.css"%></style>
            <title><fmt:message key="title.updateTicket"/></title>
    </head>
    <body>
        <form action="BackServlet" method="post">
            <input type="submit" class="leave" value='<fmt:message key="button.back"/>' />
        </form>
        <form action="UpdateTicketServlet" method="post">
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
                    </tr>
                </thead>
                <tr>
                    <td>${ticket.id}</td>
                    <td><input type="number" name="flightNumber" value="${ticket.flightNumber}" required></td>
                    <td><input type="number" name="seat" value="${ticket.seat}" required></td>
                    <td><input type="text" name="departurePoint" value="${ticket.departurePoint}" required></td>
                    <td><input type="text" name="destinationPoint" value="${ticket.destinationPoint}" required></td>
                    <td><input type="datetime-local" name="departureTime" value="${ticket.departureTime}" required></td>
                    <td><input type="datetime-local" name="arrivalTime" value="${ticket.arrivalTime}" required></td>
                    <td><input type="text" name="airplaneType" value="${ticket.airplaneType}" required></td>
                    <td><input type="text" name="ticketOwnerFirstName" value="${ticket.ticketOwnerFirstName}" required></td>
                    <td><input type="text" name="ticketOwnerLastName" value="${ticket.ticketOwnerLastName}" required></td>
                    <td><input type="text" name="ticketOwnerSurName" value="${ticket.ticketOwnerSurName}" required></td>
                    <td>
                        <input type="hidden" name="id" value="${ticket.id}"/>
                        <input type="submit" value='<fmt:message key="button.update"/>'/>
                    </td>              
                </tr>
            </table>
        </form>
    </body>
    </fmt:bundle>
</html>