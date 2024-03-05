<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Quests Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="quests">
    <h1>Виберіть квест</h1>
    <ul>
        <c:forEach var="quest" items="${quests}">
            <li>
                <h2>${quest.value.getTitle()}</h2>
                <form class="quests-form" action="quest" method="post">
                    <input type="hidden" name="questId" value="${quest.value.getId()}">
                    <input type="submit" value="почати квест">
                </form>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>


