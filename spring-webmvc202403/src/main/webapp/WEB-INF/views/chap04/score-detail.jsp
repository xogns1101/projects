<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


    <style>
        li {
            list-style: none;
            margin: 0;
            padding: 0;
            font-size: 1.4em;
        }

        section.score-main {
            width: 30%;
            margin: 0 auto 150px;
            padding: 20px;
            border: 2px solid orange;
            border-radius: 10px;
            box-shadow: 2px 2px 5px orangered;
            transform: translateY(200px);
        }

        .btn-group a {
            display: block;
            width: fit-content;
            text-decoration: none;
            color: white;
            box-shadow: 1px 1px 2px rgb(146, 228, 146);
            border-radius: 5px;
            border: 1px solid white;
            padding: 5px;
            margin: 0 5px;
        }
        a.list-btn {
            background: rgb(83, 189, 83);
        }
        a.mod-btn {
            background: rgb(228, 248, 49);
            color: #333;
        }
    </style>

</head>

<body>

<div class="wrap">
    <section class="score-main">
        <h1>${detail.name}님 성적 정보</h1>
        <ul>
            <li># 국어: ${detail.kor}점</li>
            <li># 영어: ${detail.eng}점</li>
            <li># 수학: ${detail.math}점</li>
            <li># 총점: ${detail.total}점</li>
            <li># 평균: ${detail.average}점</li>
            <li># 학점: ${detail.grade}</li>
        </ul>
        <div class="btn-group">
            <a class="list-btn" href="/score/list">목록</a>
            <!-- 수정 페이지 이동 링크 -> 서버에게 몇 번 학생이 수정되려는지를
             알려줘야 하기 때문에 파리미터를 추가해서 요청 전달-->
            <a class="mod-btn" href="/score/modify?stuNum=${detail.stuNum}">수정</a>
        </div>
    </section>

</div>
</body>

</html>