<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список пользователей</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<h1>Список пользователей <a href="quests.jsp">|Показать квесты|</a> </h1>

<table border="1">
    <tr>
        <th width="50">ID</th>
        <th width="100">Auth Token</th>
        <th width="100">Username</th>
        <th width="150">Position on Starship</th>
        <th width="50">Age</th>
        <th width="50">Sex</th>
        <th width="75">Balance</th>
        <th width="200">Background</th>
        <th width="400">Public Background</th>
        <th width="100">Photo</th>
        <th width="200">Security Background</th>
        <th width="200">Medical Background</th>
        <th width="200">Psychology Background</th>
        <th width="100">Last Available</th>
        <th width="100">User Settings</th>
        <th width="100">Действия</th>
    </tr>
    <%
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getUserId() %></td>
        <td><%= user.getAuthToken() %></td>
        <td><%= user.getUserName() %></td>
        <td><%= user.getPositionOnStarship() %></td>
        <td><%= user.getAge() %></td>
        <td><%= user.getSex() %></td>
        <td><%= user.getBalance() %></td>
        <td><%= user.getBackground().length() > 50 ? user.getBackground().substring(0, 50) : user.getBackground() %></td>
        <td><%= user.getPublicBackground() %></td>
        <td><%= user.getPhoto() %></td>
        <td><%= user.getSecurityBackground() %></td>
        <td><%= user.getMedicalBackground() %></td>
        <td><%= user.getPsychologyBackground() %></td>
        <td><%= user.getLastAvailable() %></td>
        <td><%= user.getUserSettings() %></td>
        <td>
            <form action="DeleteUser" method="post">
                <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                <input type="submit" value="Удалить">
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
