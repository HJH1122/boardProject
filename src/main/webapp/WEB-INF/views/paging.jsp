<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>paging</title>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
 <div class="container" id="detail">

    <table class="table table-hover">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.id}</td>
                <td>
                    <a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a>
                </td>
                <td>${board.boardWriter}</td>
                <td><fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                <td>${board.boardHits}</td>
            </tr>
        </c:forEach>
    </table>


        <c:choose>
            <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
            <c:when test="${paging.page<=1}">
                    <a>[이전]</a>
            </c:when>
            <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
            <c:otherwise>
                    <a href="/board/paging?page=${paging.page-1}">[이전]</a>
            </c:otherwise>
        </c:choose>

        <%--  for(int i=startPage; i<=endPage; i++)      --%>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
            <c:choose>
                <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
                <c:when test="${i eq paging.page}">
                        <span>${i}</span>
                </c:when>

                <c:otherwise>
                        <a href="/board/paging?page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${paging.page>=paging.maxPage}">
                    <a>[다음]</a>
            </c:when>
            <c:otherwise>
                    <a href="/board/paging?page=${paging.page+1}">[다음]</a>
            </c:otherwise>
        </c:choose>
        
        <button onclick="save()" style="float: right;">글작성</button>
 </div>
</body>
<script type="text/javascript">
	const save = () => {
        
        location.href = "/board/save";
    }
</script>
</html>