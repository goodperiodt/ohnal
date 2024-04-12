<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Today's weather, oh-nal'</title>
    <%@include file="../include/static-head.jsp"%>
</head>
<body>
    <%@include file="../include/header.jsp"%>

    <div id="wrap">
        <div class="top-section">
            <div class="left-section">
                <div class="left-top">
                    <img class="weather-icon" src="./assets/img/test1.png" alt="weather">
                </div>
                <div class="left-down">
                    <h2>오늘 서울시 마포구의 기온은</h2>
                    <h2>최저 10도, 최고 20도입니다</h2>
                </div>
            </div>
            <div class="right-section">
                <div class="right-top">
                    <h2>오늘의 패션 예보</h2>
                </div>
                <div class="right-down">
                    <img src="./assets/img/cody.png" alt="test">
                </div>
            </div>
        </div>

        <!-- 검색창 영역 -->
        <div class="search-section">
            <h2 class="main-title">WEATHER SEARCH</h2>

            <form action="#">
                <select name="h_area1" onChange="cat1_change(this.value,h_area2)" class="h_area1">
                    <option>&nbsp 시, 도를 선택하세요</option>
                    <option value='1'>&nbsp서울특별시</option>
                    <option value='2'>&nbsp부산광역시</option>
                    <option value='3'>&nbsp대구광역시</option>
                    <option value='4'>&nbsp인천광역시</option>
                    <option value='5'>&nbsp광주광역시</option>
                    <option value='6'>&nbsp대전광역시</option>
                    <option value='7'>&nbsp울산광역시</option>
                    <option value='8'>&nbsp강원특별자치도</option>
                    <option value='9'>&nbsp경기도</option>
                    <option value='10'>&nbsp경상남도</option>
                    <option value='11'>&nbsp경상북도</option>
                    <option value='12'>&nbsp전라남도</option>
                    <option value='13'>&nbsp전라북도</option>
                    <option value='14'>&nbsp제주특별자치도</option>
                    <option value='15'>&nbsp충청남도</option>
                    <option value='16'>&nbsp충청북도</option>
                </select>
                <select name="h_area2">
                    <option>&nbsp시,군,구를 선택하세요</option>
                </select>
                <button id="sendBtn" class="btn btn-primary" type="button">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>

        <div class="board-section">
            <h2 class="main-title">BEST OOTD</h2>
            <button class="add-btn">더 보기</button>
        </div>



        <!-- BEST OOTD 게시판 영역 -->

        <!-- 카드 복붙 -->
        <div class="card-container">

            <div class="card-wrapper">
                <section class="card" data-bno="${b.boardNo}">
                    <div class="card-title-wrapper">
                        <div class="profile-box">
                            <img src="./assets/img/anonymous.jpg" alt="프사">
                        </div>
                        <span class="card-account">test3</span>
                    </div>

                    <div class="card-picture">
                        <img src="./assets/img/cody.png" alt="sample">
                    </div>

                    <div class="icon-wrapper">
                        <div class="like-icon">
                            <span class="lnr lnr-heart"></span>
                        </div>
                        <span class="hashtag">#서울시강남구</span>
                        <span class="hashtag">#최저12최고25</span>
                        <div class="reply-icon">
                            <!-- <span class="lnr lnr-bubble"></span> -->
                        </div>
                    </div>
                    <hr>
                    <div class="content-wrapper">
                        <p><span>좋아요 598개</span>&nbsp&nbsp&nbsp<span>댓글 30개</span></p>
                        <p><span class="card-account">test3</span> 일교차가 클 땐 아우터를 가볍게 걸치는 게 좋아</p>
                        <a href="#">
                            <p>... 더 보기</p>
                        </a>
                    </div>
                </section>
            </div>

            <!-- 카드 복붙 -->
            <div class="card-wrapper">
                <section class="card" data-bno="${b.boardNo}">
                    <div class="card-title-wrapper">
                        <div class="profile-box">
                            <img src="/assets/img/anonymous.jpg" alt="프사">
                        </div>
                        <span class="card-account">test3</span>
                    </div>

                    <div class="card-picture">
                        <img src="./assets/img/cody.png" alt="sample">
                    </div>

                    <div class="icon-wrapper">
                        <div class="like-icon">
                            <span class="lnr lnr-heart"></span>
                        </div>
                        <span class="hashtag">#서울시강남구</span>
                        <span class="hashtag">#최저12최고25</span>
                        <div class="reply-icon">
                            <!-- <span class="lnr lnr-bubble"></span> -->
                        </div>
                    </div>
                    <hr>
                    <div class="content-wrapper">
                        <p><span>좋아요 598개</span>&nbsp&nbsp&nbsp<span>댓글 30개</span></p>
                        <p><span class="card-account">test3</span> 일교차가 클 땐 아우터를 가볍게 걸치는 게 좋아</p>
                        <a href="#">
                            <p>... 더 보기</p>
                        </a>
                    </div>
                </section>
            </div>

            <!-- 카드 복붙 -->
            <div class="card-wrapper">
                <section class="card" data-bno="${b.boardNo}">
                    <div class="card-title-wrapper">
                        <div class="profile-box">
                            <img src="/assets/img/anonymous.jpg" alt="프사">
                        </div>
                        <span class="card-account">test3</span>
                    </div>

                    <div class="card-picture">
                        <img src="./assets/img/cody.png" alt="sample">
                    </div>

                    <div class="icon-wrapper">
                        <div class="like-icon">
                            <span class="lnr lnr-heart"></span>
                        </div>
                        <span class="hashtag">#서울시강남구</span>
                        <span class="hashtag">#최저12최고25</span>
                        <div class="reply-icon">
                            <!-- <span class="lnr lnr-bubble"></span> -->
                        </div>
                    </div>
                    <hr>
                    <div class="content-wrapper">
                        <p><span>좋아요 598개</span>&nbsp&nbsp&nbsp<span>댓글 30개</span></p>
                        <p><span class="card-account">test3</span> 일교차가 클 땐 아우터를 가볍게 걸치는 게 좋아</p>
                        <a href="#">
                            <p>... 더 보기</p>
                        </a>
                    </div>
                </section>
            </div>

            <!-- 카드 복붙 -->
            <div class="card-wrapper">
                <section class="card" data-bno="${b.boardNo}">
                    <div class="card-title-wrapper">
                        <div class="profile-box">
                            <img src="/assets/img/anonymous.jpg" alt="프사">
                        </div>
                        <span class="card-account">test3</span>
                    </div>

                    <div class="card-picture">
                        <img src="./assets/img/cody.png" alt="sample">
                    </div>

                    <div class="icon-wrapper">
                        <div class="like-icon">
                            <span class="lnr lnr-heart"></span>
                        </div>
                        <span class="hashtag">#서울시강남구</span>
                        <span class="hashtag">#최저12최고25</span>
                        <div class="reply-icon">
                            <!-- <span class="lnr lnr-bubble"></span> -->
                        </div>
                    </div>
                    <hr>
                    <div class="content-wrapper">
                        <p><span>좋아요 598개</span>&nbsp&nbsp&nbsp<span>댓글 30개</span></p>

                        <p><span class="card-account">test3</span> 일교차가 클 땐 아우터를 가볍게 걸치는 게 좋아</p>
                        <a href="#">
                            <p>... 더 보기</p>
                        </a>
                    </div>
                </section>
            </div>
        </div>
    </div>

    <%@include file="../include/footer.jsp"%>
</body>
</html>