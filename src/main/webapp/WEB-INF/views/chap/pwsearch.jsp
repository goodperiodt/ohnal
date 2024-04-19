<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Insert Your Title</title>
    <link rel="stylesheet" href="/assets/css/pwsearch.css">
        <script type="text/javascript" src="/assets/js/pwsearch.js" defer></script>
        <%@include file="../include/static-head.jsp"%>
</head>
<body>

    <%@include file="../include/header.jsp"%>

 <div class="container">
        <h1>비밀번호 찾기</h1>
     
            <div class="form-group">
                <p class="font"><strong>이메일을 입력해주세요</strong>&nbsp;&nbsp;&nbsp;</p>
                <input type="email" id="email" name="email" placeholder="ex) on-nal@gmail.com" required="required"
                  aria-required="true" class="input">
            </div>
            <div class="form-group">
                <button type="submit">비밀번호 찾기</button>
                <input type="text" id="emailChkInput" placeholder="인증번호 6자리를 입력하세요." maxlength="6" disabled> <br>
                <span id="mailCheckMsg"></span>
                <span id="emailChk"></span>
            </div>
            <div id="message"></div>
     </div>
        <div class="pwFind">
            <div class="newPwInput">
                <p class="font"><strong>새로 설정하실 비밀번호를 입력해주세요</strong>&nbsp;&nbsp;&nbsp;</p>
                <input type="password" placeholder="영문과 특수문자를 포함한 8자를 입력해주세요" id="newPw" name="password"
                required="required"  aria-required="true">
                <span id="pwChk"></span>
            </div>
            <div class="newPwChk">
                <p class="font"><strong>입력하신 비밀번호를 재확인해주세요</strong>&nbsp;&nbsp;&nbsp;</p>
                <input type="password" placeholder="입력하신 비밀번호와 동일하게 입력해주세요" id="newPw" name="password"
                required="required"  aria-required="true">
                <span id="pwChk2"></span>
            </div>
        </div>


        <%@include file="../include/footer.jsp"%>

</body>
</html>