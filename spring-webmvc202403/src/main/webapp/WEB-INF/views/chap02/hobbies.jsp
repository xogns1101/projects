<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>hobbies</title>
</head>
<body>

    <h1>${userName}님 취미 목록</h1>

    <ol>
        <c:forEach var="h" items="${hobbies}">
            <li>${h}</li>
         </c:forEach>
    </ol>

       <ul>
            <c:forEach var="h" items="${hobbies}" varStatus="status">
                <li>${status.count} ${h}</li>
             </c:forEach>
       </ul>


    
</body>
</html>