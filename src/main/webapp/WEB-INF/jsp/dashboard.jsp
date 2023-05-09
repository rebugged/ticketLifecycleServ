<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Dashboard</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
    <a href="/dashboard">Click here</a> to see all tickets.

        <table>
            <thead>
                <tr>
                    <th>Ticket-ID</th>
                    <th>Heading</th>
                    <th>Description</th>
                    <th>CreatedBy</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tickets}" var="ticket">
                    <tr>
                        <td>${ticket.ticketId}</td>
                        <td>${ticket.ticketHeading}</td>
                        <td>${ticket.ticketDescription}</td>
                        <td>${ticket.createdBy}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>