<%-- 
    Document   : notes
    Created on : Oct 29, 2017, 3:25:13 PM
    Author     : 698437
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes Page</title>
    </head>
     <body>
        <h1>Manage Notes</h1>
        <h2>Notes</h2>
        <p>${errorMessage}</p>
        <table>
            <tr>
                <th>Note ID</th>
                <th>Date Created</th>
                <th>Contents</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="note" items="${notes}">
                <tr>
                    <td>${note.userID}</td>
                    <td>${note.dateCreated}</td>
                    <td>${note.contents}</td>
                    <td>
                        <form action="notes" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedUsername" value="${note.userID}">
                        </form>
                    </td>
                    <td>
                        <form action="notes" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedUsername" value="${note.userID}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
                        
        <c:if test="${selectedUser == null}">
            <h3>Add Note</h3>
            <form action="notes" method="POST">
                Note ID: <input type="text" name="userID"><br>
                Date Created: <input type="text" name="datecreated"><br>
                Contents: <input type="text" name="contents"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedUser != null}">
            <h3>Edit Note</h3>
            <form action="notes" method="POST">
                Note ID: <input type="text" name="username" value="${selectedUser.userID}" readonly><br>
                Date Created: <input type="text" name="firstname" value="${selectedUser.datecreated}"><br>
                Contents: <input type="text" name="lastname" value="${selectedUser.contents}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>
    </body>
</html>
