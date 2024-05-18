<%@ page import="java.util.List" %>
<%@ page import="model.Quest" %>
<%@ page import="dao.QuestDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список квестов</title>
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
<h1>Список квестов <a href="users.jsp">Показать юзеров</a></h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Text</th>
        <th>Person ID</th>
        <th>Reward</th>
        <th>Penalty</th>
        <th>Time of Started</th>
        <th>Time for Quest (Minutes)</th>
        <th>Place ID</th>
        <th>Model ID</th>
        <th>Level Difficulty</th>
        <th>Quest Status</th>

    </tr>
    <%
        QuestDao userDao = new QuestDao();
        List<Quest> quests = userDao.getAllQuest();
        for (Quest quest : quests) {
    %>
    <tr>
    <tr>
        <td><%= quest.getQuestId() %></td>
        <td><%= quest.getQuestTitle() %></td>
        <td><%= quest.getQuestText() %></td>
        <td><%= quest.getPersonId() %></td>
        <td><%= quest.getReward() %></td>
        <td><%= quest.getPenalty() %></td>
        <td><%= quest.getTimeOfStarted() %></td>
        <td><%= quest.getTimeForQuestInMinutes() %></td>
        <td><%= quest.getPlaceId() %></td>
        <td><%= quest.getModelId() %></td>
        <td><%= quest.getLevelDifficulty() %></td>
        <td><%= quest.getQuestStatus() %></td>

        <td>
            <form action="DeleteQuest" method="post">
                <input type="hidden" name="questId" value="<%= quest.getQuestId() %>">
                <input type="submit" value="Удалить">
            </form>
        </td>
    </tr>
    <% } %>

</table>
</body>
</html>