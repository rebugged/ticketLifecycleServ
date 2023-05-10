<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URL, java.util.*" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Ticket Details</title>
    </head>
    <body>
        <div class="container">
          <h1>Ticket Details :</h1>
          <div class="card">
           <div class="card-body">
            <form action="<%=request.getContextPath()%>/dashboard" method="get">
             <div class="form-group row">
              <label for="ticketId" class="col-sm-2 col-form-label">Ticket ID</label>
              <div class="col-sm-7">
                <span class="form-control">${ticket.ticketId}</span>
              </div>
             </div>

             <div class="form-group row">
              <label for="ticketHeading" class="col-sm-2 col-form-label">Ticket Title:</label>
              <div class="col-sm-7">
               <span class="form-control">${ticket.ticketHeading}</span>
              </div>
             </div>

             <div class="form-group row">
              <label for="ticketDescription" class="col-sm-2 col-form-label">Ticket Description</label>
              <div class="col-sm-7">
               <span class="form-control">${ticket.ticketDescription}</span>
              </div>
             </div>

             <div class="form-group row">
              <label for="assignedTo" class="col-sm-2 col-form-label">Assigned To</label>
              <div class="col-sm-7">
               <span class="form-control">${ticket.assignedTo}</span>
              </div>
             </div>

             <div class="form-group row">
              <label for="ticketStatus" class="col-sm-2 col-form-label">Ticket Status</label>
              <div class="col-sm-7">
               <span class="form-control">${ticket.ticketStatus}</span>
              </div>
             </div>

             <div class="form-group row">
              <label for="createdDate" class="col-sm-2 col-form-label">Created Date</label>
              <div class="col-sm-7">
               <span class="form-control">${ticket.createdDate}</span>
              </div>
             </div>

             <button type="submit" class="btn btn-primary">Got back to dashboard</button>
            </form>
           </div>
          </div>
         </div>
    </body>
</html>