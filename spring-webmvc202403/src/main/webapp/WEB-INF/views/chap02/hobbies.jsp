<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>hobbies</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

 <%-- ------------------------------------------------------------------------------------------ --%>
<%--
 <div>
        <h1>HOT5</h1>
        <table class="table text-center">
            <thead>
                <tr>
                    <th>순위</th>
                    <th>제목</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="music" items="${music}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${music}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     --%>
<%--
     <div>
        <h1>멤버십</h1>
        <table class="table text-center">
            <thead>
                <tr>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>등급</th>
                    <th>포인트</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${membership}" varStatus="status">
                <tr>
                    <td>${member.name}</td>
                    <td>${member.phoneNumber}</td>
                  <c:choose>
                        <c:when test="${member.grade eq 'VIP'}">
                            <td class="text-danger">${member.grade}</td>
                        </c:when>
                        <c:when test="${member.grade eq 'GOLD'}">
                            <td class="text-warning">${member.grade}</td>
                       </c:when>
                       <c:otherwise>
                            <td>${member.grade}</td>
                       </c:otherwise>
                  </c:choose>
                  <c:choose>
                     <c:when test="${member.point >= 5000}">
                        <td class="text-info">${member.point}</td>
                     </c:when>
                       <c:otherwise>
                             <td>${member.point}</td>
                       </c:otherwise>
                  </c:choose>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
--%>
<%--
 <div>
        <h1>후보자 득표율</h1>
        <table class="table text-center">
            <thead>
                <tr>
                    <th>순위</th>
                    <th>득표 수</th>
                    <th>득표 율</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="candidate" items="${candidates}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><fmt:formatNumber value="${candidate}" /></td>
                    <td><fmt:formatNumber value="${candidate / 1000000}" type="percent" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
--%>








    
</body>
</html>