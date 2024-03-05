<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="question ${result}">
    <h1>${question.getTitle()}</h1>
    <form class="decision-form" action="quest" method="post">
        <input type="hidden" name="questionId" value="${question.getId()}">
            <c:forEach var="decision" items="${question.getDecisions()}">
                <input type="radio" name="decisionId" value="${decision.value.getId()}">
                <label>${decision.value.getTitle()}</label><br>
            </c:forEach>
        <input type="submit" value="далі">
    </form>
</div>
</body>
</html>

