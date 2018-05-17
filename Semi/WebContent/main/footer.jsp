<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.footer{
	background-color: rgb(89, 89, 89);
}
ul{
	margin-left:auto;
	margin-right:auto;
	list-style: none;
	display: inline-block;
}
a{
	text-decoration: none;
	color: gray;
}
footer.footer {
	text-align: left;
    position: relative;
    background-color: #3e3e3e;
}
article, aside, canvas, details, figcaption, figure, footer, header, nav, menu, nav, section, main {
    display: block;
}
* {
    -webkit-tap-highlight-color: transparent;
}
* {
    margin: 0;
    padding: 0;
}
/* user agent stylesheet */
/* article, aside, footer, header, hgroup, main, nav, section { */
/*     display: block; */
/* } */
</style>
</head>
<body>
<div class="footer">
  <div class="inner">
    <div class="mp_logo">
      <a href="/00_Main.jsp" class="btn-mp">푸드뷰</a>
<!--       <p class="subtitle">회사 소개말</p> -->
    </div>

    <nav class="links-external">
    
<!--       <ul class="list-links"> -->
<!--           <li> -->
<!--             <a href="#"> -->
<!--              	회사소개 -->
<!--             </a> -->
<!--           </li> -->
<!--       </ul> -->

      <ul class="list-links">
<!--             <li> -->
<!--               <a href="#" target="_blank"> -->
<!--                	 공지사항 -->
<!--               </a> -->
<!--             </li> -->

            <li>
              <a class="" href="/information/contract.jsp" onclick="common_ga('PG_FOOTER', 'CLICK_TERMS', 'contract')" target="_blank">
               	 이용약관
              </a>
            </li>
            <li>
              <a class="" href="/information/contract_non_signup.jsp" target="_blank">
               	 비회원 이용자 이용정책
              </a>
            </li>
            <li>
              <a class="bold" href="/information/privacy.jsp" target="_blank">
                	개인정보처리방침
              </a>
            </li>
            <li>
              <a class="" href="/information/community_guide.jsp" target="_blank">
                	커뮤니티 가이드라인
              </a>
            </li>
<!--             <li> -->
<!--               <a href="/01_faqWrite.jsp"> -->
<!--                	 문의하기 -->
<!--               </a> -->
<!--             </li> -->
      </ul>
    </nav>


    <div class="language-copyrights">
      <p>
        <p>
          ㈜ 푸드뷰  | 사업자 등록번호: 000-00-00000 |
          서울특별시 강남구 역삼동 85길 22, 4층<br>
          <span class="copyrights">© 2018 FoodView Co., Ltd. All rights reserved.</span>
        </p>
      </p>
    </div>
  </div>
</div>
</body>
</html>