<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URL, java.util.*" %>
<%@ page session="true" %>

<html>
    <head>
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
    <div class="container-md">
      <div class="row">
        <div class="col">
          <h3>Welcome ${username}!</h3>
        </div>
        <div class="col">
          <button type="button" class="btn btn-primary"><a href="/ticket" style="color:#ffffff;">Create Ticket</a></button>
        </div>
        <div class="col">
          <button type="button" class="btn btn-primary"><a href="/dashboard" style="color:#ffffff;">Dashboard</a></button>
        </div>
        <div class="col">
           <button type="button" class="btn btn-primary"><a href="/downloadTemplate" style="color:#ffffff;">Generate Report</a></button>
        </div>
      </div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Ticket-ID</th>
                    <th scope="col">Heading</th>
                    <th scope="col">Description</th>
                    <th scope="col">CreatedBy</th>
                    <th scope="col">View</th>
                    <th scope="col">Edit</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tickets}" var="ticket">
                    <tr>
                        <td>${ticket.ticketId}</td>
                        <td>${ticket.ticketHeading}</td>
                        <td>${ticket.ticketDescription}</td>
                        <td>${ticket.createdBy}</td>
                        <td><a href="#" onclick="location.href = '/ticket/show-ticket/' + ${ticket.ticketId}">view</a></a></td>
                        <td><a href="#" onclick="location.href = '/ticket/edit-ticket/' + ${ticket.ticketId}">edit</a></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>